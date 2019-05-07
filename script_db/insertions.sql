-- Insertion dans la classe Departement.

INSERT INTO departement(nom_departement)
Values 
  ('HEG'),
  ('TIC'),
  ('TIN'),
  ('EC+G'),  
  ('COMEN');

-- Insertion dans la classe Roles

INSERT INTO roles (nom_role)
Values 
  ('Etudiant'),
  ('Assistant'),
  ('Professeur'),
  ('Administrateur');  

-- Insertion dans la classe tag

INSERT INTO tag(nom, prioritaire, rang)
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

-- Insertion dans la classe Utilisateur.

INSERT into utilisateur(nom_utilisateur, mail_utilisateur, mot_de_passe, role_utilisateur)
Values
    /*md5('root1234') = e8bc632a8955b067e4f57824d5954690*/
  ('Admin', 'admin.administrateur@heig-vd.ch', 'aabb2100033f0352fe7458e412495148', 4),
    /*md5('bestpassword123454') = e8bc632a8955b067e4f57824d5954690*/
  ('CrescenceK', 'crescence.yimnaingkamdem@heig-vd.ch', 'e8bc632a8955b067e4f57824d5954690', 1),
  /*md5('fyk456') = 95577c3adb3cfa71d89d2d4e2eda96fd*/
  ('youndzoFrancine', 'francine.youndzokengne@heig-vd.ch', '95577c3adb3cfa71d89d2d4e2eda96fd', 1),
    /*md5('tpq789') = 0acf1488de10c0fce54f6aaaf39a303e*/
  ('tiagoquin', 'tiago.povoaqui@heig-vd.ch', '0acf1488de10c0fce54f6aaaf39a303e', 1),
  /*md5('cln123') = 865b501220e511a279efc515503c5ae1*/
  ('cedriclankeu', '(cedric.lankeungassam@heig-vd.ch', '865b501220e511a279efc515503c5ae1', 1),
    /*md5('agi456') = f7b057bc528e98dd80eac722296dd39f*/
  ('AlexandreGabrielli', 'alexandre.gabrielli@heig-vd.ch', 'f7b057bc528e98dd80eac722296dd39f', 1),
    /*md5('mcf789') = 80758752c5e07f13a5f9ca9e43eea251*/
  ('Maxcaduff', 'max.caduff@heig-vd.ch', '80758752c5e07f13a5f9ca9e43eea251', 1),
    /*md5('mcf789') = 80758752c5e07f13a5f9ca9e43eea251*/
  ('grafolytics', 'marcel.graf@heig-vd.ch', '80758752c5e07f13a5f9ca9e43eea251', 3),
    /*md5('cpa456') = 8670948c5a87999218c67b098ed43883*/
  ('ci4cb', 'carlos.pena@heig-vd.ch', '8670948c5a87999218c67b098ed43883', 3),
    /*md5('lionel') = 8670948c5a87999218c67b098ed43883*/
  ('lionel', 'lionel.assistant@heig-vd.ch', '800a0e21225906fe82d141def1a9202d', 2),
    /*md5('nicole') = fc63f87c08d505264caba37514cd0cfd*/
  ('nicole', 'nicole.assistant@heig-vd.ch', 'fc63f87c08d505264caba37514cd0cfd', 2);


-- Insertion dans la classe Message, dans le cas d'un message pas en réponse à un autre.

INSERT into message(contenu, score, utilisateur_id )
Values
  ('Quels sont les objectifs pour ce rendu ?', 0, 5),
  ('verfie l inclusion de toutes les bibliothéques', 0, 3);
  
  -- Insertion dans la classe Discussion faisant abstraction du message racine.

INSERT into discussion(sujet,msgracine_id, utilisateur_id)
Values
  ('Rendu intermediaire PRO', 2,1),
  ('Pourquoi ca ne marche pas ?', 1,2);


-- Insertion dans la classe Message, cas ou un message est en réponse à un autre.

INSERT into message(contenu, score, utilisateur_id,  super_message_id)
Values
  ('On doit pouvoir tester la DB avec des scripts en SQL', 0, 4, 1),
  ('faire les anotations JPA pour les jointures (spring boot)', 0, 2, 1),
  ('Merci ca marche', 0, 6,  2);

-- Insertion dans la classe Message, devant ensuite etre lié à une discussion.

INSERT into message(contenu, score, utilisateur_id)
Values
  ('Conges de paques', 0, 5);

-- Insertion dans la classe Discussion, au travers d'un message existant.

INSERT into discussion(sujet, msgracine_id, utilisateur_id)
Values
  ('Quels sont les prochains conges', 6, 3);


INSERT INTO Vote(utilisateur_id,up_vote,message_id)
VALUES 
  (1,TRUE,1);

INSERT INTO  Message_Family(message_parent , message_fils)
VALUES
  (1,2),
	(1,3),
	(2,4);