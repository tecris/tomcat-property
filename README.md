# Property replacement in tomcat
Sample project to demonstrate property replacement in tomcat.

https://tomcat.apache.org/tomcat-8.0-doc/config/
<hr/>

#### Stack
| **Technology** | **Version** |
| ------------- | ------------- |
| Tomcat | 8 |
| Java | 8 |
| Maven | 3.3 |
| Docker | 1.9 |
| Docker Compose | 1.5.2 |

#### Properties
 - Defined in [context.xml](src/main/webapp/META-INF/context.xml)
 - Supplied in [setenv.sh](src/main/docker/files/setenv.sh) (during environment build process file gets copied to TOMCAT_HOME/bin directory)

| **Property** | **Description** |
| ------------- | ------------- |
| db.host | database host / ip address |
| db.port | database port |
| db.username | database username |
| db.password | database password |

#### Prerequisites
* `$ docker run --name nexus --restart=always -d -p 172.17.0.1:8081:8081 casadocker/nexus:2.12.0-01`

#### Integration tests
* `$ mvn clean verify -Pcd -Dmaven.buildNumber.doCheck=false`
