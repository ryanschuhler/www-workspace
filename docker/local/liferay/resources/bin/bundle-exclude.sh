#!/bin/bash -x

OSGI_FOLDER=${LIFERAY_HOME}/osgi/marketplace

remove_module () {
    zip -d "${OSGI_FOLDER}/$1" $2
}

remove_module Liferay\ Connected\ Services\ Client.lpkg lcs-portlet*
remove_module Liferay\ Foundation.lpkg  com.liferay.portal.security.ldap*
remove_module Liferay\ Foundation.lpkg  com.liferay.portal.settings.authentication.ldap*
remove_module Liferay\ Documentum\ Connector.lpkg  documentum-hook*
remove_module Liferay\ Sharepoint\ Connector.lpkg  sharepoint-hook*
remove_module Liferay\ Marketplace.lpkg com.liferay.marketplace*
remove_module Liferay\ Sync\ Connector.lpkg com.liferay.sync*
remove_module Liferay\ Collaboration.lpkg com.liferay.message.boards*
remove_module Liferay\ Collaboration.lpkg com.liferay.social*
remove_module Liferay\ Collaboration.lpkg com.liferay.wiki*
remove_module Liferay\ Forms\ and\ Workflow.lpkg com.liferay.polls*
remove_module Liferay\ Forms\ and\ Workflow.lpkg com.liferay.calendar*