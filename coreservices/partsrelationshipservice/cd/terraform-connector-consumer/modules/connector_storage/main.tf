# Retrieve identity information for the current logged-in user
data "azurerm_client_config" "current" {}

# Retrieve the Key Vault for storing generated identity information and credentials
data "azurerm_key_vault" "identities" {
  name                = "${var.prefix}-${var.environment}-prs-id"
  resource_group_name = "catenax-terraform"
}

# Retrieve the prs_connector_consumer_object_id secret.
data "azurerm_key_vault_secret" "prs_connector_consumer_object_id" {
  name         = "prs-connector-consumer-object-id"
  key_vault_id = data.azurerm_key_vault.identities.id
}

# Contains Azure storage account key and container sas tokens.
# Consumer will create containers and store the container sas token during provisioning.
resource "azurerm_key_vault" "consumer-vault" {
  name                        = "${var.prefix}-${var.environment}-consumer"
  location                    = var.location
  resource_group_name         = var.resource_group_name
  enabled_for_disk_encryption = false
  tenant_id                   = data.azurerm_client_config.current.tenant_id
  soft_delete_retention_days  = 7
  purge_protection_enabled    = false

  sku_name                  = "standard"
  enable_rbac_authorization = true
}

# Storage Account used for exchanging data between the EDC Provider and EDC Consumer.
resource "azurerm_storage_account" "consumer-dataexchange" {
  name                     = "${var.prefix}${var.environment}consumer"
  resource_group_name      = var.resource_group_name
  location                 = var.location
  account_tier             = "Standard"
  account_replication_type = "LRS"
  account_kind             = "StorageV2"
}

# Store the Primary key for the connector Storage Account. This is required by the `azure.blob.provision` EDC extension.
resource "azurerm_key_vault_secret" "consumer-dataexchange-account-key" {
  name         = "${azurerm_storage_account.consumer-dataexchange.name}-key1"
  value        = azurerm_storage_account.consumer-dataexchange.primary_access_key
  key_vault_id = azurerm_key_vault.consumer-vault.id
  depends_on   = [azurerm_role_assignment.consumer-vault-current-user]
}

# Role assignment so that the PRS Consumer primary identity may access the vault.
resource "azurerm_role_assignment" "primary-id" {
  scope                = azurerm_key_vault.consumer-vault.id
  role_definition_name = "Key Vault Secrets Officer"
  principal_id         = data.azurerm_key_vault_secret.prs_connector_consumer_object_id.value
}

# Role assignment so that the currently logged in user may access the vault, needed to add secrets.
resource "azurerm_role_assignment" "consumer-vault-current-user" {
  scope                = azurerm_key_vault.consumer-vault.id
  role_definition_name = "Key Vault Secrets Officer"
  principal_id         = data.azurerm_client_config.current.object_id
}
