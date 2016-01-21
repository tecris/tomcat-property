# Property replacement in tomcat
Project provided as a working solution deployed with docker & docker compose

Stack
* java v8
* maven v3x
* docker v1.9
* docker-compose v1.5

## Prerequisites
* To run application (in docker) various images are required.
* `# ./prerequisites.sh`

## Integration tests
* `# mvn verify -Pcontinuous-delivery`

## Manual test
* http://127.0.0.1:8080/tomcat-ds/rest/book/test
