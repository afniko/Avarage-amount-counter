FROM openjdk:11
MAINTAINER afniko@gmail.com
ADD build/libs/avarage-amount-counter-1.0-SNAPSHOT.jar /usr/src/avarage-amount-counter-1.0-SNAPSHOT.jar
WORKDIR usr/src

ENTRYPOINT ["java","-jar", "avarage-amount-counter-1.0-SNAPSHOT.jar"]
EXPOSE 8780
