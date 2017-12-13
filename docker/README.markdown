# Docker Environment
This is an environment setup for www.liferay.com using both docker and Liferay workspaces. For help, questions, improvements or anything else feel free to contact [Ryan Schuhler](ryan.schuhler@liferay.com)

## Getting Started
* Intall Docker (https://docs.docker.com/engine/installation/)
	* Increase memory in docker (in app preferences)
* Navigate to `/www-workspace/docker/local` folder
* Run `gradle build`
  * This should take around 10 minutes the first time you run it. After that it caches many of the files so subsequent builds should be faster depending on what you have changed.
* Run `gradle up`
* Go to http://localhost in your browser

### Notes
* You need to be on the office network or vpnd into the office in order to download some of the files form mirrors.liferay
* If you are seeing issues with apache and conflicting ports on mac you may be running apache already and can stop it by running `sudo apachectl stop`
* If you are seeing errors with scripts on Windows it might be an issue with line endings and bash. You can use dos2unix to correct or set the config for line endings in git (ie `dos2unix liferay/entrypoint.sh` or `git config --global autocrlf input`)

## Useful commands
* Run `gradle tasks --all` in your `/www-workspace/docker/local` folder
* You can run `docker ps -a` to see the containers and their statuses
* For logs run `docker logs -f [CONTAINER_ID|CONTAINER_NAME]` ie `docker logs -f liferay`
* To navigate the terminal of a container run  `docker exec -it [CONTAINER_ID|CONTAINER_NAME] /bin/sh` ie `docker exec -it mariadb /bin/sh`
* As you make changes to modules you can either run `gradle dockerDeploy` from your module to hot deploy it. Or you can bring down your containers with `gradle down`, rebuild with `gradle build`, and bring them back up with `gradle up`
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
