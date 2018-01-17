FROM mariadb:www-base

ARG DB_URL


RUN if [ "$DB_URL" != "" ] \
  ; then \
    set -x \
    && curl -fSL "$DB_URL" > /docker-entrypoint-initdb.d/db.sql.gz \
  ; fi

