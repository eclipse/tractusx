variable "name" {
  type        = string
  description = "Server name."
}

variable "location" {
  type        = string
  description = "Azure region where to create resources."
}

variable "resource_group_name" {
  type        = string
  description = "Resource group to deploy in."
}

variable "database_name" {
  type        = string
  description = "Database name."
}
