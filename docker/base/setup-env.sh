#!/bin/bash -x 

LICENSE_FILE=activation-key-digitalenterprisedevelopment-7.0-liferaycom.xml
SOURCE_BUNDLE_FILE=liferay-dxp-digital-enterprise-tomcat-7.0-sp6-20171010144253003.zip
PATCH_FILES=liferay-fix-pack-de-36-7010.zip

DOCKER_BASE=~/liferay/www-workspace/docker/base/liferay

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

