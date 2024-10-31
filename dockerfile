FROM openjdk:17-jdk-alpine
MAINTAINER 'heavyflood' 'hs.park@strato.co.kr'
VOLUME /tmp
ARG SERVER_ENV=dev
ENV SERVER_ENV ${SERVER_ENV}
ENV JAVA_OPTS="-XX:PermSize=1024m -XX:MaxPermSize=512m -Xmx4g -Xms2g"
COPY ./junit-test.jar junit-test.jar
ENTRYPOINT ["java", "-Dspring.profiles.active=${SERVER_ENV}", "-jar","/junit-test.jar"]