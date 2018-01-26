FROM alpine:latest AS liferay-build

MAINTAINER Allen Ziegenfus <allen.ziegenfus@liferay.com>

ARG JAVA_PACKAGE=openjdk7
ARG LIFERAY_PLUGINS_SDK=liferay-plugins-sdk.zip
ARG LIFERAY_BUNDLE=liferay-bundle.zip

RUN apk update \
  && apk upgrade \
  && apk add --no-cache apache-ant bash curl git $JAVA_PACKAGE openssh-client tree unzip zip \
  && addgroup -S liferay \
  && adduser -S -G liferay liferay

ARG LIFERAY_PLUGINS_SDK_DOWNLOAD_URL
ARG LIFERAY_DOWNLOAD_URL
ARG LIFERAY_FIXPACK_DOWNLOAD_URLS
ARG REPO=git@github.com:allen-ziegenfus/liferay-plugins-ee.git
ARG BRANCH=ee-6.2.x
ENV LIFERAY_HOME /opt/java/liferay
ENV JAVA_HOME /usr/lib/jvm/java-1.7-openjdk
ENV PLUGINS_LIST hooks/osb-www-hook hooks/portal-compat-hook portlets/osb-www-asset-publisher-portlet portlets/hubspot-portlet themes/osb-community-theme portlets/osb-www-marketing-events-portlet portlets/marketplace-portlet portlets/osb-www-portlet

RUN chmod o+w /usr/share/java/apache-ant/lib

USER liferay:liferay

COPY --chown=liferay:liferay ./*.zip /opt/java/

RUN if [ ! -f "/opt/java/${LIFERAY_BUNDLE}" ] && [ "$LIFERAY_DOWNLOAD_URL" != "" ] \
  ; then \
    set -x \
    && curl -fSL "$LIFERAY_DOWNLOAD_URL" > /opt/java/${LIFERAY_BUNDLE} \
  ; fi

RUN if [[ ! -f "/opt/java/*.zip" ]] \
  ; then \
    set -x \
    && unzip /opt/java/${LIFERAY_BUNDLE} -d /opt/java \
    && rm /opt/java/*.zip \
    && find /opt/java -depth -maxdepth 1 -type d -name "liferay-*" -exec mv {} /opt/java/liferay \; \
    && mkdir -p /opt/java/liferay/deploy \
    && find /opt/java/liferay -depth -maxdepth 1 -type d -name "tomcat-*" -exec mv {} /opt/java/liferay/tomcat \; \
  ; fi

RUN mkdir -p /opt/java/liferay/tomcat/deploy

COPY --chown=liferay:liferay ./bin-build/*.sh /usr/local/bin/

RUN chmod +x /usr/local/bin/*.sh
RUN cp /opt/java/liferay/tomcat/lib/ecj* /usr/share/java/apache-ant/lib

RUN mkdir -p /home/liferay/.ssh
COPY --chown=liferay:liferay ssh/ /home/liferay/.ssh/
RUN ssh-keyscan -t rsa github.com > ~/.ssh/known_hosts
RUN git clone ${REPO} --single-branch --branch ${BRANCH} --depth=1 --progress  /opt/java/plugins-sdk

# copy over build properites and portlet properties
COPY --chown=liferay:liferay build-properties/ /opt/java/plugins-sdk

RUN build_plugins.sh ${PLUGINS_LIST}

FROM alpine:latest

MAINTAINER Allen Ziegenfus <allen.ziegenfus@liferay.com>

ARG JAVA_PACKAGE=openjdk7-jre

RUN apk update \
  && apk upgrade \
  && apk add --no-cache bash curl $JAVA_PACKAGE tree unzip zip \
  && addgroup -S liferay \
  && adduser -S -G liferay liferay

ARG LIFERAY_DOWNLOAD_URL
ARG LIFERAY_FIXPACK_DOWNLOAD_URLS

ENV LIFERAY_HOME /opt/java/liferay

USER liferay:liferay

COPY --chown=liferay:liferay --from=liferay-build /opt/java/liferay /opt/java/liferay

COPY --chown=liferay:liferay ./bin/*.sh /usr/local/bin/
RUN chmod +x /usr/local/bin/*.sh

EXPOSE 8080/tcp
EXPOSE 11311/tcp

COPY --chown=liferay:liferay ./resources/ ${LIFERAY_HOME}/

RUN apply-fix-packs.sh $LIFERAY_FIXPACK_DOWNLOAD_URLS

RUN mkdir -p /tmp/liferay

ENTRYPOINT ["entrypoint.sh"]
CMD ["/opt/java/liferay/tomcat/bin/catalina.sh", "run"]
