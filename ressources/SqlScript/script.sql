CREATE TABLE GEEK 
( 
ID INTEGER IDENTITY,
NOM VARCHAR(30),
PRENOM VARCHAR(30),
AGE VARCHAR(10),
SEXE VARCHAR(10),
MAIL VARCHAR(30),
PATHAVATAR VARCHAR(50),
);

CREATE TABLE CENTRES_INTERET
(
ID INTEGER IDENTITY,
TITRE VARCHAR(30),
DESCRIPTION VARCHAR(100),
);

CREATE TABLE GEEK_CENTRES_INTERET
(
ID_GEEK INTEGER, 
ID_INTERET INTEGER,
PRIMARY KEY (ID_GEEK, ID_INTERET),
FOREIGN KEY (ID_GEEK) REFERENCES GEEK(ID) ON DELETE CASCADE,
FOREIGN KEY (ID_INTERET) REFERENCES CENTRES_INTERET(ID) ON DELETE CASCADE,
);


INSERT INTO "PUBLIC"."GEEK"
("NOM", "PRENOM", "AGE", "SEXE", "MAIL", "PATHAVATAR" )
VALUES (  'Landrieu', 'alexis', '22', 'homme', 'alexis.landrieu@google.fr', '/ressources/profil/landrieu/picture/avatar.jpeg')

INSERT INTO "PUBLIC"."GEEK"
("NOM", "PRENOM", "AGE", "SEXE", "MAIL", "PATHAVATAR" )
VALUES (  'Mick', 'jean', '25', 'femme', 'mick.jean@google.fr', '/ressources/profil/mick/picture/avatar.jpeg')

INSERT INTO "PUBLIC"."GEEK"
("NOM", "PRENOM", "AGE", "SEXE", "MAIL", "PATHAVATAR" )
VALUES (  'carole', 'darty', '14', 'femme', 'carole.darty@google.fr', '/ressources/profil/carole/picture/avatar.jpeg')