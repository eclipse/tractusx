variable "name" {
  type        = string
  description = "Namespace name."
}

variable "location" {
  type        = string
  description = "Azure region where to create resources."
}

variable "resource_group_name" {
  type        = string
  description = "Resource group to deploy in."
}

variable "capacity" {
  type        = number
  default     = 1
  description = "Event hub namespace capacity."
}