#!/bin/bash

set -x

cp -rv /tmp/elasticsearch/. /usr/share/elasticsearch

exec "$@"
