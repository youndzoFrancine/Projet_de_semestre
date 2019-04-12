-- Insertion dans la classe Departement.

ALTER SEQUENCE departement_departement_id_seq RESTART WITH 1;
INSERT into departement(nom_departement)
Values 
	('HEG'),
	('TIC'),
	('TIN'),
	('EC+G'),  
	('COMEN');
COMMIT;

-- Insertion dans la classe Roles

ALTER SEQUENCE roles_role_id_seq RESTART WITH 1;
INSERT into roles (nom_role)
Values 
	('Etudiant'),
	('Assistant'),
	('Professeur'),
	('Administrateur');
COMMIT;

-- Insertion dans la classe tag.

ALTER SEQUENCE tag_tag_id_seq RESTART WITH 1;
INSERT into tag(nom, prioritaire, rang)
Values
	('debian', false, 1),
	('poo', true, 5),
	('pro', true, 8),
	('assembleur', false, 2),
	('numerisation', true, 4),
	('signauxetsysteme', true, 5),
	('gen', true, 7),
	('scapy', false, 2),
	('cpp', true, 3),
	('netbeans', true, 5),
	('postgresql', true, 5),
	('nodejs', true, 6),
	('securite', true, 9),
	('get', false, 2),
	('angular', true, 7),
	('wireshark', false, 2);
COMMIT;

-- Insertion dans la classe Utilisateur.

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
  ('lionel', 'lionel.assistant@heig-vd.ch', 'lionel', 2),
  ('nicole', 'nicole.assistant@heig-vd.ch', 'nicole', 2),
  ('theo', 'theophile.choffokokougnang@heig-vd.ch', '1234', 1),
  ('Ahmed', 'Ahmed.dawood@heig-vd.ch', '1234', 1),
  ('Copx', 'julien.coppex@heig-vd.ch', '1234', 1),
  ('duprx', 'françois.dupre@heig-vd.ch', '1234', 1),
  ('gregs', 'gregory.hanggi@heig-vd.ch', '1234', 1),
  ('jenni', 'xavier.Jenni@heig-vd.ch', '1234', 1),
  ('laucel', 'laucella.mattia@heig-vd.ch', '1234', 1),
  ('anto', 'antoine.meckert@heig-vd.ch', '1234', 1),
  ('yannced', 'yanncedric.bebene@heig-vd.ch', '1234', 1),
  ('seb', 'sebastien.birchmeier@heig-vd.ch', '1234', 1),
  ('nils', 'nils.cometta@heig-vd.ch', '1234', 1),
  ('lemd', 'marie.lemdjo@heig-vd.ch', '1234', 1);
COMMIT;

-- Insertion dans la classe Discussion faisant abstraction du message racine.

ALTER SEQUENCE discussion_discussion_id_seq RESTART WITH 1;
INSERT into discussion(sujet, utilisateur_id)
Values
  ('Rendu intermediaire PRO', 2),
  ('Pourquoi ca ne marche pas ?', 6);
COMMIT;

-- Insertion dans la classe Message, dans le cas d'un message pas en réponse à un autre.

ALTER SEQUENCE message_message_id_seq RESTART WITH 1;
INSERT into message(contenu, score, utilisateur_id, discussion_id)
Values
  ('Quels sont les objectifs pour ce rendu ?', 0, 5, 1),
  ('verfie l inclusion de toutes les bibliothéques', 0, 3, 2);
COMMIT;

-- Insertion dans la classe Message, cas ou un message est en réponse à un autre.

INSERT into message(contenu, score, utilisateur_id, discussion_id, super_message_id)
Values
  ('On doit pouvoir tester la DB avec des scripts en SQL', 0, 4, 1, 1),
  ('faire les anotations JPA pour les jointures (spring boot)', 0, 2, 1, 1),
  ('Merci ca marche', 0, 6, 2, 2);
COMMIT;

-- Insertion dans la classe Message, devant ensuite etre lié à une discussion.

INSERT into message(contenu, score, utilisateur_id)
Values
  ('Conges de paques', 0, 5);
COMMIT;

-- Insertion dans la classe Discussion, au travers d'un message existant.

INSERT into discussion(sujet, msgracine_id, utilisateur_id)
Values
  ('Quels sont les prochains conges', 6, 3);
COMMIT;





