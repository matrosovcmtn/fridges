FROM openjdk:17
ADD ./target/fridges-0.0.1-SNAPSHOT.jar application.jar
ENTRYPOINT ["java", "-jar", "application.jar"]