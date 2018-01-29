#!/bin/bash -x 

LICENSE_FILE=activation-key-digitalenterprisedevelopment-7.0-liferaycom.xml
SOURCE_BUNDLE_FILE=liferay-dxp-digital-enterprise-tomcat-7.0-sp6-20171010144253003.zip
PATCH_FILES=liferay-fix-pack-de-36-7010.zip
DB_FILE=www_lportal-2018-01-24-upgraded.sql.gz

DOCKER_LIFERAY=~/liferay/www-workspace/docker/liferay
DOCKER_MARIADB=~/liferay/www-workspace/docker/mariadb
DOCKER_HUBSPOT=~/liferay/www-workspace/docker/devtools/hubspot 

BUNDLE_FILE=liferay-bundle.zip

rm -v ${DOCKER_LIFERAY}/${BUNDLE_FILE}
rm -v ${DOCKER_LIFERAY}/resources/patches/*.zip
rm -v ${DOCKER_LIFERAY}/resources/image-deploy/*.xml
rm -v ${DOCKER_MARIADB}/resources/docker-entrypoint-initdb.d/*
mkdir -p ${DOCKER_LIFERAY}/resources/patches

CACHE=~/.liferay/

cp -v ${CACHE}/licenses/${LICENSE_FILE} ${DOCKER_LIFERAY}/resources/image-deploy
cp -v ${CACHE}/bundles/${SOURCE_BUNDLE_FILE} ${DOCKER_LIFERAY}/${BUNDLE_FILE}

for PATCH_FILE in ${PATCH_FILES}
do
        cp  -v ${CACHE}/patches/${PATCH_FILE} ${DOCKER_LIFERAY}/resources/patches
done

cp -v ${CACHE}/databases/${DB_FILE} ${DOCKER_MARIADB}/resources/docker-entrypoint-initdb.d
cp -v ~/liferay/www-workspace/docker/devtools/upgrade/www_lportal-updatedb.sql ${DOCKER_MARIADB}/resources/docker-entrypoint-initdb.d

cp ${CACHE}/hubspot/hubspot.json ${DOCKER_HUBSPOT}/resources


