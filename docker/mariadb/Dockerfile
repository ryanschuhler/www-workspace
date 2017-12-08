FROM mariadb:10.0

MAINTAINER Ryan Schuhler <ryan.schuhler@liferay.com>

ARG DB_URL

ENV DB_PATH=/tmp/db.sql.gz

RUN apt-get update \
  && apt-get install -y curl gzip \
  && apt-get clean \
  && rm -rf /var/lib/apt/lists/* /tmp/* /var/tmp/*

RUN if [ "$DB_URL" != "" ]; then \
    set -x \
    && curl -fSL "$DB_URL" -o $DB_PATH \
    && gzip -d $DB_PATH; \
  fi

COPY ./entrypoint.sh /usr/local/bin
RUN chmod +x /usr/local/bin/entrypoint.sh

#ENTRYPOINT ["entrypoint.sh"]