#!/bin/bash -x

env

PATCH_FILES_DIR=/tmp/build-resources/patches

PATCH_FILES=`find $PATCH_FILES_DIR -type f`

# Exit if no fixpack urls defined
if [ -z "$LIFERAY_FIXPACK_DOWNLOAD_URLS" ] && [ -z "$PATCH_FILES" ]
then
    exit 0
fi

PATCHING_TOOL_HOME=/opt/java/liferay/patching-tool

# Delete any patches that may have been delivered with the bundle
rm -fv ${PATCHING_TOOL_HOME}/patches/*.zip

cd ${PATCHING_TOOL_HOME}/patches/

if [ ! -z "$PATCH_FILES" ]
then
    for PATCH_FILE in ${PATCH_FILES}
    do
        mv -v $PATCH_FILE ${PATCHING_TOOL_HOME}/patches/
    done
else
    # Parse semi colon delimited list of URLs into an array
    IFS=';' read -r -a URLARRAY <<< "$LIFERAY_FIXPACK_DOWNLOAD_URLS"

    # Iterate through uRLs and download patches / hot fixes
    for URL in "${URLARRAY[@]}"
    do
        curl -fSL -O "$URL"
        rc=$?; if [[ $rc != 0 ]]; then exit $rc; fi
    done
fi

sed -i 's/tomcat[^\/]*/tomcat/g' ${PATCHING_TOOL_HOME}/default.properties

bash ${PATCHING_TOOL_HOME}/patching-tool.sh install -force
rm -rfv ${PATCHING_TOOL_HOME}/patches/*
rm -rfv /opt/java/liferay/tomcat/webapps/ROOT/WEB-INF/patching-backup.zip
