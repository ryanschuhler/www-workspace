#!/bin/bash

wait-for-it.sh -t 600 mariadb:3306
wait-for-it.sh -t 600 elasticsearch:9200