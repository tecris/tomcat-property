# Property replacement in tomcat
Sample project to demonstrate property replacement in tomcat.

https://tomcat.apache.org/tomcat-8.0-doc/config/

Properties

| **Property** | **Description** |
| ------------- | ------------- |
| db.host | database host / ip address |
| db.port | database port |
| db.username | database username |
| db.password | database password |


Stack
* tomcat v8
* java v8
* maven v3x
* docker v1.9
* docker-compose v1.5

## Prerequisites
* `$ docker run --name nexus --restart=always -d -p 172.17.0.1:8081:8081 casadocker/nexus:2.12.0-01`

## Integration tests
* `$ mvn clean verify -Pcd -Dmaven.buildNumber.doCheck=false`
