# Configure the Azure provider
terraform {
  required_providers {
    azuread = {
      source  = "hashicorp/azuread"
      version = "2.9.0"
    }
    azurerm = {
      source  = "hashicorp/azurerm"
      version = "2.60.0"
    }
  }

  # Persist state in a storage account
  backend "azurerm" {
    resource_group_name  = "catenax-terraform"
    storage_account_name = "catenaxterraformstate"
    container_name       = "tfstate"
    # Key may be overriden with "terraform init -backend-config=key=${TERRAFORM_STATE_KEY}"
    key = "prs.identities.dev.terraform.tfstate"
  }

  required_version = "~> 1.0"
}

provider "azuread" {
  # Configuration options
}

provider "azurerm" {
  features {
    key_vault {
      purge_soft_delete_on_destroy    = true
      recover_soft_deleted_key_vaults = true
    }
  }
}

data "azurerm_resource_group" "main" {
  name = var.resource_group_name
}

locals {
  resource_group_name = data.azurerm_resource_group.main.name
  location            = data.azurerm_resource_group.main.location
}
