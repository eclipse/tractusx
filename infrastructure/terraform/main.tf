####################################################################################################
# Shared infrastructure (resource group, monitoring, ...)
####################################################################################################

resource "azurerm_resource_group" "default_rg" {
  name     = "${var.prefix}-${var.environment}-rg"
  location = var.location

  tags = {
    environment = "${var.environment}"
  }
}

resource "azurerm_log_analytics_workspace" "shared" {
  name                = "${var.prefix}-${var.environment}-log"
  resource_group_name = azurerm_resource_group.default_rg.name
  location            = azurerm_resource_group.default_rg.location
  sku                 = "PerGB2018"
  retention_in_days   = 30

  tags = {
    environment = "${var.environment}"
  }
}

####################################################################################################
# Azure Virtual Networks
####################################################################################################

module "aks_vnet" {
  source              = "./modules/vnet"
  name                = "${var.prefix}-${var.environment}-aks-vnet"
  resource_group_name = azurerm_resource_group.default_rg.name
  location            = azurerm_resource_group.default_rg.location

  address_space = ["192.168.0.0/16"]
  subnets = [
    {
      name : "${var.prefix}-${var.environment}-aks-node-subnet"
      address_prefixes : ["192.168.1.0/24"]
    },
    {
      name : "${var.prefix}-${var.environment}-aks-ingress-subnet"
      address_prefixes : ["192.168.2.0/24"]
    }
  ]

  tags = {
    environment = "${var.environment}"
  }
}

####################################################################################################
# Azure Container Registry
###################################################################################################

resource "azurerm_container_registry" "acr" {
  name                = "${var.prefix}${var.environment}acr"
  resource_group_name = azurerm_resource_group.default_rg.name
  location            = azurerm_resource_group.default_rg.location
  sku                 = "Standard"
  admin_enabled       = true

  tags = {
    environment = "${var.environment}"
  }
}

####################################################################################################
# Azure Kubernetes Service (AKS): Service Cluster
####################################################################################################

module "aks_services" {
  source                           = "./modules/aks"
  resource_group_name              = azurerm_resource_group.default_rg.name
  location                         = azurerm_resource_group.default_rg.location
  # client_id                        = "your-service-principal-client-appid"
  # client_secret                    = "your-service-principal-client-password"
  kubernetes_version               = "1.19.11"
  orchestrator_version             = "1.19.11"
  prefix                           = "${var.prefix}-${var.environment}-aks-services"
  cluster_name                     = "${var.prefix}-${var.environment}-aks-services"
  dns_prefix                       = "${var.prefix}${var.environment}akssrv"
  network_plugin                   = "kubenet"
  
  enable_role_based_access_control = true
  rbac_aad_managed                 = true
  rbac_aad_admin_user_names        = ["a@b.com", "c@d.com"]
  rbac_aad_admin_group_object_id   = "d70b035a-3cc4-4ba0-a50d-9ba740da96ac"

  enable_http_application_routing  = false
  enable_azure_policy              = false
  enable_auto_scaling              = false
  node_resource_group              = "${var.prefix}-${var.environment}-node-rg"
  vnet_subnet_id                   = module.aks_vnet.subnet_ids["${var.prefix}-${var.environment}-aks-node-subnet"]
  os_disk_size_gb                  = 50
  agents_count                     = 2 # Please set `agents_count` `null` while `enable_auto_scaling` is `true` to avoid possible `agents_count` changes.
  agents_max_pods                  = 100
  agents_pool_name                 = "exnodepool"
  agents_availability_zones        = []
  agents_type                      = "VirtualMachineScaleSets"

  net_profile_pod_cidr             = "172.40.0.0/16"
  net_profile_dns_service_ip       = "172.41.0.10"
  net_profile_docker_bridge_cidr   = "172.42.0.1/16"
  net_profile_service_cidr         = "172.41.0.0/16"
  net_profile_outbound_type        = "loadBalancer"

  enable_log_analytics_workspace   = true
  log_analytics_workspace_id       = azurerm_log_analytics_workspace.shared.id
  log_analytics_workspace_name     = azurerm_log_analytics_workspace.shared.name

  tags = {
    environment = "${var.environment}"
  }

  depends_on = [module.aks_vnet]
}

# add the role to the identity the kubernetes cluster was assigned
resource "azurerm_role_assignment" "aks_to_acr" {
  scope                = azurerm_container_registry.acr.id
  role_definition_name = "AcrPull"
  principal_id         = module.aks_services.kubelet_identity.0.object_id
}

####################################################################################################
# NGINX Ingress with TLS
####################################################################################################

provider "kubernetes" {
  host                   = module.aks_services.kube_admin_config.0.host
  username               = module.aks_services.kube_admin_config.0.username
  password               = module.aks_services.kube_admin_config.0.password
  client_key             = base64decode(module.aks_services.kube_admin_config.0.client_key)
  client_certificate     = base64decode(module.aks_services.kube_admin_config.0.client_certificate)
  cluster_ca_certificate = base64decode(module.aks_services.kube_admin_config.0.cluster_ca_certificate)
}

# create namespace for NGINX ingress controller resources
resource "kubernetes_namespace" "ingress_nginx_namespace" {
  metadata {
    name = "ingress-nginx"
    labels = {
      "cert-manager.io/disable-validation" = "true"
    }
  }
}

# Create static public IP Address to be used by NGINX ingress controller
resource "azurerm_public_ip" "ingress_ip" {
  name                = "${var.prefix}-${var.environment}-ingress-pip"
  location            = azurerm_resource_group.default_rg.location
  resource_group_name = "${module.aks_services.node_resource_group}"
  sku                 = "Standard"
  allocation_method   = "Static"
  domain_name_label   = "${var.prefix}${var.environment}akssrv"
  
  tags = {
    environment = "${var.environment}"
  }
}

# Create static public IP Address to be used by the portal
resource "azurerm_public_ip" "portal_ip" {
  name                = "${var.prefix}-${var.environment}-portal-pip"
  location            = azurerm_resource_group.default_rg.location
  resource_group_name = "${module.aks_services.node_resource_group}"
  sku                 = "Standard"
  allocation_method   = "Static"
  domain_name_label   = "${var.prefix}${var.environment}aksportalsrv"
  
  tags = {
    environment = "${var.environment}"
  }
}


provider "helm" {
    debug = true
    kubernetes {
        host     = module.aks_services.kube_admin_config.0.host
        client_key             = base64decode(module.aks_services.kube_admin_config.0.client_key)
        client_certificate     = base64decode(module.aks_services.kube_admin_config.0.client_certificate)
        cluster_ca_certificate = base64decode(module.aks_services.kube_admin_config.0.cluster_ca_certificate)
    }  
}

# deploy NGINX ingress controller with Helm
resource "helm_release" "nginx_ingress" {
  name       = "ingress-nginx"
  chart      = "ingress-nginx"
  namespace  = kubernetes_namespace.ingress_nginx_namespace.metadata[0].name
  repository = "https://kubernetes.github.io/ingress-nginx"
  timeout    = 300
  
  set {
    name  = "controller.service.loadBalancerIP"
    value = "${azurerm_public_ip.ingress_ip.ip_address}"
  }
  set {
    name  = "controller.service.annotations.\"service\\.beta\\.kubernetes\\.io/azure-load-balancer-resource-group\""
    value = "${module.aks_services.node_resource_group}"
  }
  set {
    name  = "controller.service.annotations.\"service\\.beta\\.kubernetes\\.io/azure-dns-label-name\""
    value = "${var.prefix}${var.environment}akssrv"
  }

  depends_on = [module.aks_services, azurerm_public_ip.ingress_ip]
}

####################################################################################################
# cert-manager for TLS with Letsencrypt certificates
####################################################################################################

# create namespace for cert-manager resources
resource "kubernetes_namespace" "cert_manager_namespace" {
  metadata {
    name = "cert-manager"
    labels = {
      "cert-manager.io/disable-validation" = "true"
    }
  }
}

# Deploy cert-manager for TLS with Helm
resource "helm_release" "cert-manager" {
  name       = "cert-manager"
  chart      = "cert-manager"
  version    = "1.3.1"

  namespace  = kubernetes_namespace.cert_manager_namespace.metadata[0].name
  repository = "https://charts.jetstack.io"
  timeout    = 300
  
  set {
    name  = "installCRDs"
    value = "true"
  }
}

####################################################################################################
# Create namespaces for services
####################################################################################################

# Connector DNS
resource "kubernetes_namespace" "cdns_namespace" {
  metadata {
    name = "cdns"
  }
}

# Catena-X Portal
resource "kubernetes_namespace" "portal_namespace" {
  metadata {
    name = "portal"
  }
}