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
# Shell script to build and run a local semantics adapter for testing purposes.
#
# Prerequisites: 
#   Windows, (git)-bash shell, java 11 (java) and maven (mvn) in the $PATH.
#
# Synposis: 
#   ./build_run_local.sh (-build)? (-clean)? (-suspend)? (-debug)? (-proxy)?
#
# Comments: 
#

DEBUG_PORT=8889
DEBUG_SUSPEND=n
DEBUG_OPTIONS=
DB_FILE=./target/db_semantics
CLEAN_DB=n

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
            CLEAN_DB=y
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

H2_URL=jdbc:h2:file:${DB_FILE}

if [ "$CLEAN_DB" == "y" ]; then
  rm -f ${DB_FILE}*
fi

PATH_SEPARATOR=":"
if [ "${OSTYPE}" == "msys" ]; then
  PATH_SEPARATOR=";"
fi

CALL_ARGS="-classpath ./src/main/resources${PATH_SEPARATOR}target/adapter-1.3.0-SNAPSHOT.jar \
           -Dspring.profiles.active=$PROFILE \
           -Dspring.datasource.url=$H2_URL \
           -Dserver.ssl.enabled=false $PROXY $DEBUG_OPTIONS\
           org.springframework.boot.loader.JarLauncher" 

echo ${CALL_ARGS}
java ${CALL_ARGS}

    
 