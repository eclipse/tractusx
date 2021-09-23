resource "random_password" "postgresql_admin" {
  length           = 16
  special          = true
  override_special = "!@#$%*()-_=+[]:?" # use only characters that Terraform doesn't escape in JSON output (user-friendly)
}

resource "azurerm_postgresql_server" "main" {
  name                = var.name
  location            = var.location
  resource_group_name = var.resource_group_name

  sku_name = "GP_Gen5_4"

  storage_mb                   = 5120
  backup_retention_days        = 7
  geo_redundant_backup_enabled = false
  auto_grow_enabled            = true

  administrator_login          = "psqladmin"
  administrator_login_password = resource.random_password.postgresql_admin.result
  version                      = "11"
  ssl_enforcement_enabled      = true
}

resource "azurerm_postgresql_firewall_rule" "main" {
  name                = "${var.name}-network-rule"
  resource_group_name = var.resource_group_name
  server_name         = azurerm_postgresql_server.main.name
  start_ip_address    = "0.0.0.0"
  end_ip_address      = "0.0.0.0" # The range "0.0.0.0-0.0.0.0" is a special value: Allow access to Azure services
}

resource "azurerm_postgresql_database" "main" {
  name                = var.database_name
  resource_group_name = var.resource_group_name
  server_name         = azurerm_postgresql_server.main.name
  charset             = "UTF8"
  collation           = "English_United States.1252"
}
