# FROM maven:3.8.5-openjdk-17 AS build
# COPY . .
# RUN mvn clean package -DskipTests
#
# # Run stage
# FROM amazoncorretto:17
#
# EXPOSE 8080
#
# COPY --from=build /target/ArinPay-0.0.1-SNAPSHOT.jar ArinPay.jar
#
# ENTRYPOINT ["java", "-jar", "ArinPay.jar"]


FROM maven:3.9.6-eclipse-temurin-25 AS build

COPY . .
RUN mvn clean package -DskipTests

# --- Run Stage ---
# Uses Amazon Corretto 25 for a production-ready Java 25 runtime
FROM amazoncorretto:25

EXPOSE 8080

# Fixed the path: copied from /app/target/ where the build actually happens
COPY --from=build /target/ArinPay-0.0.1-SNAPSHOT.jar ArinPay.jar

ENTRYPOINT ["java", "-jar", "ArinPay.jar"]