FROM casa.docker/tomcat:8.0.30

ENV MAVEN_GROUP_ID org.tecris
ENV MAVEN_ARTIFACT_ID tomcat-ds

ENV MAVEN_REPOSITORY_URL 172.17.0.1

RUN wget "http://${MAVEN_REPOSITORY_URL}:8081/service/local/artifact/maven/redirect?r=snapshots&g=${MAVEN_GROUP_ID}&a=${MAVEN_ARTIFACT_ID}&v=LATEST&e=war" -O /usr/local/tomcat/webapps/tomcat-ds.war

# ADD tomcat-ds.war /usr/local/tomcat/webapps/tomcat-ds.war
# using system property for property replacement
ADD files/setenv.sh /usr/local/tomcat/bin/setenv.sh

# using properties defined in TOMCAT_HOME/conf/catalina.properties
# for property replacement
# https://tomcat.apache.org/tomcat-8.0-doc/config/
RUN echo db.username=bookstore >> /usr/local/tomcat/conf/catalina.properties
RUN echo db.password=1bookstore! >> /usr/local/tomcat/conf/catalina.properties
