#!/bin/bash
OUTPUTDIR=liferay/ssh
mkdir -p ${OUTPUTDIR}
ssh-keygen -t rsa -b 4096 -C "$(git config --global user.email)" -f ${OUTPUTDIR}/id_rsa -N ''

curl -u "$(git config --global user.name)" \
  --data "{\"title\":\"`date +%m/%d/%Y-%H:%M:%S`_DOCKER-LIFERAY-6.2\",\"key\":\"`cat ${OUTPUTDIR}/id_rsa.pub`\"}" \
  https://api.github.com/user/keys