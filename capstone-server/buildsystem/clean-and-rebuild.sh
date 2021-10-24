#!/usr/bin/env bash

docker kill $(docker ps -a -q)

docker rm $(docker ps -a -f status=exited -q)

#docker rmi $(docker images -a -q)

docker volume prune
docker-compose build --no-cache &&
    docker-compose up --force-recreate
docker-compose up --build --no-cache
