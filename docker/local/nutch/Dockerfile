FROM alpine:latest

MAINTAINER Ryan Schuhler <ryan.schuhler@liferay.com>

WORKDIR /root/

RUN apk update \
  && apk upgrade \
  && apk add --no-cache ant openssh-server vim telnet git rsync curl openjdk-8-jdk-headless \

RUN apt update
RUN apt install -y ant openssh-server vim telnet git rsync curl openjdk-8-jdk-headless

RUN echo 'export JAVA_HOME=/usr/lib/jvm/java-8-openjdk-amd64' >> $HOME/.bashrc

RUN git clone https://github.com/apache/nutch.git nutch_source && cd nutch_source && ant runtime

COPY ./resources/ /nutch_source

RUN ln -s nutch_source/runtime/local $HOME/nutch
