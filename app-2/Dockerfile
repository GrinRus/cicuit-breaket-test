FROM gradle:latest AS build
COPY --chown=gradle:gradle . /home/gradle
RUN gradle bootJar --no-daemon

FROM openjdk:latest
COPY --from=build /home/gradle/build/libs/*.jar /app/spring-boot-application.jar
EXPOSE 8888
ENTRYPOINT ["java", "-jar", "/app/spring-boot-application.jar"]