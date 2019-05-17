--User: segfaultapi

DROP DATABASE IF EXISTS "Forum";
DROP USER IF EXISTS segfaultapi;

CREATE USER segfaultapi WITH ENCRYPTED PASSWORD 'yourpass' 
  LOGIN
  NOSUPERUSER
  INHERIT
  CREATEDB
  NOCREATEROLE
  NOREPLICATION;

--Database: Forum
CREATE DATABASE "Forum"
    WITH
    OWNER = segfaultapi
    #ENCODING = 'LATIN1'
    #LC_COLLATE = 'fr_CH'
    #LC_CTYPE = 'fr_CH'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    TEMPLATE template0;
