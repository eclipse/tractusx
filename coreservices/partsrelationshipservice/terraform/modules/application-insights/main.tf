resource "azurerm_application_insights" "main" {
  name                = var.name
  resource_group_name = var.resource_group_name
  location            = var.location
  application_type    = var.type
}
