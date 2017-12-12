#!/bin/sh

DB_FILE=$1

if [[ -z $DB_FILE ]] \
  ; then \
    DB_FILE="/usr/local/bin/db.sql" \
  ; fi

set -x

mysql -u root -v -p$MYSQL_ROOT_PASSWORD -D $MYSQL_DATABASE < $DB_FILE
