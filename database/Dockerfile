FROM postgres:14.2-alpine
ENV POSTGRES_PASSWORD postgres
ENV POSTGRES_USER postgres
ENV POSTGRES_DB userdb
COPY init.sql /docker-entrypoint-initdb.d/