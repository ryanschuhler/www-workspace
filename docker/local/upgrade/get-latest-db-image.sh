#!/bin/bash -x

ENTRYPOINT_DIR=mariadb/resources/docker-entrypoint-initdb.d
rm -rfv ${ENTRYPOINT_DIR}
mkdir -p ${ENTRYPOINT_DIR}
cp *.sql ${ENTRYPOINT_DIR}
BASE_URL=http://mirrors/files.liferay.com/private/lrdcom/
DB_URL=`curl -s ${BASE_URL} | grep www_lportal | tail -1 | perl -n  -e'/href=\"(.*)\"/ && print $1' `
curl -fSL ${BASE_URL}/${DB_URL} > ${ENTRYPOINT_DIR}/db.sql.gz


