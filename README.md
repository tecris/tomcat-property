# Property replacement in tomcat

[![Circle CI](https://circleci.com/gh/tecris/tomcat-property.svg?style=svg)](https://circleci.com/gh/tecris/tomcat-property)
[![Build Status](https://travis-ci.org/tecris/tomcat-property.svg?branch=master)](https://travis-ci.org/tecris/tomcat-property)

Sample project to demonstrate variable substitution (aka property replacement) in tomcat.


<hr/>

#### Stack
| **Technology** | **Version** |
| ------------- | ------------- |
| Tomcat | 8.5 |
| Java | 8 |
| Maven | 3.5 |
| Docker | 1.10 |

#### Properties
 - Defined in [context.xml](src/main/webapp/META-INF/context.xml)
 - Supplied in [setenv.sh](docker/setenv.sh) (during environment build process file gets copied to TOMCAT_HOME/bin directory)

| **Property** | **Description** |
| ------------- | ------------- |
| db.host | database host / ip address |
| db.port | database port |
| db.username | database username |
| db.password | database password |

#### How to run E2E tests

  ```
    $ mvn clean package
    $ docker-compose up -d
    $ mvn clean compile flyway:migrate
    $ mvn clean verify
  ```
