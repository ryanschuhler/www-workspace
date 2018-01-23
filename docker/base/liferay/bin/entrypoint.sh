#!/bin/bash -x

cp -rv /tmp/liferay/* ${LIFERAY_HOME}

for script in ${LIFERAY_HOME}/bin/*.sh; do 
    if [ -f ${script} ]; then
        bash -x "${script}"
    fi 
done

exec "$@"
