#!/bin/bash

set -o errexit
set -o errtrace
set -o pipefail
set -o nounset

curl \
  -X GET \
  --header "Authorization: Basic c29tZXVzZXI6c29tZXBhc3N3b3Jk" \
  "http://localhost:8193/api/service/asset-1/submodel?provider-connector-url=http://provider-control-plane:9191"
