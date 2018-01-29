FROM httpd:2.4-alpine

MAINTAINER Ryan Schuhler <ryan.schuhler@liferay.com>

RUN addgroup -S apache \
  && adduser -S -G apache apache \
  && chown -R apache:apache /usr/local/apache2/

#USER apache

COPY --chown=apache:apache ./resources/ /usr/local/apache2/

ENTRYPOINT [ "httpd-foreground"]
