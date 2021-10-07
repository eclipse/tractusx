!# /bin/bash

set -euo pipefail

curl -X GET "http://tdmgeneratorint.germanywestcentral.azurecontainer.io:8080/catena-x/tdm/1.0/prs/broker/PartAspectUpdate" -H "accept: application/json" | jq > PartAspectUpdate.json
curl -X GET "http://tdmgeneratorint.germanywestcentral.azurecontainer.io:8080/catena-x/tdm/1.0/prs/broker/PartRelationshipUpdateList" -H "accept: application/json" | jq > PartRelationshipUpdateList.json
curl -X GET "http://tdmgeneratorint.germanywestcentral.azurecontainer.io:8080/catena-x/tdm/1.0/prs/broker/PartTypeNameUpdate" -H "accept: application/json" | jq > PartTypeNameUpdate.json