FROM maven:3.8.4-jdk-21 AS build

WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src
RUN mvn clean package -DskipTests -Pfilter-resources

FROM openjdk:21-jre-alpine
WORKDIR /
COPY --from=build /app/target/devops-test.jar .

EXPOSE 8080

CMD ["java", "-jar", "devops-test.jar"]