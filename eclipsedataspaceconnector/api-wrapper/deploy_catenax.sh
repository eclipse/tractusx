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
#   ./deploy_catenax.sh
#
# Comments:
#

az login --tenant 495463c3-0991-4659-9cc5-94b4a3f7b1d6
az acr login --name cxtsiacr.azurecr.io
docker push cxtsiacr.azurecr.io/edc/consumer-control-plane:catenax-at-home-latest
docker push cxtsiacr.azurecr.io/edc/consumer-data-plane:catenax-at-home-latest
docker push cxtsiacr.azurecr.io/edc/consumer-api-wrapper:catenax-at-home-latest
docker push cxtsiacr.azurecr.io/edc/provider-control-plane:catenax-at-home-latest
docker push cxtsiacr.azurecr.io/edc/provider-data-plane:catenax-at-home-latest
docker push cxtsiacr.azurecr.io/edc/provider-api-wrapper:catenax-at-home-latest
docker push cxtsiacr.azurecr.io/backend/simple-aas-adapter:catenax-at-home-latest
docker push cxtsiacr.azurecr.io/semantics/hub:catenax-at-home-latest
docker push cxtsiacr.azurecr.io/semantics/registry:catenax-at-home-latest
docker push cxtsiacr.azurecr.io/edc/consumer-aas-proxy:catenax-at-home-latest
