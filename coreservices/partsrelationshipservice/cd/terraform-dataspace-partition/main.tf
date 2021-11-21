####################################################################################################
# PRS infrastructure
####################################################################################################

data "azurerm_application_insights" "main" {
  name                = var.application_insights_name
  resource_group_name = data.azurerm_resource_group.main.name
}

module "prs_postgresql" {
  source              = "./modules/postgresql"
  name                = "${var.prefix}-${var.environment}-${var.dataspace_partition}-prs-psql"
  database_name       = "prs"
  resource_group_name = local.resource_group_name
  location            = local.location
}

module "eventhubs_namespace" {
  source              = "./modules/eventhubs_namespace"
  name                = "${var.prefix}-${var.environment}-${var.dataspace_partition}-prs-ehub"
  resource_group_name = local.resource_group_name
  location            = local.location
}

module "eventhub_catenax_events" {
  source                                     = "./modules/eventhub"
  eventhub_namespace_name                    = module.eventhubs_namespace.name
  name                                       = "catenax_events"
  resource_group_name                        = local.resource_group_name
  location                                   = local.location
  capture_storage_account_name               = "${var.prefix}${var.environment}${var.dataspace_partition}msg"
  receive_and_send_primary_connection_string = module.eventhubs_namespace.receive_and_send_primary_connection_string
}

# create namespace for PRS
resource "kubernetes_namespace" "prs" {
  metadata {
    name = "prs-${var.dataspace_partition}"
  }
}

locals {
  ingress_prefix                    = "/${var.dataspace_partition}/mtpdc"
  ingress_prefix_prs                = "${local.ingress_prefix}/prs"
  ingress_prefix_connector_provider = "${local.ingress_prefix}/connector"
  api_url                           = "https://${var.ingress_host}${local.ingress_prefix_prs}"
}

# Deploy the PRS service with Helm
resource "helm_release" "prs" {
  name      = "prs-${var.dataspace_partition}"
  chart     = "../helm/prs"
  namespace = kubernetes_namespace.prs.metadata[0].name
  timeout   = 300

  set {
    name  = "ingress.host"
    value = var.ingress_host
  }

  set {
    name  = "ingress.className"
    value = var.ingress_class_name
  }

  set {
    name  = "ingress.prefix"
    value = local.ingress_prefix_prs
  }

  set {
    name  = "prs.image.repository"
    value = "${var.image_registry}/prs-api"
  }

  set {
    name  = "prs.image.tag"
    value = var.image_tag
  }

  set {
    name  = "prs.apiUrl"
    value = local.api_url
  }

  set {
    name  = "brokerproxy.image.repository"
    value = "${var.image_registry}/broker-proxy"
  }

  set {
    name  = "brokerproxy.image.tag"
    value = var.image_tag
  }

  set_sensitive {
    name  = "applicationInsights.connectionString"
    value = data.azurerm_application_insights.main.connection_string
  }

  set {
    name  = "eventHubs.name"
    value = module.eventhub_catenax_events.eventhub_name
  }

  set {
    name  = "eventHubs.namespace"
    value = module.eventhubs_namespace.name
  }

  set_sensitive {
    name  = "eventHubs.sendConnectionString"
    value = module.eventhub_catenax_events.send_primary_connection_string
  }

  set_sensitive {
    name  = "eventHubs.receiveConnectionString"
    value = module.eventhub_catenax_events.receive_primary_connection_string
  }

  set {
    name  = "postgresql.url"
    value = "jdbc:postgresql://${module.prs_postgresql.fqdn}/${module.prs_postgresql.db_name}?sslmode=require"
  }

  set {
    name  = "postgresql.postgresqlUsername"
    value = module.prs_postgresql.administrator_username
  }

  set_sensitive {
    name  = "postgresql.postgresqlPassword"
    value = module.prs_postgresql.administrator_login_password
  }
}

# Deploy the PRS Provider with Helm
resource "helm_release" "prs-connector-provider" {
  name      = "prs-${var.dataspace_partition}-prs-connector-provider"
  chart     = "../helm/prs-connector-provider"
  namespace = kubernetes_namespace.prs.metadata[0].name
  timeout   = 300

  set {
    name  = "ingress.host"
    value = var.ingress_host
  }

  set {
    name  = "ingress.className"
    value = var.ingress_class_name
  }

  set {
    name  = "ingress.prefix"
    value = local.ingress_prefix_connector_provider
  }

  set {
    name  = "image.repository"
    value = "${var.image_registry}/prs-connector-provider"
  }

  set {
    name  = "image.tag"
    value = var.image_tag
  }

  set_sensitive {
    name  = "applicationInsights.connectionString"
    value = data.azurerm_application_insights.main.connection_string
  }

  set {
    name  = "prs.apiUrl"
    value = local.api_url
  }
}
