<!---
Copyright (c) 2021-2022 T-Systems International GmbH (Catena-X Consortium)

See the AUTHORS file(s) distributed with this work for additional
information regarding authorship.

See the LICENSE file(s) distributed with this work for
additional information regarding license terms.
-->

The Digital Twin & Semantic Layer is a logical and architectural component of Catena-X.
The source code under this folder helps to implement its modules in the form of blueprints/frameworks as well 
as concrete services.

If you are looking for semantic models (hosted or processed by this code), please refer to
[the Catena-X Model respository](https://github.com/catenax/BAMMmodels).

## Submodules of the Catena-X Digitial Twin & Semantic Layer

The Semantic layer is structured into the following packages/submodules:
- [Catena-X Semantic Framework](framework): A library for building your own semantic-enabled Catena-X components.
- [Catena-X Semantic Adapter](adapter): A sample adapter demonstrating how to build a semantically-enabled twin & data provider.
- Catena-X Semantic Services: Reference implementations of relevant semantic services:
  - [Digital Twin Registry](registry): implementing and federating [Asset Administration Shell APIs](http://idtwin.org)
  - [Semantic Hub](semantic-hub): based on the [BAMM Aspect Meta Model](https://openmanufacturingplatform.github.io/)

### Devops & Deployment:

The continuous-integration workflow is placed in [`../.github/workflows/semantics.yml`](../.github/workflows/semantics.yml)
The deployment scripts are placed in [`../infrastructure/manifests/semantics.yaml`](../infrastructure/manifests/semantics.yaml)

For concrete deployment/configuration options, see the Readme's of the respective submodules.

### Build Packages:

Run `mvn install` to run unit tests, build and install the package (and submodules)

### Build & Run Package Locally:

Run `./services/run_local.sh` to run the semantic services.

Run `./adapter/run_local.sh` to run the semantic adapter.

All run scripts accept the following command line options:
- '-clean' runs a cleanup when in build mode
- '-build' runs submodule maven before start
- '-suspend' suspends the java machine upon startup when in debugging mode.
- '-debug' allows the java machine to be debugged (debugging port is outputed on console)
 
### Build Docker:

Run `docker build -f ./services/Dockerfile -t $REGISTRY/semantics/services:$VERSION .`
RUN `docker push $REGISTRY/semantics/services:$VERSION`

Run `docker build -f ./adapter/Dockerfile -t $REGISTRY/semantics/adapter:$VERSION .`
RUN `docker push $REGISTRY/semantics/adapter:$VERSION`

where $REGISTRY is set to the target container/docker repository (like `tsicatenaxdevacr.azurecr.io`) and $VERSION is set to the 
deployment version (usually `latest`).

### Redeploy in target environment

Run `kubectl rollout restart deployment services -n semantics`
Run `kubectl rollout restart deployment adapter -n semantics`