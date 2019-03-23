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
    ENCODING = 'UTF8'
    LC_COLLATE = 'fr_CH' #Avec ça, ça passe sur Mac OS X. Donc Unix ?
    CONNECTION LIMIT = -1
    TEMPLATE template0;
	
	


 




