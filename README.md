# Eater

A tiny utility to 'eat' system resources - generate cpu load or consume memory. Might be useful to
run some stress tests or for whatever you can think of.

## Build

Buildable through Gradle/IDE defaults.

## Docker Image

1. build project - make sure ./build/classes dir created with Eater classes inside
2. > docker build -t eater -f ./src/main/java/eater/Dockerfile .
3. > docker tag eater YOUR_DOCKERHUB_NAME/eater
4. > docker push YOUR_DOCKERHUB_NAME/eater

## Run
>docker run --interactive --tty --detach --name eater eater

>docker exec -it <container id> /bin/sh

>./eater/eater.sh


### or from build folder:
java -cp ./classes/java/main eater/Main
