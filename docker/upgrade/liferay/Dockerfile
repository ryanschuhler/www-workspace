FROM liferay:www-base

COPY resources/ /opt/java/liferay/

RUN chmod +x /opt/java/liferay/upgradedb.sh


#CMD ["/opt/java/liferay/upgradedb.sh" ]
CMD ["bash"]
