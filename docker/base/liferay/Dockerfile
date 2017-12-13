FROM alpine:3.5

MAINTAINER Ryan Schuhler <ryan.schuhler@liferay.com>

RUN apk update \
  && apk upgrade \
  && apk add --no-cache bash curl openjdk8 tree unzip \
  && addgroup -S liferay \
  && adduser -S -g liferay liferay

ARG LIFERAY_DOWNLOAD_URL
ARG LIFERAY_FIXPACK_DOWNLOAD_URL

ENV LIFERAY_HOME=/opt/java/liferay

COPY ./*.zip /opt/java/

RUN if [ ! -f "/opt/java/liferay.zip" ] && [ "$LIFERAY_DOWNLOAD_URL" != "" ] \
  ; then \
    set -x \
    && curl -fSL "$LIFERAY_DOWNLOAD_URL" > /opt/java/liferay.zip \
  ; fi

RUN if [[ ! -f "/opt/java/*.zip" ]] \
  ; then \
    set -x \
    && unzip /opt/java/liferay.zip -d /opt/java \
    && rm /opt/java/*.zip \
    && find /opt/java -depth -maxdepth 1 -type d -name "liferay-*" -exec mv {} /opt/java/liferay \; \
    && mkdir -p /opt/java/liferay/deploy \
    && find /opt/java/liferay -depth -maxdepth 1 -type d -name "tomcat-*" -exec mv {} /opt/java/liferay/tomcat \; \
  ; fi

RUN if [ "$LIFERAY_FIXPACK_DOWNLOAD_URL" != "" ] \
  ; then \
    set -x \
    && if [[ ! -f "/opt/java/liferay/patching-tool/patches/*.zip" ]]; then rm /opt/java/liferay/patching-tool/patches/*.zip; fi \
    && cd /opt/java/liferay/patching-tool/patches/ \
    && curl -fSL -O "$LIFERAY_FIXPACK_DOWNLOAD_URL" \
    && sed -i 's/tomcat[^\/]*/tomcat/g' /opt/java/liferay/patching-tool/default.properties \
    && bash /opt/java/liferay/patching-tool/patching-tool.sh install -force \
  ; fi

EXPOSE 8080/tcp
EXPOSE 11311/tcp

COPY resources/ /opt/java/liferay/

RUN chown -R liferay /opt/java/liferay /usr/local/bin

CMD ["/opt/java/liferay/tomcat/bin/catalina.sh", "run"]
