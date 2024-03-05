#!/usr/bin/env bash

# mvn -B package
# cp src/main/docker/Dockerfile target/
# docker login ghcr.io -u $GITHUB_ACTOR -p $GITHUB_TOKEN
# docker build --tag ghcr.io/$GITHUB_REPOSITORY/backend:latest ./target
# docker push ghcr.io/$GITHUB_REPOSITORY/backend:latest



mvn -B package
cp src/main/docker/Dockerfile target/
docker login ghcr.io -u $GITHUB_ACTOR -p $GITHUB_TOKEN
docker buildx create  --name multi-arch-builder --platform linux/amd64,linux/arm64
docker buildx use multi-arch-builder
docker buildx build \
  --platform linux/amd64,linux/arm64 \
  --tag ghcr.io/$GITHUB_REPOSITORY/backend:latest \
  --push \
  ./target
