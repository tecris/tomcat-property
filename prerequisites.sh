#!/bin/bash

git clone --branch v3.4 https://github.com/tecris/docker.git docker-files
docker build --no-cache -t casa.docker/jdk:8 docker-files/jdk/8
docker build --no-cache -t casa.docker/tomcat:8.0.30 docker-files/tomcat/8
docker build --no-cache -t casa.docker/mysql:5.7 docker-files/mysql/57
docker build --no-cache -t casa.docker/nexus::2.11.4-01 docker-files/nexus

docker build --no-cache -t casa.docker/tomcat-pr:8.0.30 docker

# start maven nexus repository
docker run --name nexus --restart=always -d -p 172.17.0.1:8081:8081  casa.docker/nexus:2.11.4-01
# nexus with docker volume
# 1. mkdir /opt/docker_volumes/nexus-data 
# 2. chown -R 200 /opt/docker_volumes/nexus-data
# 3. docker run --name nexus --restart=always -d -p 172.17.0.1:8081:8081 -v /opt/docker_volumes/nexus-data:/sonatype-work casa.docker/nexus:2.11.4-01
