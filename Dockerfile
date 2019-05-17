FROM postgres:11.1-alpine
MAINTAINER Youndzo Kengne Francine <francine.youndzokengne@heig-vd.ch>
COPY script_db/auseranddb_osx.sql /docker-entrypoint-initdb.d/auseranddb_osx.sql
ENV PGDATA=/data