--User: segdefaultapi

DROP DATABASE IF EXISTS "Forum";
DROP USER IF EXISTS segdefaultapi;

CREATE USER segdefaultapi WITH ENCRYPTED PASSWORD 'yourpass' 
  LOGIN
  NOSUPERUSER
  INHERIT
  CREATEDB
  NOCREATEROLE
  NOREPLICATION;

--Database: Forum
CREATE DATABASE "Forum"
    WITH 
    OWNER = segdefaultapi
    ENCODING = 'UTF8'
    LC_COLLATE = 'French_Switzerland.1252'
    LC_CTYPE = 'French_Switzerland.1252'
    CONNECTION LIMIT = -1;
	
	


 




