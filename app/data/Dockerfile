FROM postgres:11.1
COPY ./script_db/btables.sql /docker-entrypoint-initdb.d/btables.sql
COPY ./script_db/insertions.sql /docker-entrypoint-initdb.d/insertions.sql
