#!/bin/bash

set -e;

if [[ $1 =~ "/opt/java/liferay/tomcat/bin/catalina.sh" && $(id -u) = "0" ]]; then
  chown -R liferay /opt/java/liferay /usr/local/bin;

  exec gosu liferay "$0" "$@";
fi

exec "$@";
