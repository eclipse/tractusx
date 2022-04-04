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
#   ./build_run_local.sh
#
# Comments:
#

export MAVEN_OPTS=(${GRADLE_PROPS[*]})

if [ "${HTTP_PROXY_HOST}" != "" ]; then
  export MAVEN_OPTS=(${GRADLE_PROPS[*]} -Dhttp.proxyHost=${HTTP_PROXY_HOST} -Dhttp.proxyPort=${HTTP_PROXY_PORT} -Dhttps.proxyHost=${HTTP_PROXY_HOST} -Dhttps.proxyPort=${HTTP_PROXY_PORT})
fi

cd ../../semantics
mvn clean install -DskipTests
cd ../eclipsedataspaceconnector/api-wrapper
./gradlew ${MAVEN_OPTS} clean build
cd launchers
rm -rf adapter
rm -rf services
rm -rf registry
rm -rf semantic-hub
cp -r ../../../semantics/adapter .
cp -r ../../../semantics/registry .
cp -r ../../../semantics/semantic-hub .
cd aasproxy
mvn clean install -DskipTests
cd ../..
export DOCKER_PLATFORM=${DOCKER_PLATFORM:-linux/amd64}
docker-compose build
docker-compose up
