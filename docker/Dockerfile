FROM openjdk:8-jdk-stretch AS build

ADD .. /workspace
WORKDIR /workspace
RUN sh gradlew bootJar

FROM openjdk:8-jre-stretch

# DNS Cache TTL
RUN echo "networkaddress.cache.ttl=10" >> $JAVA_HOME/lib/security/java.security

WORKDIR /app
COPY --from=build /workspace/build/libs/*.jar ./server.jar
COPY docker/run.sh ./

USER 1000
CMD ["sh", "run.sh"]