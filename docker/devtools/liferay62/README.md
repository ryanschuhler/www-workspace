# Liferay 6.2

This is a docker environment for getting Liferay 6.2 up and running, complete with Apache and a mock HubSpot server. The dockerfile is written so that it
clones a git repo for the plugins and builds a list of plugins that are then installed in Liferay.

## Quickstart

> From the `liferay62` folder run:

1.  `./get-files.sh`
2.  `./create-key.sh`
3.  `./setup-env.sh`
4.  `docker-compose build`
5.  `docker-compose up`

## General docker

### Command tips

> Creating & Starting the containers

* To _run in background_ `docker-compose up -d`
  * To _check static logs_ `docker-compose logs -f`
* To run in foreground `docker-compose up`
* To get into a containers shell `docker-compose exec CONTAINER_NAME bash`

### Cache Info

Although Docker does a nice job of caching sometimes I end up fetching the same network resources over and over again. Therefore I decided to store
a bunch of commonly used Liferay files in my home directory ~/.liferay ala Liferay Workspace. I created a bunch of subdirectories there for various files:

* ~/.liferay/licenses/

  This contains xml license files. You can generate these from your Liferay account.

* ~/.liferay/bundles/

  Liferay Bundles, i.e. for DXP or 6.2. This is the same directory liferay workspace uses for storing bundles

* ~/.liferay/patches/

  Liferay fix packs and hot fixes

* The script `get-files.sh` will setup those directories and download the files if you don't have them
* The script `setup-env.sh` will copy files from those locations into the docker build directories and when docker builds the liferay image, it looks there instead of trying to download the files from the network.

## Additional info

* You can run `../upgrade/get-latest-db-image.sh` to get the latest db image to populate your database
* Set up a github key. The script create-key.sh will create one for you and put it in the right directory. You just have to set it up in github e.g. as a deploy key for the repo that you are using. Note that this key will be copied into the first stage of the docker build but will not be copied to the final image. Best to define it as a deploy key with only read access to your repo. Here is a link for more info about setting up github and ssh: [Connecting to Github with ssh](https://help.github.com/articles/connecting-to-github-with-ssh/)
* Configure repo and branch to pull plugins from. Currently it defaults as follows. Changes can be made in the docker-compose.yaml file

  > `ARG REPO=git@github.com:allen-ziegenfus/liferay-plugins-ee.git`

  > `ARG BRANCH=ee-6.2.x`

* Run `docker-compose build` The dockerfile is multi-stage and first creates an environment with the jdk, ant and git to clone the repo and build the plugins. After everything is built it only copies the necessary files to the liferay image that runs with the jre, without ant/ git or the ssh keys. Note that git has to download about 500MB for cloning ee-6.2.x so this will take a while and make sure your laptop does not fall asleep as otherwise you might get an interrupted connection.
* Run `docker-compose up`. If everything goes right liferay should start with all the plugins installed.

## Configuring Plugins

You can set portlet properties by just adding directories under liferay/build-properties. The directories should match how the plugin is set up in the plugins-sdk. These directories are just copied over the source so you could also theoretically modify also source code. For example for the hubspot-portlet you can add portlet-properties in this file:

> `liferay/build-properties/portlets/hubspot-portlet/docroot/WEB-INF/src/portlet-ext.properties`
