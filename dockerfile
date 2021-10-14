FROM amazoncorretto:11-alpine-jdk
MAINTAINER chaitanya
COPY target/java-k8s-deployment.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
