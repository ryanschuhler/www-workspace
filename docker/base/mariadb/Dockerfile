FROM mariadb:10.0

MAINTAINER Ryan Schuhler <ryan.schuhler@liferay.com>

RUN apt-get update \
  && apt-get install -y curl gzip \
  && apt-get clean \
  && rm -rf /var/lib/apt/lists/* /tmp/* /var/tmp/*

COPY ./resources /usr/local/bin
RUN chmod +x /usr/local/bin/update-database.sh
