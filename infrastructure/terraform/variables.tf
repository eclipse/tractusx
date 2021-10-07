####################################################################################################
# Global variables
####################################################################################################

variable "prefix" {
  type    = string
  default = "catenax"
}

variable "location" {
  type    = string
  default = "germanywestcentral"
}

variable "environment" {
  type    = string
  description = "Environment: dev<nnn>, int or prod"
  default = "dev001"
}

variable "azure_subscription_id" {
  description = "Subscription ID of the deployment principal"
  type = string
  default = null
}

variable "azure_client_id" {
  description = "Client ID of the deployment principal"
  type = string
  default = null
}

variable "azure_client_secret" {
  description = "Client Secret of the deployment principal"
  type = string
  default = null
}

variable "azure_tenant_id" {
  description = "Tenant ID of the deployment principal"
  type = string
  default = null
}

variable "aks_public_ssh_key" {
  description = "Path to the public ssh key file the kubernetes cluster should employ."
  type = string
}

variable "aks_admin_group_id" {
  description = "Default ID for catenax admin group"
  type = string
  default = "1ae80804-e856-4f2d-8b1e-03ea5651058f"
}

variable "azure_storage_access_key" {
  description = "Access key to the backend storage"
  type = string
}

variable "catenax_admin" {
  description = "Default username for catenax admins"
  type = string
}

variable "catenax_admin_password" {
  description = "Default password for catenax admins"
  type = string
}

variable "workspace_to_stage_map" {
  type = map
  default = {
    dev001  = "dev"
    dev002  = "dev"
    dev003  = "dev"
    dev042  = "dev"
    dev005  = "dev"
    dev006  = "dev"
    dev008  = "dev"
    dev009  = "dev"
    int     = "int"    
    prod    = "prod"
  }
}

variable "stage_to_size_map" {
  type = map
  default = {
    dev     = "small"
    int     = "medium"
    prod    = "large"
  }
}