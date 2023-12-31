#!/usr/bin/env bash

docker kill $(docker ps -a -q)

docker rm $(docker ps -a -f status=exited -q)

docker rmi $(docker images -a -q)

docker volume prune