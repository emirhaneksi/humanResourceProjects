FROM openjdk:11
ADD target/humanResourcesProject-0.0.1-SNAPSHOT.jar humanResourcesProject-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "humanResourcesProject-0.0.1-SNAPSHOT.jar"]