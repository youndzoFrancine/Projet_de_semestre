/* Nettoyage d'une db existante*/
\connect Forum

DROP TABLE IF EXISTS Departement	CASCADE;
DROP TABLE IF EXISTS Tag 			CASCADE;
DROP TABLE IF EXISTS Utilisateur 	CASCADE;
DROP TABLE IF EXISTS Message 		CASCADE;
DROP TABLE IF EXISTS discussion		CASCADE;
DROP TABLE IF EXISTS Roles;
DROP TABLE IF EXISTS appartient;
DROP TABLE IF EXISTS est_lier;
DROP TABLE IF EXISTS vote;
DROP TABLE IF EXISTS message_family CASCADE;

/* Créations */
CREATE TABLE IF NOT EXISTS Departement (
	departement_id		 	SERIAL PRIMARY KEY,
	nom_departement			VARCHAR NOT NULL UNIQUE
);
ALTER SEQUENCE departement_departement_id_seq RESTART WITH 1;

/* serial est equivalent a 
	id integer NOT NULL DEFAULT nextval('table_name_id_seq')
);
ALTER SEQUENCE table_name_id_seq
OWNED BY table_name.id;*/


CREATE TABLE IF NOT EXISTS Roles(
	role_id					SERIAL PRIMARY KEY,
	nom_role				VARCHAR NOT NULL 
);
ALTER SEQUENCE ROLES_role_id_seq RESTART WITH 1;

CREATE TABLE IF NOT EXISTS Utilisateur (
	utilisateur_id	SERIAL 	PRIMARY 	KEY		,
	nom_utilisateur			VARCHAR 	NOT NULL UNIQUE,
	mail_utilisateur		VARCHAR 	NOT NULL UNIQUE,
	/* md5 => 32 byte*/
	mot_de_passe  			VARCHAR(32) NOT NULL,
	role_utilisateur		INTEGER 	NOT NULL,
	
	CONSTRAINT fk_role_utilisateur
		FOREIGN KEY (role_utilisateur) REFERENCES Roles(role_id) 
		ON DELETE CASCADE /*quand on suprime un departement on supprime tout ces etudiant,prof,...*/
);

ALTER SEQUENCE utilisateur_utilisateur_id_seq RESTART WITH 1;

/*
DELETE FROM Utilisateur WHERE nom_utilisateur = 'Student';
*/


CREATE TABLE IF NOT EXISTS Discussion (
	discussion_id			SERIAL PRIMARY KEY,
	sujet					VARCHAR, 
	msgracine_id			INTEGER,
	utilisateur_id			INTEGER, /* NOT NULL enlevé pour les tests, à remettre après */
		
	CONSTRAINT fk_disc_utilisateur_id
    FOREIGN KEY (utilisateur_id) REFERENCES Utilisateur(utilisateur_id)
	 ON DELETE SET NULL
);

ALTER SEQUENCE discussion_discussion_id_seq RESTART WITH 1;


CREATE TABLE IF NOT EXISTS Message (
	message_id				SERIAL PRIMARY KEY,
	date_creation			TIMESTAMP,
	contenu					VARCHAR, 
	score					INTEGER DEFAULT 100,
	utilisateur_id			INTEGER, /* peu être null (supression d'un user mais pas de ces messages*/
	discussion_id			INTEGER, /* NOT  enlevé pour les tests, à remettre après */
	super_message_id  		INTEGER, 
	
	CONSTRAINT fk_message
    FOREIGN KEY (utilisateur_id) REFERENCES Utilisateur(utilisateur_id) ON DELETE SET NULL	,
	FOREIGN KEY (discussion_id)	 REFERENCES Discussion(discussion_id) 	ON DELETE RESTRICT 	
);
ALTER SEQUENCE message_message_id_seq RESTART WITH 1;


CREATE TABLE IF NOT EXISTS Tag ( 
	tag_id					SERIAL PRIMARY KEY, 
	nom						VARCHAR,
	prioritaire				BOOLEAN, 
	rang					INTEGER DEFAULT 100
);
ALTER SEQUENCE tag_tag_id_seq RESTART WITH 1;


CREATE TABLE IF NOT EXISTS Vote (
  message_id INT NOT NULL,
  utilisateur_id INT NOT NULL,
  up_vote BOOLEAN, /*true si vote positif*/
  PRIMARY KEY (message_id,utilisateur_id),
  
  CONSTRAINT fk_votation
	  FOREIGN KEY (message_id) 		REFERENCES Message(message_id) 			ON DELETE CASCADE,
	  FOREIGN KEY (utilisateur_id)	REFERENCES Utilisateur(utilisateur_id) 	ON DELETE CASCADE
);


CREATE TABLE IF NOT EXISTS Appartient (
  departement_id INTEGER ,  
  utilisateur_id INTEGER , 
  PRIMARY KEY (departement_id, utilisateur_id),
  
  CONSTRAINT fk_appartenance
	FOREIGN KEY (departement_id) REFERENCES Departement(departement_id) ON DELETE CASCADE ,
	FOREIGN KEY (utilisateur_id) REFERENCES Utilisateur(utilisateur_id) ON DELETE CASCADE
);


CREATE TABLE IF NOT EXISTS Est_lier (
  discussion_id INTEGER ,  
  tag_id 		INTEGER , 
  PRIMARY KEY (discussion_id, tag_id),
  
  CONSTRAINT fk_liaison
	  FOREIGN KEY (discussion_id) REFERENCES Discussion(discussion_id) 	ON DELETE CASCADE,
	  FOREIGN KEY (tag_id) 		  REFERENCES Tag(tag_id)			  	ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS Message_Family(
  message_parent INTEGER,
  message_fils   INTEGER UNIQUE,  /* Meilleur moyen possible? */
  
  PRIMARY KEY (message_parent, message_fils),
  
  CONSTRAINT fk_mess_Family
  FOREIGN KEY (message_parent) REFERENCES Message(message_id) ON DELETE CASCADE,
  FOREIGN KEY (message_fils) REFERENCES Message(message_id) ON DELETE CASCADE
  
);

/* pour les tests:
SELECT * FROM appartient;
SELECT * FROM departement;
SELECT * FROM discussion;
SELECT * FROM est_lier;
SELECT * FROM message;
SELECT * FROM roles;
SELECT * FROM tag;
SELECT * FROM vote;

*/
	-- Insertion dans la classe Departement.
