# Docker Environment
This is an environment setup for www.liferay.com using both docker and Liferay workspaces. For help, questions, improvements or anything else feel free to contact [Ryan Schuhler](ryan.schuhler@liferay.com)

## Getting Started
* Intall [Docker](https://docs.docker.com/engine/installation/)
	* Increase memory in docker (in app preferences)
* Make sure that [gradle](https://gradle.org/install/) is installed and your `PATH` environment variable is updated
* From the `docker/local` folder you can run `gradle build`
  * This should take around 10 minutes the first time you run it. After that it caches many of the files so subsequent builds should be faster depending on what you have changed.
* Run `gradle up`
* Go to [localhost](http://localhost) in your browser
* To shut down your containers you can run `gradle down`

### Notes
* You need to be on the office network or vpnd into the office in order to download some of the files form mirrors.liferay
* If you are seeing issues with apache and conflicting ports on *Mac* you may be running apache already and can stop it by running `sudo apachectl stop`
* If you are seeing errors with scripts on *Windows* it might be an issue with line endings and bash. You can use dos2unix to correct or set the config for line endings in git (ie `dos2unix liferay/entrypoint.sh` or `git config --global autocrlf input`)
* *Linux* does not currently have a desktop client. You will have to download the server client and set up a docker-machine. This causes some issues with downloading from mirrors.liferay, so you will have to download the bundle and/or database and include them in the respective folders to use. Here are a few [helpful](https://docs.docker.com/engine/installation/linux/docker-ce/ubuntu) [links](https://docs.docker.com/engine/installation/linux/linux-postinstall/). 

## Useful commands
* Run `gradle tasks --all` to see all available tasks in any given folder
* You can run `docker ps -a` to see the containers and their statuses
* For logs run `docker logs -f [CONTAINER_ID|CONTAINER_NAME]` ie `docker logs -f liferay`
* To navigate the terminal of a container run  `docker exec -it [CONTAINER_ID|CONTAINER_NAME] /bin/sh` ie `docker exec -it mariadb /bin/sh`
* As you make changes to modules you can run `gradle deploy` and it will automaically deploy them to your containers.
* To copy files from your computer to a docker container run `docker cp [localPath] [containerName]:[containerPath]` ie `docker cp -a ~/Desktop/dxp/deploy/ liferay:/opt/java/liferay/deploy`

## What is installed
If you look at the docker-compose.yaml you can see all of the containers and settings that are being installed. These include
* Web Server
	* Using httpd
	* This handles the intial request when you hit <http://localhost> and directs you to the liferay instance
* Database Server
	* Using mariadb
	* This is a separate server for the database to provide easier scalability
	* If you set the `DB_URL` variable in docker-compose.yaml it will download and source your database for you (not working yet)
* Search Server
	* Using elasticsearch
	* This is a dedicated server to store search indexes
	* You can see the indexes at <http://localhost:9200/_cat/indices>
* Email Server
	* Using mockmock
	* This is just for testing so that you can send emails from liferay and see them at <http://localhost:8282>
* Liferay Instance
	* This is your running instance of liferay
	* Notice you can add files to the `/www-workspace/docker/local/liferay/resources` and they will be copied to your instance for you
	* If you want to download your own bundle instead of using the url to download, you can do so by adding a `bundle.zip` to the `/www-workspace/docker/base/liferay` folder

## Upgrading the database
There is an extra docker configuration for upgrading the latest lrdcom database to DXP. The upgrade-database.sh script will look for the latest database image and download it. The script deletes any existing local_mariadb containers and volumes so make sure you don't have any important data there. After importing the latest db image it runs the database upgrade process. If it runs successfully you will see the message done. On my system it takes about 1 1/2 hours. 
* Make sure you have already built the base images
* Go to this folder docker/local/upgrade
* Execute the upgrade-database.sh script
* Wait till upgrade finishes (done message)
> Completed Liferay core upgrade and verify processes in 5130 seconds >
* Press ctrl-c to stop the mariadb container
* Now if you do docker-compose up in the local directory, you should automatically have the upgraded data
j
## Gogo shell
In the local Liferay environment, Gogo shell is mapped to port 11311 and exposed to the host, so you can access it just by doing
`telnet localhost 11311`
directly from your host machine (you do not need to exec into the container itself)

## JMX
To monitor the Liferay Java environment with jconsole or jvisualvm please execute this command in the root of the repository to define an environment variable for your host's IP address. 

`. sethostip.sh`

This is needed to set the correct value for the JMX RMI server. If you then run jvisualvm or jconsole you can connect using the following URL. Use it as a Remote Process.

`localhost:12345`

With jvisualvm you can monitor memory usage and look at Java settings. With jconsole you can access mbeans and do things like inspect or clear the ehcache.
