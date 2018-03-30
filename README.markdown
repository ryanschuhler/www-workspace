# WWW Workspace

This repo is for webteam's workspace for plugin development.

> For Liferay 6.2.x Instructions [go here](docker/devtools/liferay62/README.md)

## Modules

Modules are categoried and live in their respective folders

* apps
* extensions
* overrides
* themes

## Running Docker

* See [Docker README](docker/README.markdown) for install instructions
* Once set up simply navigate to the `docker` directory and run `gradle up` and `gradle down` to control your containers

## Deploy to Docker

* Make sure your docker instance is running (`gradle up`)
* From the directory of the module you want to deploy run the command `gradle deploy` and it will deploy the module to the `docker/liferay` directory which is automatically synced to your docker instance
