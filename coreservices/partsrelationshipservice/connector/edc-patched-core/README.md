# edc-patched-core

The Consumer is relaying an API call to the Provider, so we need a way to pass the request along.
The EDC connector does not allow passing custom information in the message.

In this project we have patched the `DataRequest` class to add a
`Map<String, String> properties`, and the IDS communication classes
to pass this field along in the IDS message in a field called
`dataspaceconnector-properties`. Sample IDS message:

```
{
  "@type": "ids:ArtifactRequestMessage",
  "@id": "https://w3id.org/idsa/autogen/artifactRequestMessage/c1197694-209c-4cb7-b9eb-7bee82b334bd",
  "ids:requestedArtifact": "prs-request",
  "ids:issuerConnector": "edc-82546323-4b63-4ba9-846f-621a3fd0c0d4",
  "ids:securityToken": {
    "@type": "ids:DynamicAttributeToken",
    "@id": "https://w3id.org/idsa/autogen/dynamicAttributeToken/6d7f96bb-6888-43e4-aecc-a4248821f65b",
    "ids:tokenValue": "mock-eu",
    "ids:tokenFormat": {
      "@id": "idsc:JWT"
    }
  },
  "ids:modelVersion": "1.0",
  "dataspaceconnector-properties": {
    "prs-request-parameters": "{\"oneIDManufacturer\":\"CAXSWPFTJQEVZNZZ\",\"objectIDManufacturer\":\"1\",\"view\":\"AS_BUILT\",\"aspect\":null,\"depth\":null}"
  },
  "dataspaceconnector-destination-token": "{\"edctype\":\"dataspaceconnector:azuretoken\",\"sas\":\"?sv=2020-06-12&se=2021-11-18T07%3A51%3A17Z&sr=c&sp=w&sig=kgjf%2FlLw%xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxD\",\"expiration\":1637221877219}",
  "dataspaceconnector-data-destination": {
    "properties": {
      "container": "62f573f3-492f-4c20-80cc-a99149c874f7",
      "keyName": "62f573f3-492f-4c20-80cc-a99149c874f7",
      "type": "AzureStorage",
      "account": "devconsumer"
    },
    "type": "AzureStorage",
    "keyName": "62f573f3-492f-4c20-80cc-a99149c874f7"
  }
}

```

The modified classes are from commit [e03a38582b7865444680eb99a2d0473a69dc7fc8](https://github.com/eclipse-dataspaceconnector/DataSpaceConnector/commit/e03a38582b7865444680eb99a2d0473a69dc7fc8)
of the EDC Connector.

We are in discussions with the EDC team to figure out whether to push these changes upstream or use different functionality.