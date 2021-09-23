output "connection_string" {
  value       = azurerm_application_insights.main.connection_string
  sensitive   = true
  description = "The Connection String for Application Insights"
}
