#!/bin/bash -x

env
if [ -z "$LIFERAY_FIXPACK_DOWNLOAD_URLS" ] 
then 
    exit 0
fi

rm -fv /opt/java/liferay/patching-tool/patches/*.zip 
cd /opt/java/liferay/patching-tool/patches/ 
IFS=';' read -r -a URLARRAY <<< "$LIFERAY_FIXPACK_DOWNLOAD_URLS" 
for URL in "${URLARRAY[@]}" 
do 
    curl -fSL -O "$URL" 
done 

sed -i 's/tomcat[^\/]*/tomcat/g' /opt/java/liferay/patching-tool/default.properties 

bash /opt/java/liferay/patching-tool/patching-tool.sh install -force 