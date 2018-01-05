#!/bin/bash

set -x

cp -rv /tmp/mariadb/. /docker-entrypoint-initdb.d

exec /docker-entrypoint.sh "$@"
