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
# Shell script to build and run the aas proxy service for testing purposes.
#
# Prerequisites:
#   Windows, (git)-bash shell, java 11 (java) and maven (mvn) in the $PATH.
#
# Synposis:
#   ./build_run_local.sh (-build)? (-clean)? (-suspend)? (-debug)? (-proxy)?
#
# Comments:
#

DEBUG_PORT=8890
DEBUG_SUSPEND=n
DEBUG_OPTIONS=

for var in "$@"
do
  if [ "$var" == "-debug" ]; then
    DEBUG_OPTIONS="-agentlib:jdwp=transport=dt_socket,address=${DEBUG_PORT},server=y,suspend=${DEBUG_SUSPEND}"
  else
      if [ "$var" == "-build" ]; then
        mvn install -DskipTests -Dmaven.javadoc.skip=true
      else
        if [ "$var" == "-suspend" ]; then
          DEBUG_SUSPEND=y
        else
          if [ "$var" == "-clean" ]; then
            mvn clean
          else
            if [ "$var" == "-proxy" ]; then
              PROXY="-Dhttp.proxyHost=${HTTP_PROXY_HOST} -Dhttp.proxyPort=${HTTP_PROXY_PORT} -Dhttps.proxyHost=${HTTP_PROXY_HOST} -Dhttps.proxyPort=${HTTP_PROXY_PORT}"
              if [ "${HTTP_NONPROXY_HOSTS}" != "" ]; then
                PROXY="${PROXY} -Dhttp.nonProxyHosts=${HTTP_NONPROXY_HOSTS} -Dhttps.nonProxyHosts=${HTTP_NONPROXY_HOSTS}"
              fi
            fi
          fi
        fi
      fi
  fi
done

CALL_ARGS="-classpath ./src/main/resources;target/aasproxy-1.0.0-SNAPSHOT.jar \
           -Dserver.ssl.enabled=false $PROXY $DEBUG_OPTIONS\
           org.springframework.boot.loader.JarLauncher"

java ${CALL_ARGS}


