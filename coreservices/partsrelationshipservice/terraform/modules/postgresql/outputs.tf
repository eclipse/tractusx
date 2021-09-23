output "fqdn" {
  value       = azurerm_postgresql_server.main.fqdn
  description = "The PostgreSQL FQDN."
}

output "administrator_username" {
  value       = "${azurerm_postgresql_server.main.administrator_login}@${azurerm_postgresql_server.main.name}"
  description = "The administrator user login name."
}

output "administrator_login_password" {
  value       = azurerm_postgresql_server.main.administrator_login_password
  description = "The administrator user password."
  sensitive   = true
}

output "db_name" {
  value       = azurerm_postgresql_database.main.name
  description = "The PostgreSQL database name."
}

