FROM jelastic/maven:3.9.5-openjdk-21

ARG UID
ARG GID

RUN groupadd -g ${GID} appgroup && \
    useradd -m -u ${UID} -g appgroup pengu

ENV HOME=/home/pengu

RUN mkdir -p /home/pengu/.m2 && chown -R pengu:appgroup /home/pengu


WORKDIR /app/hrm-api/

EXPOSE 8080

USER pengu

CMD [ "mvn", "spring-boot:run" ]