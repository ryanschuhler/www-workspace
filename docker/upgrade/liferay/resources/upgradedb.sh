#!/bin/bash

DIR=/opt/java/liferay/tools/portal-tools-db-upgrade-client

cd ${DIR}
export JAVA_OPTS="-Xms4096m -Xmx4096m -XX:MaxNewSize=2048m -XX:+UseConcMarkSweepGC -XX:+CMSParallelRemarkEnabled"
java -jar "${DIR}/com.liferay.portal.tools.db.upgrade.client.jar" -j "${JAVA_OPTS}"

bash