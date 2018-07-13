#!/bin/bash -x 

LICENSE_FILE=activation-key-digitalenterprisedevelopment-7.0-liferaycom.xml
SOURCE_BUNDLE_FILE=liferay-dxp-digital-enterprise-tomcat-7.0-sp7-20180307180151313.zip
SOURCE_BUNDLE_FILE=liferay-dxp-tomcat-7.1.10-ga1-20180703090613030.zip
PATCH_FILES=portal/liferay-fix-pack-de-44-7010.zip
PATCH_FILES=
DB_FILE=www_lportal-2018-02-01-upgraded-with-events.sql.gz
DB_FILE=www_lportal-2018-04-22-upgraded.sql.gz

REPO_ROOT=~/liferay/www-workspace 

DOCKER_LIFERAY=${REPO_ROOT}/docker/liferay
DOCKER_MARIADB=${REPO_ROOT}/docker/mariadb
DOCKER_HUBSPOT=${REPO_ROOT}/docker/devtools/hubspot 

BUNDLE_FILE=liferay-bundle.zip
BUILD_RESOURCES=${DOCKER_LIFERAY}/build-resources

rm -v ${BUILD_RESOURCES}/${BUNDLE_FILE}
rm -v ${BUILD_RESOURCES}/patches/*.zip
rm -v ${BUILD_RESOURCES}/*.xml
rm -v ${DOCKER_MARIADB}/resources/docker-entrypoint-initdb.d/*
mkdir -p ${BUILD_RESOURCES}/patches

CACHE=~/.liferay/

cp -v ${CACHE}/licenses/${LICENSE_FILE} ${BUILD_RESOURCES}/activation-key.xml
cp -v ${CACHE}/bundles/${SOURCE_BUNDLE_FILE} ${BUILD_RESOURCES}/${BUNDLE_FILE}

for PATCH_FILE in ${PATCH_FILES}
do
        cp  -v ${CACHE}/patches/${PATCH_FILE} ${BUILD_RESOURCES}/patches
done

cp -v ${CACHE}/databases/${DB_FILE} ${DOCKER_MARIADB}/resources/docker-entrypoint-initdb.d
cp -v ~/liferay/www-workspace/docker/devtools/upgrade/www_lportal-updatedb.sql ${DOCKER_MARIADB}/resources/docker-entrypoint-initdb.d

cp ${CACHE}/hubspot/hubspot.json ${DOCKER_HUBSPOT}/resources


