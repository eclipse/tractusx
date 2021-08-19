# Terraform scripts

Terraform scripts to deploy the Catena-X PoC infrastructure on Microsoft Azure.

## Prerequisites

The following tools need to be installed on your system where you run the scripts:
- [Kubectl](https://kubernetes.io/docs/tasks/tools/)
- [Helm](https://helm.sh/docs/intro/install/)
- [Terraform](https://learn.hashicorp.com/tutorials/terraform/install-cli)
- [Azure CLI](https://docs.microsoft.com/en-us/cli/azure/install-azure-cli)

## Quick start

Run the following commands to deploy the PoC infrastructure:

1. Sign-on to Azure and select the target subscription for the PoC landscape with `az login`
1. From the main directory of this repository, run `terraform init`
1. Run `terraform plan`
1. Run `terraform apply`
1. Need to change the admin azure ad group in the cluster configuration https://portal.azure.com/#@swbtsishowcaseoutlook.onmicrosoft.com/resource/subscriptions/f917eb77-210c-4089-ab3c-bb36b8819d84/resourceGroups/tsicatenax-dev-rg/providers/Microsoft.ContainerService/managedClusters/tsicatenax-dev-aks-services/configurationBlade to an existing AAD group (no matter what IAM says)
1. Run `az aks update -n tsicatenax-dev-aks-services -g tsicatenax-dev-rg --attach-acr tsicatenaxdevacr`
1. Run `az storage account create --name tsicatenaxstorage --resource-group tsicatenax-dev-rg`
1. Run `az storage account show-connection-string --name tsicatenaxstorage --resource-group tsicatenax-dev-rg`
1. Run `az storage account show-connection-string --name tsicatenaxstorage --resource-group tsicatenax-dev-rg`
1. RUN `az postgres db create -g tsicatenax-dev-rg -s tsicatenaxdevdb -n partsmasterdata` 
1. Run `az aks get-credentials --resource-group tsicatenax-dev-rg --name tsicatenax-dev-aks-services`

1. Deploy the CA cluster issuer for TLS with `kubectl apply -f cluster-issuer.yaml`
1. Create storage account tsicatenaxstorage with NFS support in tsicatenax-dev-rg
