#!/bin/bash -x

for script in ${LIFERAY_HOME}/bin/startup/*.sh; do
    if [ -f ${script} ]; then
        bash -x "${script}"
    fi
done

exec "$@"
