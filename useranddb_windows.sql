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
    #ENCODING = 'UTF-8'
    #LC_COLLATE = 'French_Switzerland.1252'
    #LC_CTYPE = 'French_Switzerland.1252'
    CONNECTION LIMIT = -1
    TEMPLATE template0;

	

