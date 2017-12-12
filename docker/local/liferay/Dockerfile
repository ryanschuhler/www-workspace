FROM liferay:www-base

COPY resources/ /opt/java/liferay/

ENTRYPOINT ["docker-entrypoint.sh"]

CMD ["/opt/java/liferay/tomcat/bin/catalina.sh", "run"]
