#!/bin/bash -x

LICENSE_FILE=activation-key-development-6.2ee-liferaycom.xml
SOURCE_BUNDLE_FILE=liferay-portal-tomcat-6.2-ee-sp20-20170717160924965.zip
PATCH_FILES=liferay-fix-pack-portal-164-6210.zip
DATABASE=www_lportal-2018-02-01_19-00-PST.sql.gz

# need set this more dynamically so it works across computer setups
DOCKER_BASE=~/liferay/www-workspace/docker/devtools/liferay62/liferay
MARIADB=~/liferay/www-workspace/docker/devtools/liferay62/mariadb

BUNDLE_FILE=liferay-bundle.zip

rm -v ${DOCKER_BASE}/${BUNDLE_FILE}
rm -v ${DOCKER_BASE}/resources/patches/*.zip
rm -v ${DOCKER_BASE}/resources/image-deploy
rm -vrf ${MARIADB}/resources/docker-entrypoint-initdb.d/

mkdir -p ${DOCKER_BASE}/resources/patches
mkdir -p ${DOCKER_BASE}/resources/image-deploy
mkdir -p ${MARIADB}/resources/docker-entrypoint-initdb.d/

CACHE=~/.liferay/

cp -v ${CACHE}/licenses/${LICENSE_FILE} ${DOCKER_BASE}/resources/image-deploy
cp -v ${CACHE}/bundles/${SOURCE_BUNDLE_FILE} ${DOCKER_BASE}/${BUNDLE_FILE}
cp -v ${CACHE}/databases/${DATABASE} ${MARIADB}/resources/docker-entrypoint-initdb.d/

for PATCH_FILE in ${PATCH_FILES}
do
        cp  -v ${CACHE}/patches/${PATCH_FILE} ${DOCKER_BASE}/resources/patches
done
