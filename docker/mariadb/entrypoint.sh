#!/bin/sh

set -o errexit

main() {
  #update_db
  exec docker-entrypoint.sh "$@"
}

update_db() {
  if [ -e "$DB_PATH" ] && [ mysql -u root -p$MYSQL_ROOT_PASSWORD -e 'SELECT COUNT(DISTINCT "table_name") FROM "information_schema"."columns" WHERE "table_schema" = "$MYSQL_DATABASE"' ]; then
    echo "Beginning database sourcing"
    set -x
    mysql -u root -p$MYSQL_ROOT_PASSWORD -D $MYSQL_DATABASE < $DB_PATH
  else
    echo "Database is already populated, to refresh the database you can rebuild the container."
  fi
}

main "$@"