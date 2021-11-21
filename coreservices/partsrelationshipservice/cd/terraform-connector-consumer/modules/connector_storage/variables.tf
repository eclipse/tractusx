variable "resource_group_name" {
  type        = string
  description = "Resource group used to deploy resources."
}

variable "prefix" {
  type        = string
  description = "First part of name prefix used in naming resources. Use only lowercase letters and numbers."
}

variable "environment" {
  description = "Second part of name prefix used in naming resources. Use only lowercase letters and numbers."
}

variable "location" {
  type        = string
  description = "Azure region where to create resources."
}