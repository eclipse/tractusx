variable "name" {
  type        = string
  description = "Name of the instance of application insights. Lowercase letters only."
}

variable "location" {
  type        = string
  description = "Azure region where to create resources."
}

variable "resource_group_name" {
  type        = string
  description = "Resource group to deploy in."
}

variable "type" {
  type        = string
  description = "They type of application insights to be created."
  default     = "web"
}
