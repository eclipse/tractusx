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
2. Check whether the variables for your target environment have been correctly set `cat variables.tf`
3. From the main directory of this repository, run `terraform init`
4. Run `terraform plan`
5. Run `terraform apply`. If you only have contributor roles, the following error will appear:

As you can see in `version.tf`, the terraform state is persisted in a storage account. The storage account and the container have been created manually.

```
Error: authorization.RoleAssignmentsClient#Create: Failure responding to request: StatusCode=403 -- Original Error: autorest/azure: Service returned an error. Status=403 Code="AuthorizationFailed" Message="The client 'youraccount@example.com' with object id 'xxx' does not have authorization to perform action 'Microsoft.Authorization/roleAssignments/write' over scope '/subscriptions/speedboat-id/resourceGroups/catenacax1-dev-rg/providers/Microsoft.ContainerRegistry/registries/catenacax1devacr/providers/Microsoft.Authorization/roleAssignments/roleId' or the scope is invalid. If access was recently granted, please refresh your credentials."
```

1. Need to change the admin azure ad group in the cluster configuration https://portal.azure.com/#@swbtsishowcaseoutlook.onmicrosoft.com/resource/subscriptions/f917eb77-210c-4089-ab3c-bb36b8819d84/resourceGroups/tsicatenax-dev-rg/providers/Microsoft.ContainerService/managedClusters/tsicatenax-dev-aks-services/configurationBlade to an existing/valid AAD group (there will be an "anonymous" non-working group assigned per default)

1. Import environment and secret variables `source ../manifests/environment.sh`

1. Attach the container registry to the kubernetes cluster by `az aks update -n ${K8_RESOURCE_NAME} -g ${K8_RESOURCE_GROUP} --attach-acr ${CONTAINER_REGISTRY_SHORT}`. If you only have contributor roles, the following error will appear:

```
Waiting for AAD role to propagate[################################    ]  90.0000%Could not create a role assignment for ACR. Are you an Owner on this subscription?
```

1. Create a storage account with NFS support for tables and files by `az storage account create --name ${STORAGE_ACCOUNT_NAME} --resource-group ${K8_RESOURCE_GROUP}`
1. Get the connection string and put it into your secret.sh by `az storage account show-connection-string --name ${STORAGE_ACCOUNT_NAME} --resource-group ${K8_RESOURCE_GROUP}`
1. Create an additional database in an existing database service for persistence by `az postgres db create -g ${K8_RESOURCE_GROUP} -s ${POSTGRES_RESOURCE_NAME} -n partsmasterdata` 
1. Run `az acr login --resource-group ${K8_RESOURCE_GROUP}`

1. Deploy the CA cluster issuer for TLS with `cat client-issuer.yaml | envsubst | kubectl apply`
y