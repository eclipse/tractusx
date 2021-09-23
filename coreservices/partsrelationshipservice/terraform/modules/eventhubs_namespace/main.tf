resource "azurerm_eventhub_namespace" "main" {
  name                = var.name
  location            = var.location
  resource_group_name = var.resource_group_name
  sku                 = "Standard"
  capacity            = var.capacity
}