# Start with a base image containing Java runtime
FROM openjdk:17-jdk-slim

# Information around who maintains the image (updated with LABEL)
LABEL maintainer="Sait"

# Add application's jar to the image
COPY target/accounts-0.0.1-SNAPSHOT.jar accounts-0.0.1-SNAPSHOT.jar

# Execute the application
ENTRYPOINT ["java", "-jar", "accounts-0.0.1-SNAPSHOT.jar"]


# docker build . -t sadoyol/accounts:20250627
# docker run -d -p 8080:8080 sadoyol/accounts:20250627
# ? first port is the exposed port and the second is the container port