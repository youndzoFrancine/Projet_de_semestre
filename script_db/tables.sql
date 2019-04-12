/* Nettoyage d'une db existante*/
DROP TABLE IF EXISTS Departement;
DROP TABLE IF EXISTS Tag;
DROP TABLE IF EXISTS Departement;
DROP TABLE IF EXISTS Utilisateur CASCADE;
DROP TABLE IF EXISTS Message CASCADE;
DROP TABLE IF EXISTS Discussion CASCADE;
DROP TABLE IF EXISTS Roles;
DROP TABLE IF EXISTS Appartient;
DROP TABLE IF EXISTS Est_lier;
DROP TABLE IF EXISTS Vote;

/* Créations */
CREATE TABLE IF NOT EXISTS Departement (
	departement_id	SERIAL PRIMARY KEY,
	nom_departement	VARCHAR NOT NULL 
);

CREATE TABLE IF NOT EXISTS Roles(
	role_id		SERIAL PRIMARY KEY,
	nom_role		VARCHAR NOT NULL 
);

CREATE TABLE IF NOT EXISTS Utilisateur (
	utilisateur_id	SERIAL PRIMARY KEY,
	nom_utilisateur	VARCHAR NOT NULL,
	mail_utilisateur	VARCHAR NOT NULL,
	mot_de_passe  	VARCHAR NOT NULL,
	role_utilisateur	INTEGER NOT NULL,
    FOREIGN KEY (role_utilisateur) REFERENCES Roles(role_id) 
);

CREATE TABLE IF NOT EXISTS Discussion (
	discussion_id	SERIAL PRIMARY KEY,
	sujet			VARCHAR, 
	msgracine_id	INTEGER,
	utilisateur_id	INTEGER, /* NOT NULL enlevé pour les tests, à remettre après */
    FOREIGN KEY (utilisateur_id) REFERENCES Utilisateur(utilisateur_id)
);

CREATE TABLE IF NOT EXISTS Message (
	message_id		SERIAL PRIMARY KEY,
	contenu			VARCHAR, 
	score			INTEGER,
	utilisateur_id	INTEGER, /* NOT NULL enlevé pour les tests, à remettre après */
	discussion_id	INTEGER, /* NOT NULL enlevé pour les tests, à remettre après */
	super_message_id  INTEGER, 
    FOREIGN KEY (utilisateur_id) REFERENCES Utilisateur(utilisateur_id),
	FOREIGN KEY (discussion_id) REFERENCES Discussion(discussion_id) 
);

CREATE TABLE IF NOT EXISTS Tag (
	tag_id			SERIAL PRIMARY KEY, /* Peut-être pas utile, test */
	nom				VARCHAR,
	prioritaire		BOOLEAN, 
	rang			INTEGER 
);

CREATE TABLE IF NOT EXISTS Vote (
  message_id 	 INTEGER ,  
  utilisateur_id INTEGER , 
  PRIMARY KEY (message_id, utilisateur_id),
  FOREIGN KEY (message_id)     REFERENCES Message(message_id),
  FOREIGN KEY (utilisateur_id) REFERENCES Utilisateur(utilisateur_id)
);

CREATE TABLE IF NOT EXISTS Appartient (
  departement_id INTEGER ,  
  utilisateur_id INTEGER , 
  PRIMARY KEY (departement_id, utilisateur_id),
  FOREIGN KEY (departement_id)     REFERENCES Departement(departement_id),
  FOREIGN KEY (utilisateur_id) REFERENCES Utilisateur(utilisateur_id)
);

CREATE TABLE IF NOT EXISTS Est_lier (
  discussion_id INTEGER ,  
  tag_id INTEGER , 
  PRIMARY KEY (discussion_id, tag_id),
  FOREIGN KEY (discussion_id) REFERENCES Discussion(discussion_id),
  FOREIGN KEY (tag_id)       REFERENCES Tag(tag_id)
);
	
ALTER TABLE Discussion 
	ADD CONSTRAINT constraint_name FOREIGN KEY (msgracine_id) REFERENCES Message(message_id);
	
	


 




