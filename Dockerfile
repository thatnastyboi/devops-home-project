FROM maven:3.9.9-sapmachine-17 AS build

WORKDIR /app

COPY pom.xml .
COPY src/ src/

RUN mvn clean package -DskipTests

FROM sapmachine:17-jre-headless-ubuntu-focal

WORKDIR /app

COPY --from=build /app/target/HomeProject-0.0.1-SNAPSHOT.jar .

EXPOSE 80

ENTRYPOINT ["java","-jar","HomeProject-0.0.1-SNAPSHOT.jar"]
