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

ALTER SEQUENCE utilisateur_utilisateur_id_seq RESTART WITH 1;
INSERT into utilisateur(nom_utilisateur, mail_utilisateur, mot_de_passe, role_utilisateur)
Values
  ('Admin', 'admin.administrateur@heig-vd.ch', 'admin#123', 4),
  ('CrescenceK', 'crescence.yimnaingkamdem@heig-vd.ch', 'cyk123', 1),
  ('youndzoFrancine', 'francine.youndzokengne@heig-vd.ch', 'fyk456', 1),
  ('tiagoquin', 'tiago.povoaqui@heig-vd.ch', 'tpq789', 1),
  ('cedriclankeu', '(cedric.lankeungassam@heig-vd.ch', 'cln123', 1),
  ('AlexandreGabrielli', 'alexandre.gabrielli@heig-vd.ch', 'agi456', 1),
  ('Maxcaduff', 'max.caduff@heig-vd.ch', 'mcf789', 1),
  ('grafolytics', 'marcel.graf@heig-vd.ch', 'mgf123', 3),
  ('ci4cb', 'carlos.pena@heig-vd.ch', 'cpa456', 3),
  ('nionel', 'lionel.assistant@heig-vd.ch', 'lionel', 2),
  ('nicole', 'nicole.assistant@heig-vd.ch', 'nicole', 2);
COMMIT;
