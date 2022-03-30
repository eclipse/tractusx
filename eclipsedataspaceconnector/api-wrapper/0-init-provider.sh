#!/bin/bash

set -o errexit
set -o errtrace
set -o pipefail
set -o nounset

# Create and register Simple Assets
curl -X POST -H 'X-Api-Key: 123456' -H 'Content-Type: application/json' --data "@resources/asset1.json" http://localhost:8181/api/assets
curl -X POST -H 'X-Api-Key: 123456' -H 'Content-Type: application/json' --data "@resources/asset2.json" http://localhost:8181/api/assets

# Create and register Catena-X Assets
curl -X POST -H 'X-Api-Key: 123456' -H 'Content-Type: application/json' --data "@resources/offer-windchill.json" http://localhost:8181/api/assets
curl -X POST -H 'X-Api-Key: 123456' -H 'Content-Type: application/json' --data "@resources/offer-tdm.json" http://localhost:8181/api/assets
curl -X POST -H 'X-Api-Key: 123456' -H 'Content-Type: application/json' --data "@resources/offer-orga.json" http://localhost:8181/api/assets

# Create and register Contract Definition
curl -X POST -H 'X-Api-Key: 123456' -H 'Content-Type: application/json' --data "@resources/contractdefinition.json" http://localhost:8181/api/contractdefinitions
