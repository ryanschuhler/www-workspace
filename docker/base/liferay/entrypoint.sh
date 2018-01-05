#!/bin/bash

set -x

cp -rv /tmp/liferay/* /opt/java/liferay

exec "$@"
