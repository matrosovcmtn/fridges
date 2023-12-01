FROM openjdk:17
ADD ./target/fridges-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "application.jar"]