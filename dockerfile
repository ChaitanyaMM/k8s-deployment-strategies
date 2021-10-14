FROM amazoncorretto:11-alpine-jdk
MAINTAINER chaitanya
COPY target/java-k8s-deployment-1.0.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
