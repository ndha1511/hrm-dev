FROM jelastic/maven:3.9.5-openjdk-21

ARG UID
ARG GID

WORKDIR /app/hrm-api/

EXPOSE 8080

USER ${UID}:${GID}

CMD [ "mvn", "spring-boot:run" ]