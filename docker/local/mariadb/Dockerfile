FROM mariadb:www-base

ARG DB_URL

RUN if [ "$DB_URL" != "" ] \
  ; then \
    set -x \
    && curl -fSL "$DB_URL" > /usr/local/bin/db.sql.gz \
    && gzip -d /usr/local/bin/db.sql.gz \
  ; fi
