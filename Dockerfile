FROM openjdk:21-jdk
ARG JAR_FILE=targer/*.jar
COPY ./target/SpringApi-0.0.1.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

#docker commands
#command1: docker images

#-t means to tag name, name it anything you want ex:springApi which will be the repsitory name of the image
#dontforget the dot
#command2:   docker build -t springApi .

#Here we are running the image to create the container. -p means port. Using anyport you want instead of 8282
#since server.port is set to 8282 in application.properties. I chose 8000 to be the port.

#command3: docker run -p 8000:8282 springApi