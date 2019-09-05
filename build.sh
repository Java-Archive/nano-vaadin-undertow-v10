#!/bin/bash
docker build -t nanovaadin/undertow-java .
#docker tag nanovaadin/undertow-java:latest nanovaadin/undertow-java:20190826-001
#docker push nanovaadin/undertow-java:20190826-001
docker push nanovaadin/undertow-java:latest
