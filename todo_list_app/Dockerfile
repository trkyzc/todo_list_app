FROM openjdk:17
WORKDIR /app
ADD target/todo_list_app-0.0.1-SNAPSHOT.jar todo_list_app-0.0.1-SNAPSHOT.jar 
ENTRYPOINT ["java", "-jar","-Dspring.profiles.active=docker", "todo_list_app-0.0.1-SNAPSHOT.jar"]