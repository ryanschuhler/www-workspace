FROM alpine:latest AS liferay-build

MAINTAINER Ryan Schuhler <ryan.schuhler@liferay.com>

ARG LIFERAY_ACTIVATION_KEY_NAME=activation-key.xml
ARG LIFERAY_ACTIVATION_KEY_URL
ARG LIFERAY_BUNDLE_NAME=liferay-bundle.zip
ARG LIFERAY_BUNDLE_URL
ARG LIFERAY_FIXPACK_URLS
ARG BUILD_RESOURCES=/tmp/build-resources
ARG JAVA_PACKAGE=openjdk8

ENV LIFERAY_HOME /opt/java/liferay

RUN apk update \
  && apk upgrade \
  && apk add --no-cache bash curl $JAVA_PACKAGE unzip zip

COPY ./build-resources/ $BUILD_RESOURCES
RUN chmod +x ${BUILD_RESOURCES}/*.sh

RUN mkdir -p /opt/java

RUN if [ ! -f "${BUILD_RESOURCES}/${LIFERAY_BUNDLE_NAME}" ] && [ "$LIFERAY_BUNDLE_URL" != "" ] \
  ; then \
    set -x \
    && curl -fSL "$LIFERAY_BUNDLE_URL" > ${BUILD_RESOURCES}/${LIFERAY_BUNDLE_NAME} \
  ; fi

RUN if [[ -f "${BUILD_RESOURCES}/${LIFERAY_BUNDLE_NAME}" ]] \
  ; then \
    set -x \
    && unzip ${BUILD_RESOURCES}/${LIFERAY_BUNDLE_NAME} -d /opt/java \
    && find /opt/java -depth -maxdepth 1 -type d -name "liferay-*" -exec mv {} /opt/java/liferay \; \
    && mkdir -p /opt/java/liferay/deploy \
    && find /opt/java/liferay -depth -maxdepth 1 -type d -name "tomcat-*" -exec mv {} /opt/java/liferay/tomcat \; \
  ; fi

RUN if [ "$LIFERAY_FIXPACK_URLS" != "" ] \
  ; then \
    set -x \
    && ${BUILD_RESOURCES}/apply-fix-packs.sh $LIFERAY_FIXPACK_URLS \
  ; fi

RUN if [ ! -f "${BUILD_RESOURCES}/${LIFERAY_ACTIVATION_KEY_NAME}" ] && [ "$LIFERAY_ACTIVATION_KEY_URL" != "" ] \
  ; then \
    set -x \
    && curl -fSL "$LIFERAY_ACTIVATION_KEY_URL" > ${BUILD_RESOURCES}/${LIFERAY_ACTIVATION_KEY_NAME} \
  ; fi

RUN if [ ! -f "${BUILD_RESOURCES}/${LIFERAY_ACTIVATION_KEY_NAME}" ] \
  ; then \
    set -x \
    && mv ${BUILD_RESOURCES}/${LIFERAY_ACTIVATION_KEY_NAME} ${LIFERAY_HOME}/osgi/modules \
  ; fi

RUN ${BUILD_RESOURCES}/bundle-exclude.sh

COPY ./resources/ ${LIFERAY_HOME}/

FROM alpine:latest

ARG JAVA_PACKAGE=openjdk8

RUN apk update \
  && apk upgrade \
  && apk add --no-cache bash $JAVA_PACKAGE \
  && addgroup -S liferay \
  && adduser -S -G liferay liferay

ENV LIFERAY_HOME /opt/java/liferay

USER liferay:liferay

COPY --chown=liferay:liferay --from=liferay-build $LIFERAY_HOME $LIFERAY_HOME

COPY ./entrypoint.sh /usr/local/bin/entrypoint.sh

EXPOSE 8080
EXPOSE 11311

ENTRYPOINT ["entrypoint.sh"]
CMD ["/opt/java/liferay/tomcat/bin/catalina.sh", "run"]
