FROM openjdk:25
EXPOSE 8080
VOLUME /tmp
RUN mkdir /app

COPY build/libs/*.jar /app/self-learn.jar
CMD ["java", "-jar", "/app/self-learn.jar"]