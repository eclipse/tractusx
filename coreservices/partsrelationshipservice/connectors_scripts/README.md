# Interact with Connectors

PRS API should be accessible via a consumer connector. An artifact linked to PRS API is created via a provider connector.
This document explains how we can create an artifact and consume the data of the artifact through a consumer.

## Create a catalog and an artifact

The created artifact will be only accessible by the consumer specified in <consumer-url>. Other consumers will not be able to access the resource.
The script creates a rule that specifies that only this consumer can access the artifact.
Rules are based on consumer-id. In our system, consumer ids are consumer urls.

```bash
pipenv sync
pipenv shell
./create_catalog_and_artifact.py \
<provider-url> \
<provider-internal-alias> \
<catalog_title> \
<artifact_title> \
<access-url-to-access-the-artifact> \
<username> \
<password>
<consumer-url> # consumer that should be given access to the artifact.
```

## Create a catalog and an artifact in the dev001 environment

```bash
pipenv sync
pipenv shell
./create_catalog_and_artifact.py \
"https://catenaxdev001akssrv.germanywestcentral.cloudapp.azure.com/env001/producer" \
"https://catenaxdev001akssrv.germanywestcentral.cloudapp.azure.com/env001/producer" \
"PRS catalog" \
"PRS" \
"https://catenaxdev001akssrv.germanywestcentral.cloudapp.azure.com" \
<username> \
<password>
"https://catenaxdev006akssrv.germanywestcentral.cloudapp.azure.com/kaputt/consumer"
```

## Negotiate contract and consume the data of an artifact

```bash
pipenv sync
pipenv shell
./consume_artifact.py \
<provider-url> \
<consumer-url> \
<provider-internal-alias> \
<consumer-internal-alias> \
<catalog_url> \
<pathparams-and-query-params-to-append-to-the-url-to-access-a-specific-resource> \
<username> \
<password>
```

## Negotiate contract and consume the data of an artifact in the env001 environment

```bash
pipenv sync
pipenv shell
./negotiate_contract_and_consume_artifact.py \
"https://catenaxdev001akssrv.germanywestcentral.cloudapp.azure.com/env001/producer" \
"https://catenaxdev001akssrv.germanywestcentral.cloudapp.azure.com/env001/consumer" \
"https://catenaxdev001akssrv.germanywestcentral.cloudapp.azure.com/env001/producer" \
"https://catenaxdev001akssrv.germanywestcentral.cloudapp.azure.com/env001/consumer" \
"https://catenaxdev001akssrv.germanywestcentral.cloudapp.azure.com/env001/producer/api/catalogs/184ba395-7f5a-4700-b418-ba23b396292b"
"/api/v0.1/vins/YS3DD78N4X7055320/partsTree?view=AS_BUILT" \
<username> \
<password>
```

## Only consume the data of an artifact after negotiation has been done

```bash
pipenv sync
pipenv shell
./consume_artifact.py \
<provider-url> \
<artifact-on-consumer-side> \
<pathparams-and-query-params-to-append-to-the-url-to-access-a-specific-resource> \
<username> \
<password>
```

## Only consume the data of an artifact after negotiation has been done in the env001 environment

```bash
pipenv sync
pipenv shell
./consume_artifact.py \
"https://catenaxdev006akssrv.germanywestcentral.cloudapp.azure.com/kaputt/consumer" \
"https://catenaxdev006akssrv.germanywestcentral.cloudapp.azure.com/kaputt/consumer/api/artifacts/45824c35-e6f5-4425-abbe-cd3023b2b1ff" \
"/MATERIAL/CAXSJRTGOPVESVZZ/fyyiwwdwbybviwxgrpegnpizrxpxaudopnlopeubfwoijmrlihwzhcofpcbmgcjb" \
<username> \
<password>
```

## Consume data when contract is already negotiated
When running the negotiate_contract_and_consume_artifact.py script, please note the url printed by the script under "Consumer data url to access the artifact".
This url should end by /data. You need to append path params and query params to the url to make your query.

## Scripts explanation

[resourceapi.py](https://github.com/International-Data-Spaces-Association/DataspaceConnector/blob/main/scripts/tests/resourceapi.py) and [idsapi.py](https://github.com/International-Data-Spaces-Association/DataspaceConnector/blob/main/scripts/tests/idsapi.py) have been taken in the [Dataspace connector repository](https://github.com/International-Data-Spaces-Association/DataspaceConnector).
[create_catalog_and_artifact.py](./create_catalof_and_artifact.py) and [consume_artifact.py](./negotiate_contract_and_consume_artifact.py) are based on [a script from the DataspaceConnector repository](https://github.com/International-Data-Spaces-Association/DataspaceConnector/blob/main/scripts/tests/contract_negotation_allow_access.py).
[create_catalog_and_artifact.py](./create_catalof_and_artifact.py) creates a catalog and an artifact accessible via an access url (our PRS api in our case).
[consume_artifact.py](./negotiate_contract_and_consume_artifact.py) Finds the first artifact of the first catalog accessible and tries to access the artifact data by calling the access_url of the artifact. It takes the first artifact for simplicity as we are supposed to register only one artifact. You can specify the pathparams and query params that need to be appended to the access url to access a resource.

## Cleanup the data of the connectors

If you want to start from a fresh state and remove catalogs, resources, everything from postgres you can run the following commands to clean the postgres database.

First, run:

```bash
az aks get-credentials --resource-group <resource-group> --name <aks-cluster-where-connectors-are-deployed>
kubectl scale deployment consumer-dataspace-connector --replicas=0
kubectl scale deployment producer-dataspace-connector --replicas=0
kubectl scale sts consumer-postgresql --replicas=0
kubectl scale sts producer-postgresql --replicas=0
```

Run `kubectl get pods` and make sure that no pods are running to continue.

```bash
kubectl delete pvc data-consumer-postgresql-0
kubectl delete pvc data-producer-postgresql-0
kubectl scale sts consumer-postgresql --replicas=1
kubectl scale sts producer-postgresql --replicas=1
kubectl scale deployment consumer-dataspace-connector --replicas=1
kubectl scale deployment producer-dataspace-connector --replicas=1
```

## Debug the connectors deployed in kubernetes

It is possible to debug connectors that running in Kubernetes.
For that, you need to redeploy the connectors with remote debug enabled.

The connector helm chart is located in the [/connector/helm-chart](/connector/helm-chart) folder.
Configurations to deploy helm chart connectors in DEV are located in [/connector/landscape/dev006](/connector/landscape/dev006).
Configurations to deploy helm chart connectors in INT environment are located in [/connector/landscape/int/](/connector/landscape/int/).
The configurations for the PRS consumer are in the prs-query folder and configurations for producer are in the prs-upload folder.

To deploy a connector with remoteDebugEnabled, set remoteDebugEnabled to true in your values.yml.
Then redeploy the connector with helm upgrade. Instructions to deploy the helm chart are in [/connector/landscape/README.md](/connector/landscape/README.md)

Run the following command:

```bash
kubectl port-forward deployments/<deployment-name> 5005
```

The deployment name of consumer is `consumer-dataspace-connector` and the deployment name of producer is `producer-dataspace-connector`.


Then open the [Dataspace connector project](https://github.com/International-Data-Spaces-Association/DataspaceConnector) in your IDE.

Add a Remote JVM debugging configuration.
Host should be `localhost`, port `5005` and command line argument for remote JVM `-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005`.
After that you can set your breakpoints and start debugging.
