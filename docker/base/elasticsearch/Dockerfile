FROM elasticsearch:2.4-alpine

MAINTAINER Ryan Schuhler <ryan.schuhler@liferay.com>

COPY ./entrypoint.sh /usr/local/bin
RUN chmod +x /usr/local/bin/entrypoint.sh

COPY ./resources/ /usr/share/elasticsearch/

RUN mkdir -p /tmp/elasticsearch

USER elasticsearch

ENTRYPOINT ["/usr/local/bin/entrypoint.sh"]
CMD ["elasticsearch"]
