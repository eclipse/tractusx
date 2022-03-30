# Eclipse Catena-X
https://projects.eclipse.org/projects/automotive.tractusx
 
## Background & Scope

The Catena-X alliance sees itself as an extensible ecosystem in which automotive manufacturers and suppliers, dealer associations and equipment suppliers, including the providers of applications, platforms and infrastructure, can all participate equally. The purpose of Catena-X is to create a uniform standard for information and data-sharing throughout the entire automotive value chain.

Catena-X Release 1 brings together all necessary technical and business components to enable an end-to-end experience for five areas of application which have been jointly defined.

With the help of a data-sovereign infrastructure (forming an International Dataspace), these application areas can significantly help to 
boost productivity and improve sustainability along future value chains. The five areas are quality management, logistics, maintenance, 
supply chain management and sustainability. Applications supporting production and development are planned for future phases.

The (minimal) components of a Catena-X Dataspace are:

- A Semantic Hub with all the released Catena-X Semantic/Data Models (=Submodels or Aspects).
- Asset Administration Shell (AAS) Servers per Business Partner to Standardize Access to Catena-X Submodels.
- Asset Administration Shell Registry to Federate and Search Digital Twins out of the Individual Submodels.
- Eclipse Dataspace Connectors to form a secure Business Partner network out of declarative contract definitions.
- A Catena-X Proxy per Business Partner which acts as a simple facade to the underlying complexity.

The Dataspace will create an important starting point for the industry to respond more efficiently to the challenges of 
digital transformation and to make better use of the opportunities offered by digitalisation.

## Build & Deploy It

You can build and run Catena-X@Home using this [Walkthrough](eclipsedataspaceconnector/api-wrapper/README.md) and the [Docker Compose Manifest](eclipsedataspaceconnector/api-wrapper/docker-compose.yml) 
(which will be complemented with an [Argo-CD](https://argoproj.github.io/cd/) compatible kubernetes HELM chart)

## Run It

You can interact with the Catena-X API(s) using this [Postman Collection](catenax.postman_collection.json).
Please do also import the [Localhost Postman Environment](catenax.localhost.postman_environment.json) in case you want to
interact with Catena-X@Home (or adapt according to the target Catena-X environment).

## Scope

 
## Description
The companies involved want to increase the automotive industry’s competitiveness, improve efficiency through industry-specific cooperation and accelerate company processes through standardization and access to information and data. A special focus is also on SMEs, whose active participation is of central importance for the network’s success. That is why Catena-X has been conceived from the outset as an open network with solutions ready for SMEs, where these companies will be able to participate quickly and with little IT infrastructure investment. Tractus-X is meant to be the PoC project of the Catena-X alliance focusing on parts traceability.
 
## Licenses
Apache 2.0 (https://www.apache.org/licenses/LICENSE-2.0)

## Initial Contribution
Since this is a PoC project we do not yet have pre-existing code.
 
## PoC Scheduling
Tractus-X and its involved parties intend to move to Eclipse as soon as possible. We hope to have the initial commit accomplished by 05/2021.

## Contact
Contact the project developers via the Tractus-X "dev" list: 
https://accounts.eclipse.org/mailing-list/tractusx-dev
