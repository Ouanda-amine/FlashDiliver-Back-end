FROM openjdk:21
ADD target/*.jar Flash.jar
EXPOSE 9000
ENTRYPOINT ["java", "-jar", "Flash.jar"]