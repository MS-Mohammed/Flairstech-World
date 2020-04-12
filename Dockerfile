FROM openjdk:8

EXPOSE 8080

ADD target/docker-flaistech.jar docker-flairstech.jar

ENTRYPOINT ["java", "-jar", "docker-flairstech.jar"]

# Init Example Database World on PostgreSQL 12
FROM postgres:12

ENV POSTGRES_USER world
ENV POSTGRES_PASSWORD world123
ENV POSTGRES_DB world-db

# Copier les scripts SQL dans : 
ADD scripts/*.sql /docker-entrypoint-initdb.d/

# Copier les scripts d'init dans : 
#ADD scripts/*.sh /docker-entrypoint-initdb.d/

COPY docker-healthcheck /usr/local/bin/
RUN chmod +x /usr/local/bin/docker-healthcheck

HEALTHCHECK CMD ["docker-healthcheck"]
