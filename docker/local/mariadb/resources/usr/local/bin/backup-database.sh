#!/bin/bash

mysqldump -u root --password=${MYSQL_ROOT_PASSWORD} lportal --result-file=backup.sql
