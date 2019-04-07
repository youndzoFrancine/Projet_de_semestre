ALTER SEQUENCE departement_departement_id_seq RESTART WITH 1;
INSERT into departement(nom_departement)
Values 
	('HEG'),
	('TIC'),
	('TIN'),
	('EC+G'),  
	('COMEN');
COMMIT;

ALTER SEQUENCE roles_role_id_seq RESTART WITH 1;
INSERT into roles (nom_role)
Values 
	('Etudiant'),
	('Assistant'),
	('Professeur'),
	('Administrateur'),  
COMMIT;


