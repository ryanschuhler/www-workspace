#!/bin/bash

chmod u+x ${LIFERAY_HOME}/bin/wait-for-it.sh
bash ${LIFERAY_HOME}/bin/wait-for-it.sh -t 600 mariadb:3306
bash ${LIFERAY_HOME}/bin/wait-for-it.sh -t 600 elasticsearch:9200
