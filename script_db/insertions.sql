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

ALTER SEQUENCE tag_tag_id_seq RESTART WITH 1;
INSERT into tag(nom, prioritaire, rang)
Values
	('#debian', false, 1),
	('#poo', true, 5),
	('#pro', true, 8),
	('#assembleur', false, 2),
	('#numerisation', true, 4),
	('#signauxetsysteme', true, 5),
	('#gen', true, 7),
	('#scapy', false, 2),
	('#cpp', true, 3),
	('#netbeans', true, 5),
	('#postgresql', true, 5),
	('#nodejs', true, 6),
	('#securite', true, 9),
	('#get', false, 2),
	('#angular', true, 7),
	('#wireshark', false, 2);
COMMIT;

