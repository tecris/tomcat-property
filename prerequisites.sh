#!/bin/bash

git clone --branch v3.4 https://github.com/tecris/docker.git
docker build --no-cache -t casa.docker/jdk:8 docker/jdk/8
docker build --no-cache -t casa.docker/tomcat:8.0.30 docker/tomcat/8
docker build --no-cache -t casa.docker/mysql:5.7 docker/mysql/57
