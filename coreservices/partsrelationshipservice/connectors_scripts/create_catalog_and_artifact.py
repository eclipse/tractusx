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
# It creates a catalog, negotiate a contract and create an artifact.
# The original script is modified in order to register an artifact containing an access_url, so that the provider can
# call an API to access the artifact data instead of storing the data in its database.
#

from resourceapi import ResourceApi
from idsapi import IdsApi
import requests
import pprint
import sys


provider_url = sys.argv[1]
# Provider alias in the connector network. The consumer needs this alias to reach out to the provider.
provider_alias = sys.argv[2]
catalog_title = sys.argv[3]
artifact_title = sys.argv[4]
# URL to access the artifact.
access_url = sys.argv[5]
# User having an access to the  provider connector.
user = sys.argv[6]
password = sys.argv[7]
# Consumer id to restrict access only to this consumer
consumer_id = sys.argv[8]

# Suppress ssl verification warning
requests.packages.urllib3.disable_warnings()

# Provider
provider = ResourceApi(provider_url, auth=(user, password))

## Create resources
catalog = provider.create_catalog(data={"title": catalog_title})
offers = provider.create_offered_resource()

representation = provider.create_representation(data={"mediaType": "json"})

artifact = provider.create_artifact(data=
{
"title": artifact_title,
"accessUrl": access_url,
"automatedDownload": "true"
})

contract = provider.create_contract()

# ids:constraint and ids:Permission must have an @id, that can be any URL. The content of the @id does not have
# any impact.
# In the rule definition, ids:constraint should be read in the following order:
# ids:leftOperand ids:operand ids:rightOperand. In our case it means:
# SYSTEM SAME_AS consumer_id
rule_definition={"value": f"""{{
                "@context" : {{
                  "ids" : "https://w3id.org/idsa/core/",
                  "idsc" : "https://w3id.org/idsa/code/"
                }},
                "@type" : "ids:Permission",
                "@id" : "https://w3id.org/idsa/autogen/permission/d504b82f-79dd-4c93-969d-937ab6a1d676",
                "ids:description" : [ {{
                  "@value" : "connector-restriction",
                  "@type" : "http://www.w3.org/2001/XMLSchema#string"
                }} ],
                "ids:title" : [ {{
                  "@value" : "PRS access Policy",
                  "@type" : "http://www.w3.org/2001/XMLSchema#string"
                }} ],
                "ids:action" : [ {{
                  "@id" : "idsc:USE"
                }} ],
                "ids:constraint" : [ {{
                  "@type" : "ids:Constraint",
                  "@id" : "https://w3id.org/idsa/autogen/constraint/572c96ec-dd86-4b20-a849-a0ce8c255eee",
                  "ids:rightOperand" : {{
                    "@value" : "{consumer_id}",
                    "@type" : "http://www.w3.org/2001/XMLSchema#anyURI"
                  }},
                  "ids:leftOperand" : {{
                    "@id" : "idsc:SYSTEM"
                  }},
                  "ids:operator" : {{
                    "@id" : "idsc:SAME_AS"
                  }}
                }} ]
              }}"""}

use_rule = provider.create_rule(data=rule_definition)

## Link resources
provider.add_resource_to_catalog(catalog, offers)
provider.add_representation_to_resource(offers, representation)
provider.add_artifact_to_representation(representation, artifact)
provider.add_contract_to_resource(offers, contract)
provider.add_rule_to_contract(contract, use_rule)

print(offers)
