#!/bin/bash

chmod u+x /tmp/liferay/bin/wait-for-it.sh
bash /tmp/liferay/bin/wait-for-it.sh -t 600 mariadb:3306
bash /tmp/liferay/bin/wait-for-it.sh -t 600 elasticsearch:9200
