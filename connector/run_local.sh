#
# Copyright (c) 2021 T-Systems International GmbH (Catena-X Consortium)
#
# See the AUTHORS file(s) distributed with this work for additional
# information regarding authorship.
#
# See the LICENSE file(s) distributed with this work for
# additional information regarding license terms.
#

#
# Shell script to build and run a pair of local connectors for testing purposes.
#
# Prerequisites: 
#   Windows, (git)-bash shell, java 11 (java) and maven (mvn) in the $PATH.
#
# Synposis: 
#   ./run_local.sh (-build)? (consumer|provider)? (-debug)?
#
# Comments: 
#   The IDS connector needs the configuration being given in an absolute path
#   (if not in the classloader, i.e. integrated in its jar).
#   It has been primarily designed for Windows environments  
#   under (git-)bash which needs to translate the initial drive
#   letter into a windows scheme before starting java
#   The secrets included here are not really secret as they were already
#   part of the deployment descriptors (by Fraunhofer), so I guess these are just sample
#   keystores and keys (marked as insecure in the documentation).
#

DEBUG_PORT=8888

CONFIG_PATH=$(readlink -f src/main/resources/conf/local_provider_config.json | sed 's/^\///' | sed 's/\//\\/g' | sed 's/^./\0:/')
H2_URL=jdbc:h2:file:./target/db_provider
SERVER_PORT=8080
DEBUG_OPTIONS=

for var in "$@"
do
  if [ "$var" == "-debug" ]; then
    DEBUG_OPTIONS="-agentlib:jdwp=transport=dt_socket,address=${DEBUG_PORT},server=y,suspend=n"
  else 
    if [ "$var" == "consumer" ]; then
      CONFIG_PATH=$(readlink -f src/main/resources/conf/local_consumer_config.json | sed 's/^\///' | sed 's/\//\\/g' | sed 's/^./\0:/')
      H2_URL=jdbc:h2:file:./target/db_consumer
      SERVER_PORT=8081
      DEBUG_PORT=8889
    else 
      if [ "$var" == "-build" ]; then
        mvn install -DskipTests
      fi
    fi
  fi
done

if [ "$HTTP_PROXY" != "http://sia-lb.telekom.de:8080" ]; then
    echo "You are not running behind the telekom proxy. Please make sure you adapted/removed the ids:connectorProxy setting in $CONFIG_PATH"
fi

java \
    -classpath .\;target/dataspace-connector-4.3.0.jar \
    -Dconfiguration.path=$CONFIG_PATH \
    -Dconfiguration.keyStorePassword=password \
    -Dconfiguration.trustStorePassword=password \
    -Dserver.port=$SERVER_PORT \
    -Dspring.datasource.url=$H2_URL \
    $DEBUG_OPTIONS \
    org.springframework.boot.loader.JarLauncher

