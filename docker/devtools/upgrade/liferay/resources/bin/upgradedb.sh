#!/bin/bash

chmod u+x /tmp/liferay/wait-for-it.sh
bash -x /tmp/liferay/wait-for-it.sh -t 600 mariadb:3306

DIR=/opt/java/liferay/tools/portal-tools-db-upgrade-client

cd ${DIR}
export JAVA_OPTS="-Xms4096m -Xmx4096m -XX:MaxNewSize=2048m -XX:+UseConcMarkSweepGC -XX:+CMSParallelRemarkEnabled"
java -jar "${DIR}/com.liferay.portal.tools.db.upgrade.client.jar" -j "${JAVA_OPTS}"

echo "grepping for errors"
grep -i error ${DIR}/upgrade.log
echo "grepping for exceptions"
grep -i exception ${DIR}/upgrade.log
echo "grepping for warnings"
grep -i WARN ${DIR}/upgrade.log

cp ${DIR}/upgrade.log /tmp/liferay/
