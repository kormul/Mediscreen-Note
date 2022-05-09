FROM openjdk:11
WORKDIR /usr/app
COPY /target/note-0.0.1-SNAPSHOT.jar Mediscreen-Note.jar
CMD ["java", "-jar", "Mediscreen-Note.jar"]
EXPOSE 8081