# dataspace-connector

![Version: 0.1.9](https://img.shields.io/badge/Version-0.1.9-informational?style=flat-square) ![Type: application](https://img.shields.io/badge/Type-application-informational?style=flat-square) ![AppVersion: 6.2.0](https://img.shields.io/badge/AppVersion-6.2.0-informational?style=flat-square)

A Helm chart for [IDS Dataspace Connector](https://github.com/International-Data-Spaces-Association/DataspaceConnector/tree/main/charts/dataspace-connector).

## Requirements

| Repository | Name | Version |
|------------|------|---------|
| https://charts.bitnami.com/bitnami | postgresql | 10.4.6 |

## Values

| Key | Type | Default | Description |
|-----|------|---------|-------------|
| "keystore.p12" | string | `""` | Keystore file can be provided with `--set-file 'keystore\.p12'=<path_to_your_keystore_file>` |
| "truststore.p12" | string | `""` | Truststore file can be provided with `--set-file 'truststore\.p12'=<path_to_your_truststore_file>` |
| affinity | object | `{}` | Affinity configuration |
| certificate.certManagerCert.issuer.kind | string | `"ClusterIssuer"` | Cert-manager issuer type |
| certificate.certManagerCert.issuer.name | string | `"letsencrypt-staging"` | Cert-manager issuer name |
| certificate.create | bool | `false` | Configures usage of cert-manager. If set to `true` certificate will be issued with cert-manager and used in connector. If set to `false`, then existing certificate will be used. Check "truststore.p12" and "keystore.p12" sections description for configuring existing certificates |
| certificate.dnsName | string | `"idsa.westeurope.cloudapp.azure.com"` | DNS name for which certificate is issued. Used to configure ingress and connector |
| env.config.CERTIFICATE_PATH | string | `"/var/run/certs/"` | Path to directory with certificates |
| env.config.CONFIGURATION_DIR | string | `"/etc/dataspace-connector/"` | Path to directory where all configuration files are stored |
| env.config.CONFIGURATION_PATH | string | `"/etc/dataspace-connector/config.json"` | Path to `config.json` file |
| env.config.DAPS_KEY_URL | string | `"http://51.137.19.207/daps/v2/.well-known/jwks.json"` | URI to DAPS server jwks keys endpoint |
| env.config.DAPS_KEY_URL_KID | string | `"{'http://51.137.19.207/daps/v2/.well-known/jwks.json':'default'}"` | URI to DAPS server jwkd keys endpoin |
| env.config.DAPS_TOKEN_URL | string | `"http://51.137.19.207/daps/v2/token"` | URI to DAPS server token endpoint |
| env.config.DAPS_URL | string | `"http://51.137.19.207/daps/v2/"` | URI to DAPS server |
| env.config.DEPLOY_MODE | string | `"idsc:PRODUCTIVE_DEPLOYMENT"` | Connectore deploy mode. Can be `idsc:PRODUCTIVE_DEPLOYMENT` or `idsc:TEST_DEPLOYMENT` |
| env.config.KEYSTORE_FILENAME | string | `"keystore.p12"` |  |
| env.config.LOGGING_CONFIG | string | `"file:///etc/dataspace-connector/log4j2.xml"` | Path to `log4j2.xml` to configure logging. File will be mounted to `CONFIGURATION_DIR` folder. |
| env.config.SERVER_SSL_ENABLED | bool | `true` | Enables SSL if `true`. Disables SSL if `false`. |
| env.config.SPRING_CONFIG_LOCATION | string | `"file:///etc/dataspace-connector/application.properties"` | Path to `application.properties` file. File will be mounted to `CONFIGURATION_DIR` folder. |
| env.config.TRUSTSTORE_FILENAME | string | `"truststore.p12"` |  |
| env.secrets.KEYSTORE_PASSWORD | string | `"password"` | Password to use with provided `keystore.p12` file. Password for default keystore is `password` |
| env.secrets.SPRING_SECURITY_APP_PASSWORD | string | `"password1"` | Password to access connector api |
| env.secrets.SPRING_SECURITY_USER_PASSWORD | string | `"password1"` | Username to access connector api |
| env.secrets.TRUSTSTORE_PASSWORD | string | `"password"` | Password to use with provided `truststore.p12` file. Password for default truststore is `password` |
| image.pullPolicy | string | `"Always"` | Pod pull policy |
| image.repository | string | `"ghcr.io/international-data-spaces-association/dataspace-connector"` | Dataspace connector Docker image |
| image.tag | string | `""` | Dataspcace connector Docker image tag. If not set, Chart AppVersion will be used |
| imagePullSecrets | list | `[]` | Secret with dockerconfig.json file to pull image from private container registry |
| ingress.annotations | object | `{}` | Ingress additional annotations |
| ingress.enabled | bool | `false` | If set to `false`, ingress will not be configured. If set to `true`, service will be exposed with `certificate.dnsName` name |
| ingress.rootPath | string | `""` | Path prefix for ingress configuration. If empty then `/` path will be used |
| nodeSelector | object | `{}` | Node selector labels |
| podAnnotations | object | `{}` | Additional pod annotations |
| podSecurityContext | object | `{}` | Pod security context configuration |
| postgresql.postgresqlDatabase | string | `"test"` | PostgreSQL instance DB name |
| postgresql.postgresqlPassword | string | `"username"` | PostgreSQL instance password |
| postgresql.postgresqlUsername | string | `"password"` | PostgreSQL instance username |
| postgresql.service.port | string | `"5432"` | PostgreSQL instance service port |
| replicaCount | int | `1` | Connector replicas count |
| resources | object | `{}` | Resources usege and limits configuration |
| securityContext | object | `{}` | Security context configuration |
| service.port | int | `8080` | Service port |
| service.type | string | `"ClusterIP"` | Service type |
| tolerations | list | `[]` | Pod toleration configuration |

----------------------------------------------
Autogenerated from chart metadata using [helm-docs v1.5.0](https://github.com/norwoodj/helm-docs/releases/v1.5.0)
