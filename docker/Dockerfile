FROM casadocker/tomcat:8.0.30

# Tomcat property replacement
# https://tomcat.apache.org/tomcat-8.0-doc/config/
RUN echo "JAVA_OPTS=\"\$JAVA_OPTS -Ddb.url=db -Ddb.name=bookstoredb -Ddb.username=bookstore -Ddb.password=1bookstore! \"" > /usr/local/tomcat/bin/setenv.sh
