FROM mariadb:latest

MAINTAINER Ryan Schuhler <ryan.schuhler@liferay.com>

COPY ./resources/ /

USER mysql

ENTRYPOINT ["/docker-entrypoint.sh"]
CMD ["mysqld"]
