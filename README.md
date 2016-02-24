# Property replacement in tomcat

[![Circle CI](https://circleci.com/gh/tecris/tomcat-property.svg?style=svg)](https://circleci.com/gh/tecris/tomcat-property)

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

#### One liner
* `$ mvn clean verify -Pcd -Dmaven.buildNumber.doCheck=false`
