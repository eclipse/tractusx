resource "azurerm_eventhub" "main" {
  name                = var.name
  namespace_name      = var.eventhub_namespace_name
  resource_group_name = var.resource_group_name
  partition_count     = var.partition_count
  message_retention   = var.message_retention
}

resource "azurerm_eventhub_authorization_rule" "receive" {
  name                = "Listen"
  namespace_name      = var.eventhub_namespace_name
  eventhub_name       = azurerm_eventhub.main.name
  resource_group_name = var.resource_group_name
  listen              = true
  send                = false
  manage              = false
}

resource "azurerm_eventhub_authorization_rule" "send" {
  name                = "Send"
  namespace_name      = var.eventhub_namespace_name
  eventhub_name       = azurerm_eventhub.main.name
  resource_group_name = var.resource_group_name
  listen              = false
  send                = true
  manage              = false
}
