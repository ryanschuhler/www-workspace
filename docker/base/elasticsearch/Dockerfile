FROM elasticsearch:alpine

MAINTAINER Ryan Schuhler <ryan.schuhler@liferay.com>

RUN /usr/share/elasticsearch/bin/elasticsearch-plugin install --batch analysis-icu
RUN /usr/share/elasticsearch/bin/elasticsearch-plugin install --batch analysis-kuromoji
RUN /usr/share/elasticsearch/bin/elasticsearch-plugin install --batch analysis-smartcn
RUN /usr/share/elasticsearch/bin/elasticsearch-plugin install --batch analysis-stempel

COPY ./entrypoint.sh /usr/local/bin
RUN chmod +x /usr/local/bin/entrypoint.sh

COPY ./resources/ /usr/share/elasticsearch/

RUN mkdir -p /tmp/elasticsearch

USER elasticsearch

ENTRYPOINT ["/usr/local/bin/entrypoint.sh"]
CMD ["elasticsearch"]
