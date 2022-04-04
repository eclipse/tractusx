#
# Copyright (c) 2021-2022 T-Systems International GmbH (Catena-X Consortium)
#
# See the AUTHORS file(s) distributed with this work for additional
# information regarding authorship.
#
# See the LICENSE file(s) distributed with this work for
# additional information regarding license terms.
#

#
# Shell script to build and run Catena-X@Home for testing purposes.
#
# Prerequisites:
#   Windows, (git)-bash shell, java 11 (java) and maven (mvn) in the $PATH.
#
# Synposis:
#   ./run_local.sh
#
# Comments:
#

docker login ghcr.io
docker pull ghcr.io/catenax/edc/consumer-control-plane:catenax-at-home-latest
docker pull ghcr.io/catenax/edc/consumer-data-plane:catenax-at-home-latest
docker pull ghcr.io/catenax/edc/consumer-api-wrapper:catenax-at-home-latest
docker pull ghcr.io/catenax/edc/provider-control-plane:catenax-at-home-latest
docker pull ghcr.io/catenax/edc/provider-data-plane:catenax-at-home-latest
docker pull ghcr.io/catenax/edc/provider-api-wrapper:catenax-at-home-latest
docker pull ghcr.io/catenax/backend/simple-aas-adapter:catenax-at-home-latest
docker pull ghcr.io/catenax/semantics/hub:catenax-at-home-latest
docker pull ghcr.io/catenax/semantics/registry:catenax-at-home-latest
docker pull ghcr.io/catenax/edc/consumer-aas-proxy:catenax-at-home-latest
docker-compose up
