FROM openjdk:11

MAINTAINER ru-fridayrelease

ADD app.jar /app/
WORKDIR /app

CMD ["java", "-jar", "/app/app.jar"]

EXPOSE 8080
