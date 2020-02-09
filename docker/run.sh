#!/bin/sh

exec java \
    -Djava.awt.headless=true \
    -Djava.security.egd=file:/dev/./urandom \
    $JAVA_OPTS \
    -jar /app/server.jar $ARGS
