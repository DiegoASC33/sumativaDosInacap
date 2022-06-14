FROM openjdk:17-jdk-slim-buster
LABEL maintainer = "nttdata.cl"
ADD target/sumativaDosInacap-1.0.jar springboot-docker-demosumativa.jar
ENTRYPOINT ["java","-jar","springboot-docker-demosumativa.jar"]