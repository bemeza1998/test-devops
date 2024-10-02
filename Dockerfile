FROM maven:3.9.9-eclipse-temurin-21 AS build

WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src
RUN mvn clean package -DskipTests -Pfilter-resources

FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/target/*.jar devops-test.jar

EXPOSE 8080

CMD ["java", "-jar", "devops-test.jar"]