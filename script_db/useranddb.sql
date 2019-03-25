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
    ENCODING = 'UTF-8'
    LC_COLLATE = 'fr_CH'
    LC_CTYPE = 'fr_CH'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    TEMPLATE template0;
	
	CREATE TABLE Departement(
	departementID	SERIAL PRIMARY KEY,
	nomDepartement	VARCHAR NOT NULL 
);

CREATE TABLE Roles(
	roleID		SERIAL PRIMARY KEY,
	nomRole		VARCHAR NOT NULL 
);

CREATE TABLE Utilisateur (
	utilisateurID	SERIAL PRIMARY KEY,
	nomUtilisateur	VARCHAR NOT NULL,
	mailUtilisateur	VARCHAR NOT NULL,
	motDePasse  	VARCHAR NOT NULL,
	roleUtilisateur	INTEGER NOT NULL,
    FOREIGN KEY (roleUtilisateur) REFERENCES Roles(roleID) 
);

CREATE TABLE Discussion (
	discussionID	SERIAL PRIMARY KEY,
	msgRacineID		INTEGER, 
	utilisateurID	INTEGER NOT NULL,
    FOREIGN KEY (utilisateurID) REFERENCES Utilisateur(utilisateurID)
);

CREATE TABLE Message (
	messageID		SERIAL PRIMARY KEY,
	message			VARCHAR, 
	score			INTEGER,
	utilisateurID	INTEGER NOT NULL,
	discussionID	INTEGER NOT NULL,
	superMessageID  INTEGER, 
    FOREIGN KEY (utilisateurID) REFERENCES Utilisateur(utilisateurID),
	FOREIGN KEY (discussionID) REFERENCES discussion(discussionID) 
);

CREATE TABLE Tag (
	valeur			VARCHAR,
	prioritaire		BOOLEAN, 
	rang			INTEGER 
);
	
ALTER TABLE Discussion 
	ADD CONSTRAINT constraint_name FOREIGN KEY (msgRacineID) REFERENCES Message(messageID);
