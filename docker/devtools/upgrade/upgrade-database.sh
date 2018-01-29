#!/bin/bash -x

./get-latest-db-image.sh

#docker container rm mariadb
docker volume rm docker_mariadb
docker container rm upgrade_liferay
docker volume rm upgrade_liferay
docker volume create docker_mariadb
docker-compose up
