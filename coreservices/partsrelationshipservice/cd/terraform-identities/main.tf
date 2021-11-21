# Retrieve the AAD Service Principal object for the GitHub Actions Terraform user
data "azuread_service_principal" "terraform_cd" {
  application_id = var.terraform_cd_principal_client_id
}

# Retrieve identity information for the current logged-in user
data "azuread_client_config" "current" {}

# Create central Key Vault for storing generated identity information and credentials
resource "azurerm_key_vault" "identities" {
  name                        = "${var.prefix}-${var.environment}-prs-id"
  resource_group_name         = local.resource_group_name
  location                    = local.location
  enabled_for_disk_encryption = false
  tenant_id                   = data.azuread_client_config.current.tenant_id
  soft_delete_retention_days  = 7
  purge_protection_enabled    = false

  sku_name                  = "standard"
  enable_rbac_authorization = true
}

# Role assignment so that the currently logged-in user may access the vault,
# needed to add secrets and certificates
resource "azurerm_role_assignment" "current-user-secrets" {
  scope                = azurerm_key_vault.identities.id
  role_definition_name = "Key Vault Secrets Officer"
  principal_id         = data.azuread_client_config.current.object_id
}
resource "azurerm_role_assignment" "current-user-certificates" {
  scope                = azurerm_key_vault.identities.id
  role_definition_name = "Key Vault Certificates Officer"
  principal_id         = data.azuread_client_config.current.object_id
}

# Generate a certificate to be used by the generated principal
resource "azurerm_key_vault_certificate" "prs-connector-consumer" {
  name         = "prs-connector-consumer-certificate"
  key_vault_id = azurerm_key_vault.identities.id

  certificate_policy {
    issuer_parameters {
      name = "Self"
    }

    key_properties {
      exportable = true
      key_size   = 2048
      key_type   = "RSA"
      reuse_key  = true
    }

    lifetime_action {
      action {
        action_type = "AutoRenew"
      }

      trigger {
        days_before_expiry = 30
      }
    }

    secret_properties {
      content_type = "application/x-pkcs12"
    }

    x509_certificate_properties {
      # Server Authentication = 1.3.6.1.5.5.7.3.1
      # Client Authentication = 1.3.6.1.5.5.7.3.2
      extended_key_usage = ["1.3.6.1.5.5.7.3.1"]

      key_usage = [
        "cRLSign",
        "dataEncipherment",
        "digitalSignature",
        "keyAgreement",
        "keyCertSign",
        "keyEncipherment",
      ]

      subject            = "CN=${local.resource_group_name}"
      validity_in_months = 12
    }
  }
  depends_on = [
    azurerm_role_assignment.current-user-certificates
  ]
}


# Generate an app registration to be used by the generated principal
resource "azuread_application" "prs-connector-consumer" {
  display_name = "CatenaX PRS Connector Consumer - ${var.environment}"
}

# Allow the app to authenticate with the generated principal
resource "azuread_application_certificate" "prs-connector-consumer" {
  type                  = "AsymmetricX509Cert"
  application_object_id = azuread_application.prs-connector-consumer.id
  value                 = azurerm_key_vault_certificate.prs-connector-consumer.certificate_data_base64
  end_date              = azurerm_key_vault_certificate.prs-connector-consumer.certificate_attribute[0].expires
  start_date            = azurerm_key_vault_certificate.prs-connector-consumer.certificate_attribute[0].not_before
}

# Generate a service principal
resource "azuread_service_principal" "prs-connector-consumer" {
  application_id               = azuread_application.prs-connector-consumer.application_id
  app_role_assignment_required = false
  tags = [
    "terraform"
  ]
}

# Store the client ID in the central Key Vault.
# Though the Client ID is not a sensitive value, is it convenient to manage it
# in the same place as its certificate.
resource "azurerm_key_vault_secret" "prs-connector-consumer-client-id" {
  name         = "prs-connector-consumer-client-id"
  value        = azuread_service_principal.prs-connector-consumer.application_id
  key_vault_id = azurerm_key_vault.identities.id
  depends_on = [
    azurerm_role_assignment.current-user-secrets
  ]
}
resource "azurerm_key_vault_secret" "prs-connector-consumer-object-id" {
  name         = "prs-connector-consumer-object-id"
  value        = azuread_service_principal.prs-connector-consumer.object_id
  key_vault_id = azurerm_key_vault.identities.id
  depends_on = [
    azurerm_role_assignment.current-user-secrets
  ]
}

# Grant read permissions on the key vault secrets to the GitHub Actions Terraform user.
# Note that the "Key Vault Secrets User" role also allows downloading (exportable) certificates.
resource "azurerm_role_assignment" "terraform-cd-secrets" {
  scope                = azurerm_key_vault.identities.id
  role_definition_name = "Key Vault Secrets User"
  principal_id         = data.azuread_service_principal.terraform_cd.object_id
}
