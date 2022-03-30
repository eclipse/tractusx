#!/bin/bash

set -o errexit
set -o errtrace
set -o pipefail
set -o nounset

curl -X GET \
  --header "Authorization: Basic c29tZXVzZXI6c29tZXBhc3N3b3Jk" \
  "http://localhost:8193/api/service/offer-windchill/shells/3c7556f7-6956-4360-8036-d03e5a79c3c8/aas/brake-material/submodel?content=value&level=deep&extent=withBlobValue&provider-connector-url=http://provider-control-plane:9191/"
