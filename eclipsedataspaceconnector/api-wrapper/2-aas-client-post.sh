#!/bin/bash

set -o errexit
set -o errtrace
set -o pipefail
set -o nounset

curl \
  -X POST \
  --header "Authorization: Basic c29tZXVzZXI6c29tZXBhc3N3b3Jk" \
  --header 'Content-Type: application/json' \
  --data '{ "Hallo":"123"}' \
  "http://localhost:8193/api/service/asset-2/submodel?provider-connector-url=http://provider-control-plane:9191"
