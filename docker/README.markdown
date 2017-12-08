# Docker Webteam
This repo is for webteam's server infrastructure on docker.

# Steps
* Intall Docker (https://docs.docker.com/engine/installation/)
	* Increase memory in docker (in app preferences)
* Navigate to /www-docker folder
* Run `docker-compose up -d`
* Go to http://localhost in your browser
* Notes
	* You need to be on the office network or vpnd into the office in order to download some of the files form mirrors.liferay
	* If you want to build only liferay you can navigate to the liferay folder and run `docker build -t liferay . && docker run -d -p 8080:8080 --name liferay liferay`
	* If you are seeing issues with apache and conflicting ports on mac you can run `sudo apachectl stop`
	* If you are seeing errors with scripts on Windows it might be an issue with line endings and bash. You can use dos2unix to correct or set the config for line endings in git (ie `dos2unix liferay/entrypoint.sh` or `git config --global autocrlf input`)
	* You can run `docker ps -a` to see the containers and their statuses
	* For logs run `docker logs -f [CONTAINER_ID|CONTAINER_NAME]` ie `docker logs -f liferay`
	* To navigate the terminal of a container run  `docker exec -it [CONTAINER_ID|CONTAINER_NAME] /bin/sh` ie `docker exec -it mariadb /bin/sh`
	* To shut down all of your containers run `docker-compose down`
	* To rebuild your containers as you bring them up run `docker-compose up -d --build`
	* To copy files from your computer to a docker container run `docker cp [containerName]:[containerPath] [localPath]` ie `docker cp liferay:/usr/local/liferay-dxp-digital-enterprise-7.0-sp6/deploy ~/Desktop/dxp/deploy/`

# What is installed
If you look at the docker-compose.yaml you can see all of the containers and settings that are being installed. These include
* Web Server
	* Using apache
	* This handles the intial request when you hit http://localhost and directs you to the liferay instance
* Database Server
	* Using mariadb
	* This is a separate server for the database to provide easier scalability
	* If you set the `DB_URL` variable in docker-compose.yaml it will download and source your database for you (not working yet)
* Search Server
	* Using elasticsearch
	* This is a dedicated server to store search indexes
	* You can see the indexes at http://localhost:9200/_cat/indices
* Email Server
	* Using mockmock
	* This is just for testing so that you can send emails from liferay and see them at http://localhost:8282
* Liferay Instance
	* This is your running instance of liferay
	* Notice you can add files to the `/www-docker/liferay/configs` or `/www-docker/liferay/deploy` folders and when you start up your server it will deploy these files for you using the entrypoint.sh script
	* If you want to download your own bundle instead of using the url to download, you can do so by adding a `bundle.zip` to the `/www-docker/liferay` folder
	* If you set the `WORKSPACE_URL` and `WORKSPACE_DIR` in docker-compose.yaml it will download and deploy your modules from a github repo
