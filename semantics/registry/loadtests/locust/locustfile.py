import json
import uuid
import urllib.parse


from locust import HttpUser, task, constant_throughput
from locust.exception import RescheduleTask

class AasRegistryTask(HttpUser):
    
    # If 100 Users are configured in the load test
    # constant_throughput ensures that: 100 Users * 0.1 = 10 request/s
    wait_time = constant_throughput(0.1)

    @task
    def createAndQueryAasDescriptor(self):
        shell = generate_shell()
        headers = { 'Content-Type' : 'application/json'}
        with self.client.post("/registry/shell-descriptors", data=json.dumps(shell), headers= headers, catch_response=True) as response:
            if response.status_code != 201:
                response.failure(f"Expected 201 but status code was {response.status_code}")
                raise RescheduleTask()
        
        shell_id = shell['identification']

        with self.client.get(f"/registry/shell-descriptors/{shell_id}", name = "/registry/shell-descriptors/{id}", catch_response=True) as response:
            if response.status_code != 200:
                response.failure(f"Expected 200 but status code was {response.status_code}")
                raise RescheduleTask()

        specificAssetIds = shell['specificAssetIds']
        decodedAssetIds = urllib.parse.quote_plus(json.dumps(specificAssetIds))
        with self.client.get(f"/lookup/shells?assetIds={decodedAssetIds}", name = "/lookup/shells?assetIds={assetIds}", catch_response=True) as response:
            if response.status_code != 200:
                response.failure(f"Expected 200 but status code was {response.status_code}")
                raise RescheduleTask()

def generate_shell():
    aasId = uuid.uuid4()
    globalAssetId = uuid.uuid4()
    specificAssetId1 = uuid.uuid4()
    specificAssetId2 = uuid.uuid4()
    return {
              "description": [
                {
                  "language": "en",
                  "text": "The shell for a vehicle"
                }
              ],
              "globalAssetId": {
                "value": [
                    str(globalAssetId)
                ]
              },
              "idShort": "future concept x",
              "identification": str(aasId),
              "specificAssetIds": [
                {
                  "key": "MaterialId",
                  "value": str(specificAssetId1)
                },
                {
                  "key": "PartId",
                  "value": str(specificAssetId2)
                }
              ],
              "submodelDescriptors": [
                {
                  "description": [
                    {
                      "language": "en",
                      "text": "Provides base vehicle information"
                    }
                  ],
                  "idShort": "vehicle base details",
                  "identification": "4a738a24-b7d8-4989-9cd6-387772f40565",
                  "semanticId": {
                    "value": [
                        "urn:bamm:com.catenax.vehicle:0.1.1"
                    ]
                  },
                  "endpoints": [
                    {
                      "interface": "HTTP",
                      "protocolInformation": {
                        "endpointAddress": "https://catena-x.net/vehicle/basedetails/",
                        "endpointProtocol": "HTTPS",
                        "endpointProtocolVersion": "1.0"
                      }
                    }
                  ]
                },
                {
                  "description": [
                    {
                      "language": "en",
                      "text": "Provides base vehicle information"
                    }
                  ],
                  "idShort": "vehicle part details",
                  "identification": "dae4d249-6d66-4818-b576-bf52f3b9ae90",
                  "semanticId": {
                    "value": [
                        "urn:bamm:com.catenax.vehicle:0.1.1#PartDetails"
                    ]
                  },
                  "endpoints": [
                    {
                      "interface": "HTTP",
                      "protocolInformation": {
                        "endpointAddress": "https://catena-x.net/vehicle/partdetails/",
                        "endpointProtocol": "HTTPS",
                        "endpointProtocolVersion": "1.0"
                      }
                    }
                  ]
                }
              ]
        }