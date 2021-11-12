#!/bin/bash
set -euo pipefail
cd ..
export DOCKER_BUILDKIT=1
docker-compose --profile connector build --build-arg PRS_EDC_PKG_USERNAME=$PRS_EDC_PKG_USERNAME --build-arg PRS_EDC_PKG_PASSWORD=$PRS_EDC_PKG_PASSWORD 
docker-compose --profile connector up --exit-code-from=connector-integration-test --abort-on-container-exit
