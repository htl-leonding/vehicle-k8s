#!/usr/bin/env bash

mvn -B package
cp src/main/docker/Dockerfile target/
docker login ghcr.io -u $GITHUB_ACTOR -p $GITHUB_TOKEN
docker build --platform linux/arm64 --tag ghcr.io/$GITHUB_REPOSITORY/backend-arm:latest ./target
docker push ghcr.io/$GITHUB_REPOSITORY/backend-arm:latest
