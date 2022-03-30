#!/bin/bash

set -o errexit
set -o errtrace
set -o pipefail
set -o nounset

curl -X POST \
     "http://localhost:8193/api/service/offer-orga/shells/398c047f-c14c-47b9-9c27-d9511afc90d3/aas/idconversion-aspect/submodel/submodel-elements/convert/invoke?content=value&async=false&provider-connector-url=http://provider-control-plane:9191" \
     --header "Authorization: Basic c29tZXVzZXI6c29tZXBhc3N3b3Jk" \
     --header 'Content-Type: application/json' \
     --data-raw '{
         "targetDomain":"urn:kappes#",
         "identifiers":[
             {
                 "key":"bla","value":"blip"
             },
             {
                 "key":"bli","value":"blap"
             },
             {
                 "key":"blu","value":"blup"
             }
         ]
     }';
