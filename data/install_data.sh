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
# Shell script to build and run a test generation/instalation.
#
# Prerequisites: 
#   Windows, (git)-bash shell, java 11 (java) and maven (mvn) in the $PATH.
#
# Synposis: 
#   ./install_data.sh
#
# Comments: 
#   Requires a $STORAGE_CONNECTIONSTRING environment variable set.
#   If you do not need a corporate proxy setting, please
#   uncomment the lines.
#

mvn clean install -DskipTests

java \
  -Dhttps.proxyHost=$HTTP_PROXY_HOST -Dhttps.proxyPort=$HTTP_PROXY_PORT \
  -classpath target/data-latest-jar-with-dependencies.jar net.catenax.data.FillTable \
  +connection $STORAGEACCOUNT_CONNECTIONSTRING +table BusinessPartners -replace -object +partitionKey BusinessPartners +rowKey .oneID gpm/*.json

java \
  -Dhttps.proxyHost=$HTTP_PROXY_HOST -Dhttps.proxyPort=$HTTP_PROXY_PORT \
  -classpath target/data-latest-jar-with-dependencies.jar net.catenax.data.FillTable \
  +connection $STORAGEACCOUNT_CONNECTIONSTRING +table BusinessPartners -replace -object +partitionKey BusinessPartners +rowKey .oneID -array gpm_extended_testdata.json

java \
  -Dhttps.proxyHost=$HTTP_PROXY_HOST -Dhttps.proxyPort=$HTTP_PROXY_PORT \
  -classpath target/data-latest-jar-with-dependencies.jar net.catenax.data.FillTable \
  +connection $STORAGEACCOUNT_CONNECTIONSTRING +table OneIdDnsMapping -replace -properties +partitionKey .oneID +rowKey .idsConnectorID -array cdns/cdns_testdata.json