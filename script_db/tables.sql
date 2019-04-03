/* Nettoyage d'une db existante*/
DROP TABLE IF EXISTS Departement;
DROP TABLE IF EXISTS Tag;
DROP TABLE IF EXISTS Departement;
DROP TABLE IF EXISTS Utilisateur CASCADE;
DROP TABLE IF EXISTS Message CASCADE;
DROP TABLE IF EXISTS Roles;

/* Créations */
CREATE TABLE IF NOT EXISTS Departement (
	departementID	SERIAL PRIMARY KEY,
	nomDepartement	VARCHAR NOT NULL 
);

CREATE TABLE IF NOT EXISTS Roles(
	roleID		SERIAL PRIMARY KEY,
	nomRole		VARCHAR NOT NULL 
);

CREATE TABLE IF NOT EXISTS Utilisateur (
	utilisateurID	SERIAL PRIMARY KEY,
	nomUtilisateur	VARCHAR NOT NULL,
	mailUtilisateur	VARCHAR NOT NULL,
	motDePasse  	VARCHAR NOT NULL,
	roleUtilisateur	INTEGER NOT NULL,
    FOREIGN KEY (roleUtilisateur) REFERENCES Roles(roleID) 
);

CREATE TABLE IF NOT EXISTS Discussion (
	discussionID	SERIAL PRIMARY KEY,
	sujet			VARCHAR, 
	msgRacineID		INTEGER,
	utilisateurID	INTEGER, /* NOT NULL enlevé pour les tests, à remettre après */
    FOREIGN KEY (utilisateurID) REFERENCES Utilisateur(utilisateurID)
);

CREATE TABLE IF NOT EXISTS Message (
	messageID		SERIAL PRIMARY KEY,
	message			VARCHAR, 
	score			INTEGER,
	utilisateurID	INTEGER NOT NULL,
	discussionID	INTEGER NOT NULL,
	superMessageID  INTEGER, 
    FOREIGN KEY (utilisateurID) REFERENCES Utilisateur(utilisateurID),
	FOREIGN KEY (discussionID) REFERENCES discussion(discussionID) 
);

CREATE TABLE IF NOT EXISTS Tag (
	nom				VARCHAR,
	prioritaire		BOOLEAN, 
	rang			INTEGER 
);
	
ALTER TABLE Discussion 
	ADD CONSTRAINT constraint_name FOREIGN KEY (msgRacineID) REFERENCES Message(messageID);
	
	


 




