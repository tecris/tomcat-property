# Property replacement in tomcat
Sample project to demonstrate property replacement in tomcat.

 - Database host, port, username and password are declared in context.xml as properties.


Stack
* java v8
* maven v3x
* docker v1.9
* docker-compose v1.5

## Prerequisites
* `# docker build --no-cache -t casadocker/tomcat-pr:8.0.30 docker`
* `# docker run --name nexus --restart=always -d -p 172.17.0.1:8081:8081 casadocker/nexus:2.12.0-01`

## Integration tests
* `# mvn clean verify -Pcd -Dmaven.buildNumber.doCheck=false`
