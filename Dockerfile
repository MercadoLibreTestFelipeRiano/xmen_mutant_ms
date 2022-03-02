FROM openjdk:17
COPY . /build/libs/
WORKDIR /build/libs/
EXPOSE 8080
CMD ["java","-jar","build/libs/xmen_mutant_ms-0.0.1-SNAPSHOT.jar"]