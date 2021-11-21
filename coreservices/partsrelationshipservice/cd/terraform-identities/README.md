# Provisioning identities for the PRS Connector

## About

This Terraform code will provision and store an identity and credential to be used by the PRS Connector Consumer for communicating with its Key Vault. As it requires elevated privileges, it is run manually rather than in a CD pipeline. This code deploys the following:

- An Azure Key Vault to securely store the generated credentials. Note that this is *not* the Key Vault to which the EDC Connector will connect, it is only meant to be accessed by the CD pipeline.
- An X.509 Certificate (stored in Azure Key Vault).
- An Application Registration and Service Principal used by the PRS Connector Consumer. The Certificate from Key Vault is set up to allow the principal to log in.
  - The Client ID and Object ID of the Service Principal are also stored in Azure Key Vault. Though they are not sensitive values, it is convenient for the Connector deployment pipeline to retrieve them from the same place as its certificate.

Note that the generated Certificate has a validity of one year. In a production deployment, a strategy would need to be put in place to deploy updated Certificates to existing deployments.

## Provisioning

You need to be logged into Azure CLI as a user with elevated Azure AD privileges, to generate and manage application registrations and service principals.

Verify the default values for the backend store in `versions.tf`, and for settings in `variables.tf`.

Deploy the configuration:

```sh
terraform init
terraform apply
```

## Verify credentials

You can verify the data was set up correctly as follows:

```sh
az keyvault secret download --file /tmp/cert.pfx --vault-name "$(terraform output -raw vault_name)" --name "$(terraform output -raw prs_connector_consumer_cert_name)" --encoding base64

openssl pkcs12 -in /tmp/cert.pfx -passin pass: -out /tmp/cert.pem -nodes

az login --service-principal --username "$(terraform output -raw prs_connector_consumer_client_id)" --password /tmp/cert.pem --tenant "$(terraform output -raw tenant_id)" --allow-no-subscriptions
```

If the last command succeeds, you have successfully authenticated with the client ID and certificate from Key Vault.

```sh
# Login again with your account
az login
```
