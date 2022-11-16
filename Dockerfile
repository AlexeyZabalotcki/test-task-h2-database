FROM openjdk:8-alpine
WORKDIR /app
COPY target/test-task-h2-database-*.jar /test-task-h2-database.jar
ENTRYPOINT ["java","-jar","/test-task-h2-database.jar"]