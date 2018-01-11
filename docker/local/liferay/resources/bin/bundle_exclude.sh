#!/bin/bash -x

OSGI_FOLDER=${LIFERAY_HOME}/osgi/marketplace

zip -d ${OSGI_FOLDER}/Liferay\ Connected\ Services\ Client.lpkg lcs-portlet-7.0.10.38.war
zip -d ${OSGI_FOLDER}/Liferay\ Foundation.lpkg  com.liferay.portal.security.ldap-2.2.6.jar
zip -d ${OSGI_FOLDER}/Liferay\ Foundation.lpkg  com.liferay.portal.settings.authentication.ldap.web-1.0.14.jar
zip -d ${OSGI_FOLDER}/Liferay\ Documentum\ Connector.lpkg  documentum-hook-7.0.10.11.war
zip -d ${OSGI_FOLDER}/Liferay\ Sharepoint\ Connector.lpkg  sharepoint-hook-7.0.10.4.war
zip -d ${OSGI_FOLDER}/Liferay\ Marketplace.lpkg com.liferay.marketplace.api-4.2.0.jar
zip -d ${OSGI_FOLDER}/Liferay\ Marketplace.lpkg com.liferay.marketplace.app.manager.web-1.0.17.jar
zip -d ${OSGI_FOLDER}/Liferay\ Marketplace.lpkg com.liferay.marketplace.deployer-2.0.9.jar
zip -d ${OSGI_FOLDER}/Liferay\ Marketplace.lpkg com.liferay.marketplace.service-2.1.28.jar
zip -d ${OSGI_FOLDER}/Liferay\ Marketplace.lpkg com.liferay.marketplace.store.web-2.0.11.jar


remove_module () {
    zip -d "${OSGI_FOLDER}/$1" $2
}

remove_collaboration () {
    remove_module Liferay\ Collaboration.lpkg $1
}

remove_collaboration com.liferay.wiki.api-2.4.3.jar
remove_collaboration com.liferay.wiki.editor.configuration-1.0.8.jar
remove_collaboration com.liferay.wiki.engine.creole-2.0.10.jar
remove_collaboration com.liferay.wiki.engine.html-2.0.4.jar
remove_collaboration com.liferay.wiki.engine.input.editor.common-2.0.3.jar
remove_collaboration com.liferay.wiki.engine.lang-1.0.1.jar
remove_collaboration com.liferay.wiki.engine.text-2.0.2.jar
remove_collaboration com.liferay.wiki.layout.prototype-1.0.6.jar
remove_collaboration com.liferay.wiki.navigation.web-2.0.6.jar
remove_collaboration com.liferay.wiki.service-1.6.7.jar
remove_collaboration com.liferay.wiki.web-2.1.36.jar