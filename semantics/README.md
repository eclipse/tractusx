<!---
Copyright (c) 2021 T-Systems International GmbH (Catena-X Consortium)

See the AUTHORS file(s) distributed with this work for additional
information regarding authorship.

See the LICENSE file(s) distributed with this work for
additional information regarding license terms.
-->

The semantic layer is an architectural component of Catena-X. 

### Configuration:

All configuration placed in `infrastructure/manifests/semanticlayer.yaml`

### Build Package:

Run `mvn install` to run unit tests, build and install the package.

### Build & Run Package Locally:

Run `./run.sh` to freshly build the package and run a local semantics server.

### Build Docker:

Run `mvn package -DskipTests`
Run `docker build -t $REGISTRY/semantics:$VERSION .`
RUN `docker push $REGISTRY/semantics:$VERSION`

where $REGISTRY is set to the target container/docker repository (like `tsicatenaxdevacr.azurecr.io`) and $VERSION is set to the 
deployment version (usually `latest`).

### Redeploy in target environment

Run `kubectl rollout restart deployment semantics -n semantics`