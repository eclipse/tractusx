<!---
Copyright (c) 2021-2022 T-Systems International GmbH (Catena-X Consortium)

See the AUTHORS file(s) distributed with this work for additional
information regarding authorship.

See the LICENSE file(s) distributed with this work for
additional information regarding license terms.
-->

# Digital Twin Registry
The Digital Twin Registry is a logical and architectural component of Catena-X.
The source code under this folder contains reference implementations of the SLDT Registry.

## Build Packages
The project requires a private package from https://maven.pkg.github.com/eclipse-dataspaceconnector/DataSpaceConnector.
Add the following configuration to your `.m2/settings.xml`:

```xml
<server>
    <id>edc-github</id>
    <username>oauth2</username>
    <password>$ADD_GITHUB_ACCESS_TOKEN_HERE</password>
</server>
```

You need to add your own GitHub Access Token. Navigate to https://github.com/settings/tokens and create a new token
with the permission `read:packages`.

Run `mvn install` to run unit tests, build and install the package.

## Run Package Locally
To check whether the build was successful, you can start the resulting JAR file from the build process by running `java -jar target/registry-{current-version}.jar`.

## Build Docker
Run `docker build -t registry .`

In case you want to publish your image into a remote container registry, apply the tag accordingly and `docker push` the image.

## Deploy using Helm and K8s
If you have a running Kubernetes cluster available, you can deploy the Registry using our Helm Chart, which is located under `./deployment/registry`.
In case you don't have a running cluster, you can set up one by yourself locally, using [minikube](https://minikube.sigs.k8s.io/docs/start/).
In the following, we will use a minikube cluster for reference.

Before deploying the Registry, enable a few add-ons in your minikube cluster by running the following commands:

`minikube addons enable storage-provisioner`

`minikube addons enable default-storageclass`

`minikube addons enable ingress`

Fetch all dependencies by running `helm dep up deployment/registry`.

In order to deploy the helm chart, first create a new namespace "semantics": `kubectl create namespace semantics`.

Then run `helm install hub -n semantics ./deployment/semantic-hub`. This will set up a new helm deployment in the semantics namespace. By default, the deployment contains the Registry instance itself, and a Fuseki Triplestore.

Check that the two containers are running by calling `kubectl get pod -n semantics`.

To access the Registry API from the host, you need to configure the `Ingress` resource.
By default, the Registry includes an `Ingress` that exposes the API on https://minikube/semantics/hub

For that to work, you need to append `/etc/hosts` by running `echo "minikube $(minikube ip)" | sudo tee -a /etc/hosts`.

For automated certificate generation, use and configure [cert-manager](https://cert-manager.io/).
By default, authentication is deactivated, please adjust `hub.authentication` if needed

## Parameters
The Helm Chart can be configured using the following parameters (incomplete list). For a full overview, please see the [values.yaml](./deployment/semantic-hub/values.yaml).

### Registry
| Parameter       | Description | Default value       |
| ---             | ---         | ---                 |
| `registry.image`     | The registry and image of the Semantic Hub   | `semantic-hub:latest` |
| `registry.host`     | This value is used by the `Ingress` object (if enabled) to route traffic.   | `minikube` |
| `registry.authentication`     | Enables OAuth2 based authentication/authorization.   | `false` |
| `registry.idpIssuerUri`     | The issuer URI of the OAuth2 identity provider.   | `http://localhost:8080/auth/realms/catenax` |
| `registry.dataSource.driverClassName`     | The driver class name for the database connection.   | `org.postgresql.Driver` |
| `registry.dataSource.url`     | The url of the relational database (ignored if `enablePostgres` is set to `true`)   | `jdbc:postgresql://database:5432` |
| `registry.dataSource.user` (ignored if `enablePostgres` is set to `true`)    | The database user   | `user` |
| `registry.dataSource.password` (ignored if `enablePostgres` is set to `true`)     | The database password   | `org.postgresql.Driver` |
| `registry.ingress.enabled`     | Configures if an `Ingress` resource is created.   | `true` |
| `registry.ingress.tls`     | Configures whether the `Ingress` should include TLS configuration. In that case, a separate `Secret` (as defined by `registry.ingress.tlsSecretName`) needs to be provided manually or by using [cert-manager](https://cert-manager.io/)   | `true` |
| `registry.ingress.tlsSecretName`     | The `Secret` name that contains a `tls.crt` and `tls.key` entry. Subject Alternative Name must match the `registry.host`    | `hub-certificate-secret` |
| `registry.ingress.urlPrefix`     | The url prefix that is used by the `Ingress` resource to route traffic  | `/semantics/hub` |
| `registry.ingress.className`     | The `Ingress` class name   | `nginx` |
| `registry.ingress.annotations`     | Annotations to further configure the `Ingress` resource, e.g. for using with `cert-manager`.  |  |

### PostgreSQL
| Parameter       | Description | Default value       |
| ---             | ---         | ---                 |
| `postgresql.primary.persistence.size`     | Size of the `PersistentVolume` that persists the data  | `50Gi` |
| `postgresql.auth.username`     | Username that is used to authenticate at the database | `catenax` |
| `postgresql.auth.password`     | Password for authentication at the database  | `TFLIykCd4rUvSjbs` |
| `postgresql.auth.database`     | Database name  | `registry` |