FROM openjdk:21-ea-20-jdk
VOLUME /tmp 
#to store jar files
COPY /target/Project-Cal-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]