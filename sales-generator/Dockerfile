FROM openjdk:11
MAINTAINER afniko@gmail.com
ADD build/libs/sales-generator-1.0-SNAPSHOT.jar /usr/src/sales-generator-1.0-SNAPSHOT.jar
WORKDIR usr/src

ENTRYPOINT ["java","-jar", "sales-generator-1.0-SNAPSHOT.jar"]
EXPOSE 8781
