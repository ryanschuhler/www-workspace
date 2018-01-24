#!/bin/bash -x

./get-latest-db-image.sh

docker container rm local_mariadb 
docker volume rm local_mariadb 
docker container rm upgrade_liferay
docker volume rm upgrade_liferay
docker volume create local_mariadb
docker-compose up 
