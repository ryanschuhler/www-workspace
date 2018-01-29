#!/bin/bash -x

LICENSE_FILE=activation-key-development-6.2ee-liferaycom.xml
SOURCE_BUNDLE_FILE=liferay-portal-tomcat-6.2-ee-sp20-20170717160924965.zip
PATCH_FILES=liferay-fix-pack-portal-154-6210.zip

# need set this more dynamically so it works across computer setups
DOCKER_BASE=~/liferay/www-workspace/docker/local/liferay62/liferay

BUNDLE_FILE=liferay-bundle.zip

rm -v ${DOCKER_BASE}/${BUNDLE_FILE}
rm -v ${DOCKER_BASE}/resources/patches/*.zip
rm -v ${DOCKER_BASE}/resources/image-deploy/*.xml

CACHE=~/.liferay/

cp -v ${CACHE}/licenses/${LICENSE_FILE} ${DOCKER_BASE}/resources/image-deploy
cp -v ${CACHE}/bundles/${SOURCE_BUNDLE_FILE} ${DOCKER_BASE}/${BUNDLE_FILE}

for PATCH_FILE in ${PATCH_FILES}
do
        cp  -v ${CACHE}/patches/${PATCH_FILE} ${DOCKER_BASE}/resources/patches
done
