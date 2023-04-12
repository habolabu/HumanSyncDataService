FROM gradle:jdk17-alpine
WORKDIR /human-sync-service

COPY src /human-sync-service/src/
COPY build.gradle .
COPY lombok.config .

RUN gradle clean build -x test

ENTRYPOINT ["java", "-jar", "./build/libs/human-sync-service-1.0.0.jar"]