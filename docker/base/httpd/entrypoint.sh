#!/bin/bash

set -x

cp -rv /tmp/httpd/. /usr/local/apache2

exec "$@"
