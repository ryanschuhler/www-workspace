#!/bin/bash -x 

for PLUGIN in ${PLUGINS_LIST}
do 
    echo ${PLUGIN}
    cd /opt/java/plugins-sdk/${PLUGIN}
    ant all
done