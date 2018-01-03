# WWW Workspace
This repo is for webteam's workspace for plugin development.

# Modules
Modules are categoried and live in their respective folders
* apps
* extensions
* overrides
* themes

# Running Docker
* See [Docker README](docker/README.markdown) for install instructions
* Once set up simply run `gradle dockerUp` and `gradle dockerDown` control your containers

# Deploy to Docker
* Start up your docker instance
* Make sure to configure `docker.container.name`, `docker.deploy.destination.path`, and `docker.deploy.src.path` in the settings.gradle of your module
* Run the command `gradle dockerDeploy` and it will deploy the module to your docker instance