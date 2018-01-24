#!/bin/bash -x

cp -rv /tmp/liferay/* ${LIFERAY_HOME}

for script in ${LIFERAY_HOME}/bin/*.sh; do 
    if [ -f ${script} ]; then
        bash -x "${script}"
    fi 
done

bash /usr/local/bin/wait-for-it.sh -t 600 mariadb:3306

exec "$@"
