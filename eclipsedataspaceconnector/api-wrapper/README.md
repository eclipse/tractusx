<!---
Copyright (c) 2021-2022 ZF Friedrichshafen AG & T-Systems International GmbH (Catena-X Consortium)

See the AUTHORS file(s) distributed with this work for additional
information regarding authorship.

See the LICENSE file(s) distributed with this work for
additional information regarding license terms.
-->

# EDC data plane & API-Wrapper

## Prerequisites

### For Running

- If you are sitting behind a corporate proxy (we expect it to operate for plain+ssl connections at the same time) please set the environment variables 
  - ${HTTP_PROXY}
  - ${HTTP_PROXY_HOST} and 
  - ${HTTP_PROXY_PORT} (somehow redundant, but the latter two are for Java and the first one for Docker scripts)
- Openssl
- Docker and Docker compose
  - Apple Silicon users: Your default binary platform will be arm64 Currently there is a good chance to run into segmentation faults
    when trying to download/run the default amd64 images. So it is recommended to build on your own images (section Building) with the following variable set
```bash
export DOCKER_PLATFORM=linux/arm64
```
- You will need either
  - A github account with a personal access token (see [this guide for accessing the github container registry](https://docs.github.com/en/packages/working-with-a-github-packages-registry/working-with-the-container-registry)) or
  - An Azure CLI with access to the Catena-X Azure Tenant

### For Building

- Jdk 11
- Apache Maven
- Apple Silicon Users (you lucky bunch ;-) 
  There is currently [no auto-configurable Java 11 toolchain for gradle](https://github.com/square/okhttp/issues/6943).
  We recommend to download/install the [Azul JDK 11](https://www.azul.com/downloads/?os=macos&architecture=arm-64-bit&package=jdk) and execute
  the following commands

```bash
# Adapt to the path of your Azul JDK11
export JDK11=~/Projects/jdk/zulu11.54.25-ca-jdk11.0.14.1-macosx_aarch64
export GRADLE_PROPS=(--no-parallel -Porg.gradle.java.installations.fromEnv=JDK11 -Pversion=0.0.3-CATENAX)
```

#### JDK11/Gradle with Apple Silicon Users

There is currently on Apple Systems with M>=1 processors.
The solution is to  [Microsoft JDK 11](https://docs.microsoft.com/de-de/java/openjdk/download) manually and
set an environment variable, such as `ZULU_JDK` to its location. 


#### Gradle behind a corporate proxy

```bash
if [ "${HTTP_PROXY_HOST}" != "" ]; then
  export GRADLE_PROPS=(${^GRADLE_PROPS} -Dhttp.proxyHost=${HTTP_PROXY_HOST} -Dhttp.proxyPort=${HTTP_PROXY_PORT} -Dhttps.proxyHost=${HTTP_PROXY_HOST} -Dhttps.proxyPort=${HTTP_PROXY_PORT})
fi
```

#### Building and locally publishing patched EDC artifacts

Build & publish EDC artifacts released on this [EDC patch branch](https://github.com/drcgjung/DataSpaceConnector/tree/release/catena-x)

```bash
git clone https://github.com/drcgjung/DataSpaceConnector.git
cd DataSpaceConnector
git checkout release/catena-x
./gradlew $GRADLE_PROPS clean build publishToMavenLocal -x test
```

### (Re-)Generate certificate

Currently, there is one default certificate already provided. In order to generate your own you have to do the following:

```bash
cd certs
# You have to enter an email (everything else can be empty)
openssl req -newkey rsa:2048 -new -nodes -x509 -days 3650 -keyout key.pem -out cert.pem
# Give 123456 as password or change the password in vault.properties
openssl pkcs12 -inkey key.pem -in cert.pem -export -out cert.pfx
# Put to the right configs
rm ../config/consumer-control-plane.config/cert.pfx
rm ../config/provider-control-plane.config/cert.pfx
cp cert.pfx ../config/consumer-control-plane.config/.
cp cert.pfx ../config/provider-control-plane.config/.
cd ..
```

## Pull (and Start)

First you need to decide whether you just want to use the prebuilt images or whether you want to
build by yourself. In the latter case, please go to Section 'Build (and Start)'.

Otherwise, you may utter the following commands (and then skip the next Section 'Build (and Start)' by advancing to section 'Play')

For using the github container registry:

```bash
./run_local.sh
```

For using the Azure container registry:

```bash
./run_local_from_azure.sh
```

## Build (snd Start)

The following command will build (and start) Catena-X@Home

Please be sure that you setup the right certficates (see section 'Generate certificate').

```bash
./build_run_local.sh
```

## Play

Here are some sample commands to the API Wrapper 

```bash
# Register assets & contract definition
./0-init-provider.sh

# Make a GET call through the EDCs or a POST
./1-aas-client-get.sh
./2-aas-client-post.sh

# Make AAS calls through the EDCs 
./3-aas-submodel-get.sh
./4-aas-submodel-post.sh
```

More Interactions with the Catena-X components can be found in the [Postman Collection](../../catenax.postman_collection.json) using the
[Localhost Postman Environment](../../catenax.at-home.postman_environment.json). Both need to be imported into [Postman](http://postman.com).

The most important sections therein would be Catenax>Semantic Layer>AAS Proxy (Data Consumer Side) and Catena-X>Semantic Layer>Semantic Adapter (Data Provider Side).

## Push and Deploy

After successful build & run, the artifacts may be pushed to the 'Hotel Budapest' environment.

```bash
./deploy_catenax.sh
```

Helm Chart deployment & Postman Environment for Hotel Budapest upcoming ...

## Potential complications

- Initial call from aas-client against the api-wrapper could be terminated by a timeout. E.g:
  - If the EDCs are taking to long for the communication
  - If the contract negotiation have to be signed manually by a real person
  - **Possible solutions**: Asynchronicity & State Machine between the aas-client and the api-wrapper
- Token to retrieve the data from the provider's data plane may expire
