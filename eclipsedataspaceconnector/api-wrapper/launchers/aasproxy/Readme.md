<!---
Copyright (c) 2021-2022 T-Systems International GmbH (Catena-X Consortium)

See the AUTHORS file(s) distributed with this work for additional
information regarding authorship.

See the LICENSE file(s) distributed with this work for
additional information regarding license terms.
-->

The Catena-X AAS proxy is a library (and service) for interacting with federated and semantically-annotated Catena-X data components in a convenient fashion.

It makes use of the [Asset Administration Shell](http://admin-shell-io.com/) specification for
discovering and accessing (data, service) assets associated to digital twins (such as vehicles, serialized parts, production batches, ...).

It uses an attached [International Dataspace (IDS) Connector](https://internationaldataspaces.org/) for securely and privately exchanging sovereign and sensible data.

It (temporarily) relies on the [Semantic Framework](https://confluence.catena-x.net/pages/viewpage.action?pageId=25199158) 
to deal with authentication, validation, federation and IDS-specific implementation issues.

### Configuration:

This service/library is deployed on purpose/demand, so there is yet no fixed container or deployment 
configuration.

### Build Package:

Run `mvn install` to run unit tests, build and install the package (and submodules)

### Build & Run Package Locally:

Run `./run_local.sh` to run the aas proxy locally (against the dev042 central aas registry)

Since the central semantic services currently use the CX-Portal oauth2/openid domain, you
need to create a bearer token.

This can be arranged through using [Postman](https://www.postman.com/) with the [Catena-X Postman Collection](../../catenax.postman_collection.json).
In the 'Semantic Layer' folder, we have preconfigured a respective Oauth2 callback for which you will need to set
the variable '{{auth_url}}' in the environment, e.g. to
'https://catenaxdev042akssrv.germanywestcentral.cloudapp.azure.com/iamcentralidp/auth/realms/CX-Central/protocol/openid-connect'

An alternative is to login to the [Catena-X portal](https://catenaxdev042aksportal.germanywestcentral.cloudapp.azure.com) and
access the bearer token through the Javascript debugging console.

Run 'curl --location --request GET 'http://localhost:4244/registry/shell-descriptors?page=0&pageSize=10' \
--header 'Accept: application/json' \
--header 'Authorization: Bearer ${BEARER_TOKEN}'
'

to route a discovery call through the proxy to central. You will notice that all submodel endpoint URLs in the results 
will be rewritten to hit the proxy again. That means that (only after the above lookup!) requesting a submodel

`curl --location --request GET 'http://localhost:4244/69ab0d77-c981-41fe-8c0f-bd0c8256228d/aas/urn:bamm:com.catenaX:0.0.1%23Traceability/submodel' \
--header 'Authorization: Bearer ${BEARER_TOKEN}'`

will be delegated to the actual endpoint using the IDS transport layer.
