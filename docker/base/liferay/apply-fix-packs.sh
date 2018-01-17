#!/bin/bash -x

env

# Exit if no fixpack urls defined
if [ -z "$LIFERAY_FIXPACK_DOWNLOAD_URLS" ] 
then 
    exit 0
fi

PATCHING_TOOL_HOME=/opt/java/liferay/patching-tool

# Delete any patches that may have been delivered with the bundle
rm -fv ${PATCHING_TOOL_HOME}/patches/*.zip 

cd ${PATCHING_TOOL_HOME}/patches/ 

# Parse semi colon delimited list of URLs into an array
IFS=';' read -r -a URLARRAY <<< "$LIFERAY_FIXPACK_DOWNLOAD_URLS" 

# Iterate through uRLs and download patches / hot fixes
for URL in "${URLARRAY[@]}" 
do 
    curl -fSL -O "$URL" 
done 

sed -i 's/tomcat[^\/]*/tomcat/g' ${PATCHING_TOOL_HOME}/default.properties 

bash ${PATCHING_TOOL_HOME}/patching-tool.sh install -force 