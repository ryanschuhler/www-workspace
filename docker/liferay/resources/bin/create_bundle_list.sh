#!/bin/bash

OSGI_FOLDER=${LIFERAY_HOME}/osgi/marketplace

for file in ${OSGI_FOLDER}/*.lpkg; do
    echo ${file}
    unzip -l "${file}" | grep -i [jar\|war] | awk -v file="${file}" '{print file ":" $4}' | sed 's/ /\\ /g'  | sed 's/:/ /g'
done
