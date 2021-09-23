#!/bin/bash

set -euxo pipefail

REGISTRY=$1
TAG=$2

export DOCKER_BUILDKIT=1

docker build --target prs -t $REGISTRY/prs:$TAG .
if ! docker push $REGISTRY/prs:$TAG; then
  az acr login -n $REGISTRY
  docker push $REGISTRY/prs:$TAG
fi
