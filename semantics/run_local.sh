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
# Shell script to build and run a local semantics layer for testing purposes.
#
# Prerequisites: 
#   Windows, (git)-bash shell, java 11 (java) and maven (mvn) in the $PATH.
#
# Synposis: 
#   ./run_local.sh
#
# Comments: 
#

mvn clean install
java \
    -classpath .\;target/semantics-1.0.0.jar \
    org.springframework.boot.loader.JarLauncher
 