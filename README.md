# xmen_mutant_ms

This is a project carried out as an application requirement for the free market company, it was designed as a microservice that is part of the X-Men system.

##
This project is deployed in an EC2 instance, to access its documentation it can be done through the following link:

http://ec2-34-204-47-229.compute-1.amazonaws.com:8080/swagger-ui.html

## Gradle Build
``` ./gradlew build && java -jar build/libs/gs-spring-boot-docker-0.1.0.jar ```
## Build the image
``` docker build -t xmen_mutant . ```
## Run image
```  docker run -it --rm --env-file ./env.list --name xmen_mutant -p 8080:8080 xmen_mutant ```
##

