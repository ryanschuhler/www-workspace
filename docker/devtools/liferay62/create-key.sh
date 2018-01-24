#!/bin/bash

echo -n "Email address: "
read EMAIL

OUTPUTDIR=liferay-plugins/ssh
mkdir -p ${OUTPUTDIR}
ssh-keygen -t rsa -b 4096 -C "${EMAIL}" -f ${OUTPUTDIR}/id_rsa -N ''

echo Now you can add this public key to github as a deploy key:
cat ${OUTPUTDIR}/id_rsa.pub
echo see here https://help.github.com/articles/connecting-to-github-with-ssh/