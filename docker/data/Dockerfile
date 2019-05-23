FROM postgres:11.1
COPY ./db/btables.sql /docker-entrypoint-initdb.d/btables.sql
COPY ./db/insertions.sql /docker-entrypoint-initdb.d/insertions.sql
