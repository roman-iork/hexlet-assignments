FROM openjdk:21-jdk-slim
WORKDIR project
COPY app .
COPY Makefile .
COPY gradle gradle

ARG GRADLE_VERSION=8.6

RUN apt-get update && apt-get install -yq make unzip wget

RUN wget -q https://services.gradle.org/distributions/gradle-${GRADLE_VERSION}-bin.zip \
    && unzip gradle-${GRADLE_VERSION}-bin.zip \
    && rm gradle-${GRADLE_VERSION}-bin.zip

ENV GRADLE_HOME=/opt/gradle

RUN mv gradle-${GRADLE_VERSION} ${GRADLE_HOME}

ENV PATH=$PATH:$GRADLE_HOME/bin

RUN gradle build -x test
#CMD ["java",  "-jar",  "build/libs/simple-application.jar"]
CMD java -jar build/libs/simple-application.jar
EXPOSE 8080