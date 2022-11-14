# docker build -t eater -f ./src/main/java/eater/Dockerfile .
FROM openjdk:17-jdk-slim

ADD ./build/classes /eater/classes
COPY --chmod=777 ./src/main/java/eater/eater.sh /eater/eater.sh