<!---
Copyright (c) 2021-2022 T-Systems International GmbH (Catena-X Consortium)

See the AUTHORS file(s) distributed with this work for additional
information regarding authorship.

See the LICENSE file(s) distributed with this work for
additional information regarding license terms.
-->

The Digital Twin & Semantic Layer is a logical and architectural component of Catena-X.
The source code under this folder contains a library for building your own semantic-enabled Catena-X components. 

### Build Packages:

Run `mvn install` to run unit tests, build and install the package (and submodules)

### Architecture

The SLDT framework provides the following abstractions:
- Configuration objects for 
  - IDS Catalogs, Contracts, Offers, Representations and Artifacts
  - Backend Commands for
    - Accessing Files
    - Querying SQL Databases
- Backend Adapters (Protocols)
  - FILE Access
  - SQL Connections (as XML-Source)
- Transformations
  - From XML-Sources via XSLT Stylesheets
- API Adapters
  - REST Download
  - Digital Twin Registry Publication
- IDS Connector Bus/Plane
  - Fraunhofer Data-Space Connector (DSC) as a remote service
  - Eclipse Dataspace Connector (EDC) as an embedded service
- Skeletons for AAS Shell/Submodel Implementations
- Stubs for (Remote) AAS Registry Access

SLDT framework is based on Spring.
Applications using SLDT will most likely apply Spring Boot.

### Submodules

Under [apigen](apigen) we have placed the relevant tools and command lines to regenerate the
IDS connector client stubs which have been placed under the ordinary src folder.

### Refer in your Manifests:

```
   <dependency>
      <groupId>net.catenax.semantics</groupId>
      <artifactId>framework</artifactId>
      <version>${sldt.version}</version>
   </dependency>
```
