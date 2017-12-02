# WWW Workspace
This repo is for webteam's workspace for plugin development.

# Deploy to Docker
* Start up your docker instance
* Make sure to configure `docker.container.name`, `docker.deploy.destination.path`, and `docker.deploy.src.path` in the settings.gradle of your module
* Run the command `gradle dockerDeploy` and it will deploy the module to your docker instance