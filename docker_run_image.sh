#!/bin/bash

docker run \
       -it \
       -p 8899:8899 \
       --rm \
       --name nanovaadin-undertow-java \
       nanovaadin/undertow-java:latest

