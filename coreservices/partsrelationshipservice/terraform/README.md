# Terraform code

Terraform scripts to deploy the PRS infrastructure on Microsoft Azure.

As you can see in `version.tf`, the terraform state is persisted in a storage account. The storage account and the container have been created manually.

## Prerequisites

The following tools need to be installed on your system where you run the scripts:
- [Kubectl](https://kubernetes.io/docs/tasks/tools/)
- [Helm](https://helm.sh/docs/intro/install/)
- [Terraform](https://learn.hashicorp.com/tutorials/terraform/install-cli)
- [Azure CLI](https://docs.microsoft.com/en-us/cli/azure/install-azure-cli)

## Quick start

Run the following commands to deploy the PoC infrastructure:

1. Sign-on to Azure and select the target subscription for the PoC landscape with `az login --tenant <catenax-tenant>`
1. Check whether the variables for your target environment have been correctly set `cat variables.tf`
1. From the main directory of this repository, run `terraform init`
1. Run `terraform plan`
1. Run `terraform apply`

## Viewing outputs

NB: this section is referenced from [Confluence: Browsing the database](https://confluence.catena-x.net/display/CXM/Browsing+the+database).

To see the outputs stored in the Terraform state, do the following:

1. Follow the steps above up to `terraform init`
1. Run `terraform output -json`

Note that some of these values are sensitive and should not be disclosed.
