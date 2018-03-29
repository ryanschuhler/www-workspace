#!/bin/bash

source file-vars.sh

REPO_ROOT=$(git rev-parse --show-toplevel)

DOCKER_BASE=${REPO_ROOT}/docker/devtools/liferay62/liferay
MARIADB=${REPO_ROOT}/docker/devtools/liferay62/mariadb
DOCKER_HUBSPOT=${REPO_ROOT}/docker/devtools/hubspot

BUNDLE_FILE=liferay-bundle.zip

rm -v ${DOCKER_BASE}/${BUNDLE_FILE}
rm -v ${DOCKER_BASE}/resources/patches/*.zip
rm -v ${DOCKER_BASE}/resources/image-deploy
rm -vrf ${MARIADB}/resources/docker-entrypoint-initdb.d/

mkdir -p ${DOCKER_BASE}/resources/patches
mkdir -p ${DOCKER_BASE}/resources/image-deploy
mkdir -p ${MARIADB}/resources/docker-entrypoint-initdb.d/

cp -v "${LICENSE_DIR}/${LICENSE_FILE}" "${DOCKER_BASE}/resources/image-deploy"
cp -v "${BUNDLE_DIR}/${SOURCE_BUNDLE_FILE}" "${DOCKER_BASE}/${BUNDLE_FILE}"
cp -v "${DATABASE_DIR}/${DATABASE}" "${MARIADB}/resources/docker-entrypoint-initdb.d/"
cp -v "${HUBSPOT_DIR}/hubspot.json" "${DOCKER_HUBSPOT}/resources"

for PATCH_FILE in ${PATCH_FILES}
do
  cp  -v "${PATCHES_DIR}/${PATCH_FILE}" "${DOCKER_BASE}/resources/patches"
done
