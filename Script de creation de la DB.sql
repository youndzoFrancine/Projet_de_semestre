--Database: Forum

DROP DATABASE "Forum";

CREATE USER segfaultapi | CREATEDB;

CREATE DATABASE "Forum"
    WITH 
    OWNER = segfaultapi 
    ENCODING = 'UTF8'
    LC_COLLATE = 'French_Switzerland.1252'
    LC_CTYPE = 'French_Switzerland.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;
	
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

 




