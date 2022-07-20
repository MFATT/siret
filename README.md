Sirene client  Application

This java Application aims to extract company information form the sirene API V3 using the siret number provided in the application properties

Prerequisite
Java 8+
Maven 3.x
Docker
Postman in order to test the api : 

Getting Started
To install this application, run the following commands:

git clone https://github.com/MFATT/siret.git

Build and Run: 

Maven Build:

mvn clean install

It will create the Spring Boot executable JAR,siret-0.0.1-SNAPSHOT.jar.jar, under target folder.

Run : 
To run the newly created Spring Boot JAR from the terminal:

java -jar siret-0.0.1-SNAPSHOT.jar

This should start up the siret application at port 8080. 

To test the endpoint run following command : 

curl http://localhost:8080/siret

Docker Build: 

To build docker image, Execute the following command 

docker build -t siret:latest .

Docker Run: 

Run the newly created Docker image, siret:latest, by executing the docker run command :

docker run -p 8080:8080 siret:latest

