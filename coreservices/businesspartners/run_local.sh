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
# Shell script to build and run a local business partner app for testing purposes.
#
# Prerequisites: 
#   Windows, (git)-bash shell, java 11 (java) and maven (mvn) in the $PATH.
#
# Synposis: 
#   ./run_local.sh
#
# Comments: 
#   Uncomment the proxy lines to run against a corporate proxy

mvn clean install
java \
    -classpath .\;target/businesspartner-latest.jar \
#    -Dhttp.proxyHost=$HTTP_PROXYHOST \
#    -Dhttp.proxyPort=$HTTP_PROXYPORT \
#    -Dhttps.proxyHost=$HTTP_PROXYHOST \
#    -Dhttps.proxyPort=$HTTP_PROXYPORT \
    org.springframework.boot.loader.JarLauncher
 