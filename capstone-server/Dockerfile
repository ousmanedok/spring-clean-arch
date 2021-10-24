FROM openjdk:11-jre-slim

RUN mkdir -p /opt/app
ENV PROJECT_HOME /opt/app
ENV     PATH=$PROJECT_HOME/bin:${PATH}
COPY docker/bin/* $PROJECT_HOME/bin/
COPY docker/db/* $PROJECT_HOME/db/
COPY docker/db/* /docker-entrypoint-initdb.d/
COPY build/libs/capstone-server.jar $PROJECT_HOME/lib/capstone-server.jar
RUN java -version
VOLUME /tmp
EXPOSE 8080 8081
WORKDIR $PROJECT_HOME
CMD start_server.sh
