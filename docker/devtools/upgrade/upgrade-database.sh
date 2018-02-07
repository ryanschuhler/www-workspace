#!/bin/bash -x

./get-latest-db-image.sh

docker container rm mariadb
docker container rm upgrade_liferay
docker container rm upgrade_mariadb
docker volume rm docker_mariadb
docker volume rm upgrade_liferay
docker volume rm upgrade_mariadb
docker volume create docker_mariadb
docker-compose up
