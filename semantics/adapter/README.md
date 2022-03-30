<!---
Copyright (c) 2021-2022 T-Systems International GmbH (Catena-X Consortium)

See the AUTHORS file(s) distributed with this work for additional
information regarding authorship.

See the LICENSE file(s) distributed with this work for
additional information regarding license terms.
-->

The Digital Twin & Semantic Layer is a logical and architectural component of Catena-X.
The source code under this folder is a blueprint (aka Simple [Semantic] Adapter) demonstrating how to build a semantically-enabled 
twin & data provider.

## Building, Running and Deployment

### Build Packages:

Run `mvn install` to run unit tests, build and install the package (and submodules)

### Build & Run Package Locally:

Run `./run_local.sh` to run the semantic adapter.

The run script accepts the following command line options:
- '-clean' runs a cleanup when in build mode
- '-build' runs submodule maven before start
- '-suspend' suspends the java machine upon startup when in debugging mode.
- '-debug' allows the java machine to be debugged (debugging port is outputed on console)
- '-proxy' uses environment variables $HTTP_PROXY_HOST and $HTTP_PROXY_PORT to set the standard Java proxy for both http and https transports.
 
### Build Docker:

Run `cd ..;docker build -f ./adapter/Dockerfile -t $CONTAINER_REGISTRY/semantics/adapter:$VERSION .;cd ..`
RUN `docker push $CONTAINER_REGISTRY/semantics/adapter:$VERSION`

where $CONTAINER_REGISTRY is set to the target container/docker repository (like `tsicatenaxdevacr.azurecr.io`) and $VERSION is set to the 
deployment version (usually `latest`).

### Redeploy in target environment

Run `kubectl rollout restart deployment adapter -n semantics`

## Configuring the Adapter

The Simple Adapter is configured by editing (or extending via a separate profile) the [configuration yml](src/main/resources/application.yml).

The configuration file has several paragraphs which we shortly describe here

### General Settings

The preamble of the configuration file deals with general java & spring boot settings:

- server.port: Determines the port under which the embedded web server is running
- server.ssl: Usually disabled since the adapter will be most likely deployed as a container behind an ssl-terminating ingress.
- http: Diverse timeout settings of the embedded web server
- spring.security: Enable security debug logs
- spring.sql: Configure the builtin database (which may contain test data)
- spring.servlet: Set memory limits on the messages allowed to be processed
- spring.h2.console: A builtin SQL console which maybe used to inspect the attached database at runtime.
- spring.jackson: How JSON payloads are parsed and serialized
- springdoc: Whether and how an OpenAPI self-description of the adapter will be present
- management: Enable/Disable additional endpoints for healthchecks and information

### Adapter-Specific Settings (idsadapter)

All adapter-specific settings are residing under the "idsadapter" prefix:
- connectorType: Can be "dsc" for attaching to Fraunhofer Dataspace Connector and "edc" for attaching to Eclipse Dataspace Connector
- connectorHost: Should be the hostname followed by a colon-separated port number under which the control plane of the Dataspace Connector can be reached
- connectorProtocol: Can be "http" or "https"
- connectorUser: Either the username for basic auth or "X-Api-Key" in case that an api-key method is used to authenticate against the Dataspace Connector
- connectorPassword: Either the password or the API key depending on the method
- publisher: urn/url of the adapter provider
- serviceUrl: URL of the AAS registry where twins should be registered
- adapterUrl: URL under which this Adapter can be reached from the outside. If running on localhost, this maybe http://localhost:${server.port}. If behind an ingress, this should be the path under which this service is routed.
- callbackPattern: An expression which is only used in "dsc" mode for the connector callback
- registerOnStart: When this flag is true, the offerings, contracts and digital twins will be auto-registered at startup of the adapter. Else theys must be published using the provided endpoints individually.

### Security (idsadapter.security)

When started with the "basic" profile, the simple adapter will use http basic auth method for authentication.
- security.debug: switched on/off web security debugging
- security.users: maps usernames to their secrets and roles
- security.filters: maps regular expressions for request paths to the required roles. The special roles "ANONYMOUS" and "AUTHENTICATED" can be referred to to permit access to any (un-)authenticated request. 

### Catalogs (idsadapter.catalogs)

When running in "dsc" mode, all offers will be published under the associated catalogs.

### Contracts (idsadapter.contracts)

In the case of "dsc", these will be proper contracts (referred by the offers).
In the case of "edc", these will be created as contract definitions which link to all offers which have already been published so far.
If a new offer will be published, the contract definition may hence need to be republished.

### Offers (idsadapter.offers)

Dataspace Offers are described in three levels:
- Offer meta-data 
  - the associated contract
- Representation (submodel) meta-data 
  - the semantic model and payload media type
- Artifact meta-data 
  - refers the actual protocol (FILE|SQL|FUNCTION) and 
  - a command (file reference, sql procedure or function pointer)

Under EDC, submodels/representations typically only have a single "default" artifact (except for operations in which case the 
submodel-entry corresponds to the artifact name).

### Commands (idsadapter.commands)

In case of FILE and SQL protocols, the commands can be specified in this section.

For FILE, the command consists of
- A spring expression for resolving the actual file (in classpath, on disk or via external URL)
- An additional model reference which describes the semantic model of the FILE
- the media type is automatically determined by the file suffix (xml or json)

For SQL, the command consists of
- An parameterized SQL query whose parameters are bound to the request parameters of the submodel/artifact request.

### Transformations (idsadapter.transformationParameters and idsadapter.transformations)

When the Simple Adapter executes a command, it automatically tries to match the provided semantic model and media type to the 
target media type/semantic model from the request artifact (see above).

For all text formats, it may replace certain placeholders against actual request parameters. This is specified in
the idsadapter.transformationParameters section.

For all xml source formats, it may use on the stylesheets which are listed in the idsadapter.transformations section. Each entry there describes
- A spring expression for resolving the actual stylesheet
- A source semantic model (the source mediatype is already fixed to xml)
- A target semantic model
- A target media type

### Digital Twins (idsadapter.twinSources)

Finally, the actual twins (or asset administration shells) are transformed out of the protocol adapters quite in the same way than actual
payload data is processed/requested. While being able to interact with various source models and media types, the target
model (https://admin-shell.io/aas/API/AssetAdministrationShellDescriptor/1/0/RC02) and mediatype (json) is fixed this time.
