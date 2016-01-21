# Property replacement in tomcat
Sample project to demonstrate property replacement in tomcat.

 - Database host, port, username and password are declared in context.xml as properties.


Stack
* java v8
* maven v3x
* docker v1.9
* docker-compose v1.5

## Prerequisites
* To run application (in docker) various images are required.
* `# ./prerequisites.sh`

## Integration tests
* `# mvn clean verify -Pcd -Dmaven.buildNumber.doCheck=false`
