#!/bin/bash
DOCKER_COMPOSE_FILE=$HOME/hrm/docker-compose.yaml

if [ ! -f "$DOCKER_COMPOSE_FILE" ]; then
  echo "Docker Compose file not found at $DOCKER_COMPOSE_FILE"
  exit 1
fi
echo "Starting Docker Compose services..."

dockerComand="docker compose"

${dockerComand} down hrm-api postgres-db 

${dockerComand} -f "$DOCKER_COMPOSE_FILE" up -d postgres-db postgres-admin

${dockerComand} -f "$DOCKER_COMPOSE_FILE" up hrm-api