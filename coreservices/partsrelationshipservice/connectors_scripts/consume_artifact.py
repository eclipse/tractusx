#!/usr/bin/env python3
#
# Copyright 2020 Fraunhofer Institute for Software and Systems Engineering
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#    http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#

#
# This script is based on the following script:
# https://github.com/International-Data-Spaces-Association/DataspaceConnector/blob/main/scripts/tests/contract_negotation_allow_access.py
# The original script creates an artifact. This script only consume an artifact.
#

from resourceapi import ResourceApi
from idsapi import IdsApi
import requests
import pprint
import sys


# provider_url = sys.argv[1]
consumer_url = sys.argv[1]
# Provider alias in the connector network. The consumer needs this alias to reach out to the provider.
# provider_alias = sys.argv[3]
# Consumer alias in the connector network. The provider needs this alias to reach out to the connector.
first_artifact = sys.argv[2]
# consumer_alias = sys.argv[4]
relative_reference = sys.argv[3]
# User having an access to the consumer connector.
user = sys.argv[4]
password = sys.argv[5]

# print("Setting provider url:", provider_url)
# print("Setting consumer url:", consumer_url)
# print("Setting provider alias as:", provider_alias)
# print("Setting consumer alias as:", consumer_alias)

# Suppress ssl verification warning
requests.packages.urllib3.disable_warnings()

# Consumer
# consumer = IdsApi(consumer_url, auth=(user, password))

# description = consumer.descriptionRequest(provider_alias + "/api/ids/data", None)

# print("description:")
# pprint.pprint(description)

# # Getting first catalog because we should have only one catalog registered.
# catalog_url = description["ids:resourceCatalog"][0]["@id"]
# print("catalog_url:")
# pprint.pprint(catalog_url)

# catalog = consumer.descriptionRequest(provider_alias + "/api/ids/data", catalog_url)

# print("catalog:")
# pprint.pprint(catalog)

# # Getting first item of offeredResource because we should have only one artifact registered.
# offer_url = catalog["ids:offeredResource"][0]["@id"]
# provider_artifact_url = catalog["ids:offeredResource"][0]["ids:representation"][0]["ids:instance"][0]["@id"]

# # Replace localhost references. Useful when running locally as connector url and aliases are different.
# offer_url = offer_url.replace(provider_url, provider_alias)
# provider_artifact_url = provider_artifact_url.replace(provider_url, provider_alias)

# # Get offer and artifact on consumer side.
# offer = consumer.descriptionRequest(provider_alias + "/api/ids/data", offer_url)

# # Negotiate contract
# obj = offer["ids:contractOffer"][0]["ids:permission"][0]
# obj["ids:target"] = provider_artifact_url
# response = consumer.contractRequest(
#     provider_alias + "/api/ids/data", offer_url, provider_artifact_url, False, obj
# )
# pprint.pprint(response)

# # Pull data
# agreement = response["_links"]["self"]["href"]

consumerResources = ResourceApi(consumer_url, auth=(user, password))
# artifacts = consumerResources.get_artifacts_for_agreement(agreement)
# pprint.pprint(artifacts)

# first_artifact = artifacts["_embedded"]["artifacts"][0]["_links"]["self"]["href"]
pprint.pprint(first_artifact)

data = consumerResources.get_data(first_artifact, relative_reference).text

pprint.pprint("Consumer data url to access the artifact:")
pprint.pprint(first_artifact + "/data")

pprint.pprint("Data obtained:")
pprint.pprint(data)

exit(0)