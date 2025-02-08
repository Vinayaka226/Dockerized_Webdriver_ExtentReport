FROM bellsoft/liberica-openjre-alpine:latest-cds

# Install curl and jq
RUN apk add curl jq

# Workspace
WORKDIR /home/Dockerized_Webdriver_ExtentReport

# Add needed files
ADD target/docker-resources .
ADD runner.sh runner.sh

ENTRYPOINT sh runner.sh