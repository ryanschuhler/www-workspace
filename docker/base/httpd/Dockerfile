FROM httpd:alpine

MAINTAINER Ryan Schuhler <ryan.schuhler@liferay.com>

COPY ./entrypoint.sh /usr/local/bin
RUN chmod +x /usr/local/bin/entrypoint.sh

COPY ./resources/ /usr/local/apache2/

RUN mkdir -p /tmp/httpd

ENTRYPOINT ["/usr/local/bin/entrypoint.sh"]
CMD ["httpd-foreground"]
