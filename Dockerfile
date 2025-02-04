
#DOCKER CONFIGURATION FOR JENKINS
FROM openjdk:21
EXPOSE 8080
ADD target/TedyCICDSpringApi-0.0.1.jar TedyCICDSpringApi-0.0.1.jar
ENTRYPOINT ["java","-jar","/TedyCICDSpringApi-0.0.1.jar"]




#I changed the arifactId in pom.xml to TedyCICDSpringApi since I want the jars name to be TedyCICDSpringApi
#Also, I removed snapshot from the version in pom.xm. I just want it to be 0.0.1 version







#DOCKER CONFIGURATION FOR LOCALY IN INTELLIJ
FROM openjdk:21
ARG JAR_FILE=targer/*.jar
COPY ./target/TedyCICDSpringApi-0.0.1.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

#docker commands
#command1: docker images

#-t means to tag name, name it anything you want ex:springApi which will be the repsitory name of the image
#dontforget the dot and the repository name must be all lowercase(springapi)
#command2 To create the image:   docker build -t springapi .

#command3 to list all the available images: docker images

#If it doesn't work add --force at the end to force it. docker rm -f NammeOfTheImage --force
#command4 To delete the Image: docker rmi NameOfTheImage


#Here we are running the image to create the container. -p means port. Using anyport you want instead of 8282
#since server.port is set to 8383 in application.properties. I chose 8000 to be the port.

#docker run -d -p 8000:8080 springapi      Please use this instead of below
#command5 to create the container: docker run -p 8000:8080 springapi

#Now open another Local not Terminal in intellij and use command below
#command6 to list all the available containers: docker container ls

#If you want to remove it.
#command7 to delete a container:docker rm -f container-ID

#Best is to run docker in domain mode/running on the background
#docker run -d -p 8000:8080 springapi

#Check if it is running
#command5: docker container ls