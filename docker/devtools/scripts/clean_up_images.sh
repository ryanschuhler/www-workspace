docker images -a | grep none | awk '{ print $3} ' | xargs docker rmi 



#docker rm $(docker ps -a -q)
#* docker rmi $(docker images -a -q)
#   * docker images -q --filter "dangling=true" | xargs docker rmi
#* docker volume rm $(docker volume ls -q)
#   * docker volume rm $(docker volume ls -qf dangling=true)
#* rm -rf ~/Library/Containers/com.docker.docker/Data/*