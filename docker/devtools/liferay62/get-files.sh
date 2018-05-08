#!/bin/bash

# Text color variables
txtund=$(tput sgr 0 1)       # Underline
txtbld=$(tput bold)          # Bold
cyn=${txtbld}$(tput setaf 6) # cyan
red=${txtbld}$(tput setaf 1) # red
blu=${txtbld}$(tput setaf 4) # blue
gre=${txtbld}$(tput setaf 2) # green
wht=${txtbld}$(tput setaf 7) # white
ylw=$(tput setaf 3)			     # yellow
off=$(tput sgr0)             # Reset

#Helper functions
ear() {
	echo -e "$cyn \$ $@ $off"
	eval "$@"
}

spacer() { echo -e "$ylw \n-----------\n $off" ; }

checkDir() {
	if [ ! -d "$1" ]; then
		echo -e "$red x $1 directory does not exist $off"

		echo -e "$blu ===> Creating $1 directory $off"

		ear $2

    if ! [ -z "$3" ]; then
			ear "$3"
		fi

	else
		echo -e "$gre ✓ $1 directory exists $off"
	fi

	spacer
}

checkFile() {
	if [ ! -f "$1" ]; then
		echo -e "$red x $1 file does not exist $off"

		echo -e "$blu ===> Copying $1 file $off"

		ear $2

		if ! [ -z "$3" ]; then
			ear "$3"
		fi

	else
		echo -e "$gre ✓ $1 file exists $off"
	fi

	spacer
}

source file-vars.sh

MIRROR=http://mirrors/files.liferay.com/private

spacer

checkDir ".liferay" "mkdir .liferay"

checkDir "$BUNDLE_DIR" "mkdir $BUNDLE_DIR"

checkDir "$DATABASE_DIR" "mkdir $DATABASE_DIR"

checkDir "$HUBSPOT_DIR" "mkdir $HUBSPOT_DIR"

checkDir "$LICENSE_DIR" "mkdir $LICENSE_DIR"

checkDir "$PATCHES_DIR" "mkdir $PATCHES_DIR"

checkFile "${BUNDLE_DIR}/${SOURCE_BUNDLE_FILE}" "curl -o ${BUNDLE_DIR}/${SOURCE_BUNDLE_FILE} -fSL ${MIRROR}/ee/portal/6.2.10.21/${SOURCE_BUNDLE_FILE}"

checkFile "${DATABASE_DIR}/${DATABASE}" "curl -o ${DATABASE_DIR}/${DATABASE} -fSL ${MIRROR}/lrdcom/${DATABASE}"

checkFile "${LICENSE_DIR}/${LICENSE_FILE}" "curl -o ${LICENSE_DIR}/${LICENSE_FILE} -fSL ${MIRROR}/ee/liferay-up/License/6.2/license.xml"

checkFile "${PATCHES_DIR}/${PATCH_FILES}" "curl -o ${PATCHES_DIR}/${PATCH_FILES} -fSL ${MIRROR}/ee/fix-packs/6.2.10/${PATCH_FILES}"