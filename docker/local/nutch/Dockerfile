FROM alpine:latest

MAINTAINER Ryan Schuhler <ryan.schuhler@liferay.com>

RUN apk update \
  && apk upgrade \
  && apk add --no-cache apache-ant bash busybox-extras curl openjdk8 openssh-server rsync vim

RUN set -x \
  && mkdir -p /opt/java/nutch \
  && curl -fSL "https://github.com/apache/nutch/archive/master.zip" > /opt/java/nutch.zip \
  && unzip /opt/java/nutch.zip -d /opt/java \
  && rm /opt/java/nutch.zip \
  && cd /opt/java/nutch-master \
  && ant runtime

COPY ./resources/ /tmp/nutch/

RUN ln -s /opt/java/nutch-master/runtime/local /opt/java/nutch
ENTRYPOINT ["tail", "-f", "/dev/null"]
