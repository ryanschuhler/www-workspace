#!/bin/bash

set -x

cp -rv /tmp/mariadb/. /

exec /docker-entrypoint.sh "$@"
