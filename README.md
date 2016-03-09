# Property replacement in tomcat

[![Circle CI](https://circleci.com/gh/tecris/tomcat-property.svg?style=svg)](https://circleci.com/gh/tecris/tomcat-property)
[![Build Status](https://travis-ci.org/tecris/tomcat-property.svg?branch=master)](https://travis-ci.org/tecris/tomcat-property)

Sample project to demonstrate property replacement in tomcat.

https://tomcat.apache.org/tomcat-8.0-doc/config/
<hr/>

#### Stack
| **Technology** | **Version** |
| ------------- | ------------- |
| Tomcat | 8 |
| Java | 8 |
| Maven | 3.3 |
| Docker | 1.10 |

#### Properties
 - Defined in [context.xml](src/main/webapp/META-INF/context.xml)
 - Supplied in [setenv.sh](src/main/docker/files/setenv.sh) (during environment build process file gets copied to TOMCAT_HOME/bin directory)

| **Property** | **Description** |
| ------------- | ------------- |
| db.host | database host / ip address |
| db.port | database port |
| db.username | database username |
| db.password | database password |

#### How to run E2E tests
* ```
   docker-compose up -d
   mvn clean compile flyway:migrate
   mvn clean package
   curl --user admin:1admin! --upload-file target/tomcat-pr.war "http://localhost:8080/manager/text/deploy?path=/tomcat-pr&update=true"
   mvn clean verify
  ```
