terraform {
  required_providers {
    azurerm = {
      source  = "hashicorp/azurerm"
      version = "2.60.0"
    }

    helm = {
      source  = "hashicorp/helm"
      version = "2.1.2"
    }
  }

  # Persist state in a storage account
  backend "azurerm" {
    resource_group_name  = "catenax-terraform"
    storage_account_name = "catenaxterraformstate"
    container_name       = "tfstate"
    key                  = "prs.prs.dev.terraform.tfstate"
  }

  required_version = "~> 1.0"
}

provider "azurerm" {
  features {}
}

data "azurerm_resource_group" "main" {
  name = var.resource_group_name
}

data "azurerm_kubernetes_cluster" "main" {
  name                = var.aks_cluster_name
  resource_group_name = data.azurerm_resource_group.main.name
}

locals {
  resource_group_name = data.azurerm_resource_group.main.name
  location            = data.azurerm_resource_group.main.location
}

provider "kubernetes" {
  host                   = data.azurerm_kubernetes_cluster.main.kube_admin_config.0.host
  username               = data.azurerm_kubernetes_cluster.main.kube_admin_config.0.username
  password               = data.azurerm_kubernetes_cluster.main.kube_admin_config.0.password
  client_certificate     = base64decode(data.azurerm_kubernetes_cluster.main.kube_admin_config.0.client_certificate)
  client_key             = base64decode(data.azurerm_kubernetes_cluster.main.kube_admin_config.0.client_key)
  cluster_ca_certificate = base64decode(data.azurerm_kubernetes_cluster.main.kube_admin_config.0.cluster_ca_certificate)
}

provider "helm" {
  debug = true
  kubernetes {
    host                   = data.azurerm_kubernetes_cluster.main.kube_admin_config.0.host
    username               = data.azurerm_kubernetes_cluster.main.kube_admin_config.0.username
    password               = data.azurerm_kubernetes_cluster.main.kube_admin_config.0.password
    client_certificate     = base64decode(data.azurerm_kubernetes_cluster.main.kube_admin_config.0.client_certificate)
    client_key             = base64decode(data.azurerm_kubernetes_cluster.main.kube_admin_config.0.client_key)
    cluster_ca_certificate = base64decode(data.azurerm_kubernetes_cluster.main.kube_admin_config.0.cluster_ca_certificate)
  }
}
