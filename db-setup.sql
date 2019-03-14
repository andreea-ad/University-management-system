create database if not exists universitate;

use universitate;

##########################
#USERS(all types) -- login
##########################

CREATE TABLE 'userAdmin'(
	'id' int(10) NOT NULL,
	'email_address' varchar(70) NOT NULL,
	'password' varchar(100) NOT NULL,
	PRIMARY KEY('id')
	)ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO 'userAdmin' ('id', 'email_address', 'password') VALUES (1, 'adminUniversitate@gmail.com', 'admin1');
INSERT INTO 'userAdmin' ('id', 'email_address', 'password') VALUES (2, 'rectorUniversitate@gmail.com', 'rector1');

CREATE TABLE 'userSecretariat'(
	'id' int(10) NOT NULL,
	'faculty' varchar(50) NOT NULL,
	'email_address' varchar(70) NOT NULL,
	'password' varchar(100) NOT NULL,
	PRIMARY KEY('id')
	)ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO 'userSecretariat' ('id', 'faculty', 'email_address', 'password') VALUES (1, , 'litere@gmail.com', 'litere1');
INSERT INTO 'userSecretariat' ('id', 'faculty', 'email_address', 'password') VALUES (2, 'Fizica', 'fizica@gmail.com', 'fizica1');
INSERT INTO 'userSecretariat' ('id', 'faculty', 'email_address', 'password') VALUES (3, 'Mate-Info', 'Mate-Info@gmail.com', 'mateinfo1');
INSERT INTO 'userSecretariat' ('id', 'faculty', 'email_address', 'password') VALUES (4, 'Psihologie', 'psihologie@gmail.com', 'psihologie1');
INSERT INTO 'userSecretariat' ('id', 'faculty', 'email_address', 'password') VALUES (5, 'Comunicare', 'comunicare@gmail.com', 'comunicare1');
INSERT INTO 'userSecretariat' ('id', 'faculty', 'email_address', 'password') VALUES (6, 'Arte', 'arte@gmail.com', 'arte1');
INSERT INTO 'userSecretariat' ('id', 'faculty', 'email_address', 'password') VALUES (7, 'Chimie-Biologie', 'chimie@gmail.com', 'chimiebio1');
INSERT INTO 'userSecretariat' ('id', 'faculty', 'email_address', 'password') VALUES (8, 'FEAA', 'feaa@gmail.com', 'feaa1');

CREATE TABLE 'userProfesor'(
	'id' int(10) NOT NULL,
	'email_address' varchar(70) NOT NULL,
	'password' varchar(100) NOT NULL,
	PRIMARY KEY('id')
	)ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO 'userProfesor' ('id', 'email_address', 'password') VALUES (1, 'maria.ionescu@gmail.com', 'litere2');
INSERT INTO 'userProfesor' ('id', 'email_address', 'password') VALUES (2, 'mihai.ioan@gmail.com', 'litere3');
INSERT INTO 'userProfesor' ('id', 'email_address', 'password') VALUES (3, 'roxana.popescu@gmail.com', 'litere4');
INSERT INTO 'userProfesor' ('id', 'email_address', 'password') VALUES (4, 'ion.cristea@gmail.com', 'litere5');
INSERT INTO 'userProfesor' ('id', 'email_address', 'password') VALUES (5, 'alexandru.rusu@gmail.com', 'litere6');

INSERT INTO 'userProfesor' ('id', 'email_address', 'password') VALUES (6, 'grigore.dumitrascu@gmail.com', 'fizica2');
INSERT INTO 'userProfesor' ('id', 'email_address', 'password') VALUES (7, 'florina.ionas@gmail.com', 'fizica3');
INSERT INTO 'userProfesor' ('id', 'email_address', 'password') VALUES (8, 'diana.szabo@gmail.com', 'fizica4');
INSERT INTO 'userProfesor' ('id', 'email_address', 'password') VALUES (9, 'mihai.mihalache@gmail.com', 'fizica5');
INSERT INTO 'userProfesor' ('id', 'email_address', 'password') VALUES (10, 'ion.mihai@gmail.com', 'fizica6');

INSERT INTO 'userProfesor' ('id', 'email_address', 'password') VALUES (11, 'ruxandra.ion@gmail.com', 'mateinfo2');
INSERT INTO 'userProfesor' ('id', 'email_address', 'password') VALUES (12, 'louis.toth@gmail.com', 'mateinfo3');
INSERT INTO 'userProfesor' ('id', 'email_address', 'password') VALUES (13, 'cristian.dan@gmail.com', 'mateinfo4');
INSERT INTO 'userProfesor' ('id', 'email_address', 'password') VALUES (14, 'ioana.stan@gmail.com', 'mateinfo5');
INSERT INTO 'userProfesor' ('id', 'email_address', 'password') VALUES (15, 'andreea.dumitru@gmail.com', 'mateinfo6');

INSERT INTO 'userProfesor' ('id', 'email_address', 'password') VALUES (16, 'sorina.cristea@gmail.com', 'psihologie2');
INSERT INTO 'userProfesor' ('id', 'email_address', 'password') VALUES (17, 'alin.ioan@gmail.com', 'psihologie3');
INSERT INTO 'userProfesor' ('id', 'email_address', 'password') VALUES (18, 'maia.tidrea@gmail.com', 'psihologie4');
INSERT INTO 'userProfesor' ('id', 'email_address', 'password') VALUES (19, 'valentin.damian@gmail.com', 'psihologie5');
INSERT INTO 'userProfesor' ('id', 'email_address', 'password') VALUES (20, 'dana.radu@gmail.com', 'psihologie6');

INSERT INTO 'userProfesor' ('id', 'email_address', 'password') VALUES (21, 'alina.almas@gmail.com', 'comunicare2');
INSERT INTO 'userProfesor' ('id', 'email_address', 'password') VALUES (22, 'stefan.calin@gmail.com', 'comunicare3');
INSERT INTO 'userProfesor' ('id', 'email_address', 'password') VALUES (23, 'darius.cocos@gmail.com', 'comunicare4');
INSERT INTO 'userProfesor' ('id', 'email_address', 'password') VALUES (24, 'ramona.ionescu@gmail.com', 'comunicare5');
INSERT INTO 'userProfesor' ('id', 'email_address', 'password') VALUES (25, 'sonia.martin@gmail.com', 'comunicare6');

INSERT INTO 'userProfesor' ('id', 'email_address', 'password') VALUES (26, 'laura.grigorescu@gmail.com', 'arte2');
INSERT INTO 'userProfesor' ('id', 'email_address', 'password') VALUES (27, 'gabriel.lule@gmail.com', 'arte3');
INSERT INTO 'userProfesor' ('id', 'email_address', 'password') VALUES (28, 'diana.firu@gmail.com', 'arte4');
INSERT INTO 'userProfesor' ('id', 'email_address', 'password') VALUES (29, 'irina.anghel@gmail.com', 'arte5');
INSERT INTO 'userProfesor' ('id', 'email_address', 'password') VALUES (30, 'marian.tudor@gmail.com', 'arte6');

INSERT INTO 'userProfesor' ('id', 'email_address', 'password') VALUES (31, 'simona.baisan@gmail.com', 'chimiebio2');
INSERT INTO 'userProfesor' ('id', 'email_address', 'password') VALUES (32, 'gabriela.iuhas@gmail.com', 'chimiebio3');
INSERT INTO 'userProfesor' ('id', 'email_address', 'password') VALUES (33, 'carmen.rosca@gmail.com', 'chimiebio4');
INSERT INTO 'userProfesor' ('id', 'email_address', 'password') VALUES (34, 'alexandru.ros@gmail.com', 'chimiebio5');
INSERT INTO 'userProfesor' ('id', 'email_address', 'password') VALUES (35, 'ruth.ionescu@gmail.com', 'chimiebio6');

INSERT INTO 'userProfesor' ('id', 'email_address', 'password') VALUES (36, 'dumitru.ansz@gmail.com', 'feaa2');
INSERT INTO 'userProfesor' ('id', 'email_address', 'password') VALUES (37, 'roxana.petrescu@gmail.com', 'feaa3');
INSERT INTO 'userProfesor' ('id', 'email_address', 'password') VALUES (38, 'robert.popescu@gmail.com', 'feaa4');
INSERT INTO 'userProfesor' ('id', 'email_address', 'password') VALUES (39, 'david.stoica@gmail.com', 'feaa5');
INSERT INTO 'userProfesor' ('id', 'email_address', 'password') VALUES (40, 'alma.alexandrescu@gmail.com', 'feaa6');

CREATE TABLE 'userStudent'(
    'id' int(10) NOT NULL,
    'email_address' varchar(70) NOT NULL,
    'password' varchar(100) NOT NULL,
    PRIMARY KEY('id'),
    )ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO 'userStudent' ('id', 'email_address', 'password') VALUES (1, '', '');
INSERT INTO 'userStudent' ('id', 'email_address', 'password') VALUES (2, '', '');
INSERT INTO 'userStudent' ('id', 'email_address', 'password') VALUES (3, '', '');
INSERT INTO 'userStudent' ('id', 'email_address', 'password') VALUES (4, '', '');
INSERT INTO 'userStudent' ('id', 'email_address', 'password') VALUES (5, '', '');
INSERT INTO 'userStudent' ('id', 'email_address', 'password') VALUES (6, '', '');
INSERT INTO 'userStudent' ('id', 'email_address', 'password') VALUES (7, '', '');
INSERT INTO 'userStudent' ('id', 'email_address', 'password') VALUES (8, '', '');
INSERT INTO 'userStudent' ('id', 'email_address', 'password') VALUES (9, '', '');
INSERT INTO 'userStudent' ('id', 'email_address', 'password') VALUES (10, '', '');

INSERT INTO 'userStudent' ('id', 'email_address', 'password') VALUES (11, '', '');
INSERT INTO 'userStudent' ('id', 'email_address', 'password') VALUES (12, '', '');
INSERT INTO 'userStudent' ('id', 'email_address', 'password') VALUES (13, '', '');
INSERT INTO 'userStudent' ('id', 'email_address', 'password') VALUES (14, '', '');
INSERT INTO 'userStudent' ('id', 'email_address', 'password') VALUES (15, '', '');
INSERT INTO 'userStudent' ('id', 'email_address', 'password') VALUES (16, '', '');
INSERT INTO 'userStudent' ('id', 'email_address', 'password') VALUES (17, '', '');
INSERT INTO 'userStudent' ('id', 'email_address', 'password') VALUES (18, '', '');
INSERT INTO 'userStudent' ('id', 'email_address', 'password') VALUES (19, '', '');
INSERT INTO 'userStudent' ('id', 'email_address', 'password') VALUES (20, '', '');

INSERT INTO 'userStudent' ('id', 'email_address', 'password') VALUES (21, '', '');
INSERT INTO 'userStudent' ('id', 'email_address', 'password') VALUES (22, '', '');
INSERT INTO 'userStudent' ('id', 'email_address', 'password') VALUES (23, '', '');
INSERT INTO 'userStudent' ('id', 'email_address', 'password') VALUES (24, '', '');
INSERT INTO 'userStudent' ('id', 'email_address', 'password') VALUES (25, '', '');
INSERT INTO 'userStudent' ('id', 'email_address', 'password') VALUES (26, '', '');
INSERT INTO 'userStudent' ('id', 'email_address', 'password') VALUES (27, '', '');
INSERT INTO 'userStudent' ('id', 'email_address', 'password') VALUES (28, '', '');
INSERT INTO 'userStudent' ('id', 'email_address', 'password') VALUES (29, '', '');
INSERT INTO 'userStudent' ('id', 'email_address', 'password') VALUES (30, '', '');

INSERT INTO 'userStudent' ('id', 'email_address', 'password') VALUES (31, '', '');
INSERT INTO 'userStudent' ('id', 'email_address', 'password') VALUES (32, '', '');
INSERT INTO 'userStudent' ('id', 'email_address', 'password') VALUES (33, '', '');
INSERT INTO 'userStudent' ('id', 'email_address', 'password') VALUES (34, '', '');
INSERT INTO 'userStudent' ('id', 'email_address', 'password') VALUES (35, '', '');
INSERT INTO 'userStudent' ('id', 'email_address', 'password') VALUES (36, '', '');
INSERT INTO 'userStudent' ('id', 'email_address', 'password') VALUES (37, '', '');
INSERT INTO 'userStudent' ('id', 'email_address', 'password') VALUES (38, '', '');
INSERT INTO 'userStudent' ('id', 'email_address', 'password') VALUES (39, '', '');
INSERT INTO 'userStudent' ('id', 'email_address', 'password') VALUES (40, '', '');

INSERT INTO 'userStudent' ('id', 'email_address', 'password') VALUES (41, '', '');
INSERT INTO 'userStudent' ('id', 'email_address', 'password') VALUES (42, '', '');
INSERT INTO 'userStudent' ('id', 'email_address', 'password') VALUES (43, '', '');
INSERT INTO 'userStudent' ('id', 'email_address', 'password') VALUES (44, '', '');
INSERT INTO 'userStudent' ('id', 'email_address', 'password') VALUES (45, '', '');
INSERT INTO 'userStudent' ('id', 'email_address', 'password') VALUES (46, '', '');
INSERT INTO 'userStudent' ('id', 'email_address', 'password') VALUES (47, '', '');
INSERT INTO 'userStudent' ('id', 'email_address', 'password') VALUES (48, '', '');
INSERT INTO 'userStudent' ('id', 'email_address', 'password') VALUES (49, '', '');
INSERT INTO 'userStudent' ('id', 'email_address', 'password') VALUES (50, '', '');

##########################
#TEACHERS -- personal data
##########################

CREATE TABLE 'profesori'(
    'id' int(10) NOT NULL,
    'first_name' varchar(30) NOT NULL,
    'last_name' varchar(30) NOT NULL,
    'dob' date NOT NULL,
    'phone_number' varchar(12) NOT NULL, 
    'address' varchar(30) NOT NULL,
    'email_address' varchar(70) NOT NULL,
    'faculty' varchar(15) NOT NULL,
    'teaching_subject' varchar(30) NOT NULL,
    'hire_date' date NOT NULL,
    PRIMARY KEY('id')
    )ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO 'profesori' ('id', 'first_name', 'last_name', 'dob', 'phone_number', 'address', 'email_address', 'faculty', 'teaching_subject', 'hire_date') VALUES (1, '', '', '', '', '', '', '', '', '', '');
INSERT INTO 'profesori' ('id', 'first_name', 'last_name', 'dob', 'phone_number', 'address', 'email_address', 'faculty', 'teaching_subject', 'hire_date') VALUES (2, '', '', '', '', '', '', '', '', '', '');
INSERT INTO 'profesori' ('id', 'first_name', 'last_name', 'dob', 'phone_number', 'address', 'email_address', 'faculty', 'teaching_subject', 'hire_date') VALUES (3, '', '', '', '', '', '', '', '', '', '');
INSERT INTO 'profesori' ('id', 'first_name', 'last_name', 'dob', 'phone_number', 'address', 'email_address', 'faculty', 'teaching_subject', 'hire_date') VALUES (4, '', '', '', '', '', '', '', '', '', '');
INSERT INTO 'profesori' ('id', 'first_name', 'last_name', 'dob', 'phone_number', 'address', 'email_address', 'faculty', 'teaching_subject', 'hire_date') VALUES (5, '', '', '', '', '', '', '', '', '', '');

INSERT INTO 'profesori' ('id', 'first_name', 'last_name', 'dob', 'phone_number', 'address', 'email_address', 'faculty', 'teaching_subject', 'hire_date') VALUES (6, '', '', '', '', '', '', '', '', '', '');
INSERT INTO 'profesori' ('id', 'first_name', 'last_name', 'dob', 'phone_number', 'address', 'email_address', 'faculty', 'teaching_subject', 'hire_date') VALUES (7, '', '', '', '', '', '', '', '', '', '');
INSERT INTO 'profesori' ('id', 'first_name', 'last_name', 'dob', 'phone_number', 'address', 'email_address', 'faculty', 'teaching_subject', 'hire_date') VALUES (8, '', '', '', '', '', '', '', '', '', '');
INSERT INTO 'profesori' ('id', 'first_name', 'last_name', 'dob', 'phone_number', 'address', 'email_address', 'faculty', 'teaching_subject', 'hire_date') VALUES (9, '', '', '', '', '', '', '', '', '', '');
INSERT INTO 'profesori' ('id', 'first_name', 'last_name', 'dob', 'phone_number', 'address', 'email_address', 'faculty', 'teaching_subject', 'hire_date') VALUES (10, '', '', '', '', '', '', '', '', '', '');

INSERT INTO 'profesori' ('id', 'first_name', 'last_name', 'dob', 'phone_number', 'address', 'email_address', 'faculty', 'teaching_subject', 'hire_date') VALUES (11, '', '', '', '', '', '', '', '', '', '');
INSERT INTO 'profesori' ('id', 'first_name', 'last_name', 'dob', 'phone_number', 'address', 'email_address', 'faculty', 'teaching_subject', 'hire_date') VALUES (12, '', '', '', '', '', '', '', '', '', '');
INSERT INTO 'profesori' ('id', 'first_name', 'last_name', 'dob', 'phone_number', 'address', 'email_address', 'faculty', 'teaching_subject', 'hire_date') VALUES (13, '', '', '', '', '', '', '', '', '', '');
INSERT INTO 'profesori' ('id', 'first_name', 'last_name', 'dob', 'phone_number', 'address', 'email_address', 'faculty', 'teaching_subject', 'hire_date') VALUES (14, '', '', '', '', '', '', '', '', '', '');
INSERT INTO 'profesori' ('id', 'first_name', 'last_name', 'dob', 'phone_number', 'address', 'email_address', 'faculty', 'teaching_subject', 'hire_date') VALUES (15, '', '', '', '', '', '', '', '', '', '');

INSERT INTO 'profesori' ('id', 'first_name', 'last_name', 'dob', 'phone_number', 'address', 'email_address', 'faculty', 'teaching_subject', 'hire_date') VALUES (16, '', '', '', '', '', '', '', '', '', '');
INSERT INTO 'profesori' ('id', 'first_name', 'last_name', 'dob', 'phone_number', 'address', 'email_address', 'faculty', 'teaching_subject', 'hire_date') VALUES (17, '', '', '', '', '', '', '', '', '', '');
INSERT INTO 'profesori' ('id', 'first_name', 'last_name', 'dob', 'phone_number', 'address', 'email_address', 'faculty', 'teaching_subject', 'hire_date') VALUES (18, '', '', '', '', '', '', '', '', '', '');
INSERT INTO 'profesori' ('id', 'first_name', 'last_name', 'dob', 'phone_number', 'address', 'email_address', 'faculty', 'teaching_subject', 'hire_date') VALUES (19, '', '', '', '', '', '', '', '', '', '');
INSERT INTO 'profesori' ('id', 'first_name', 'last_name', 'dob', 'phone_number', 'address', 'email_address', 'faculty', 'teaching_subject', 'hire_date') VALUES (20, '', '', '', '', '', '', '', '', '', '');

INSERT INTO 'profesori' ('id', 'first_name', 'last_name', 'dob', 'phone_number', 'address', 'email_address', 'faculty', 'teaching_subject', 'hire_date') VALUES (21, '', '', '', '', '', '', '', '', '', '');
INSERT INTO 'profesori' ('id', 'first_name', 'last_name', 'dob', 'phone_number', 'address', 'email_address', 'faculty', 'teaching_subject', 'hire_date') VALUES (22, '', '', '', '', '', '', '', '', '', '');
INSERT INTO 'profesori' ('id', 'first_name', 'last_name', 'dob', 'phone_number', 'address', 'email_address', 'faculty', 'teaching_subject', 'hire_date') VALUES (23, '', '', '', '', '', '', '', '', '', '');
INSERT INTO 'profesori' ('id', 'first_name', 'last_name', 'dob', 'phone_number', 'address', 'email_address', 'faculty', 'teaching_subject', 'hire_date') VALUES (24, '', '', '', '', '', '', '', '', '', '');
INSERT INTO 'profesori' ('id', 'first_name', 'last_name', 'dob', 'phone_number', 'address', 'email_address', 'faculty', 'teaching_subject', 'hire_date') VALUES (25, '', '', '', '', '', '', '', '', '', '');

INSERT INTO 'profesori' ('id', 'first_name', 'last_name', 'dob', 'phone_number', 'address', 'email_address', 'faculty', 'teaching_subject', 'hire_date') VALUES (26, '', '', '', '', '', '', '', '', '', '');
INSERT INTO 'profesori' ('id', 'first_name', 'last_name', 'dob', 'phone_number', 'address', 'email_address', 'faculty', 'teaching_subject', 'hire_date') VALUES (27, '', '', '', '', '', '', '', '', '', '');
INSERT INTO 'profesori' ('id', 'first_name', 'last_name', 'dob', 'phone_number', 'address', 'email_address', 'faculty', 'teaching_subject', 'hire_date') VALUES (28, '', '', '', '', '', '', '', '', '', '');
INSERT INTO 'profesori' ('id', 'first_name', 'last_name', 'dob', 'phone_number', 'address', 'email_address', 'faculty', 'teaching_subject', 'hire_date') VALUES (29, '', '', '', '', '', '', '', '', '', '');
INSERT INTO 'profesori' ('id', 'first_name', 'last_name', 'dob', 'phone_number', 'address', 'email_address', 'faculty', 'teaching_subject', 'hire_date') VALUES (30, '', '', '', '', '', '', '', '', '', '');

INSERT INTO 'profesori' ('id', 'first_name', 'last_name', 'dob', 'phone_number', 'address', 'email_address', 'faculty', 'teaching_subject', 'hire_date') VALUES (31, '', '', '', '', '', '', '', '', '', '');
INSERT INTO 'profesori' ('id', 'first_name', 'last_name', 'dob', 'phone_number', 'address', 'email_address', 'faculty', 'teaching_subject', 'hire_date') VALUES (32, '', '', '', '', '', '', '', '', '', '');
INSERT INTO 'profesori' ('id', 'first_name', 'last_name', 'dob', 'phone_number', 'address', 'email_address', 'faculty', 'teaching_subject', 'hire_date') VALUES (33, '', '', '', '', '', '', '', '', '', '');
INSERT INTO 'profesori' ('id', 'first_name', 'last_name', 'dob', 'phone_number', 'address', 'email_address', 'faculty', 'teaching_subject', 'hire_date') VALUES (34, '', '', '', '', '', '', '', '', '', '');
INSERT INTO 'profesori' ('id', 'first_name', 'last_name', 'dob', 'phone_number', 'address', 'email_address', 'faculty', 'teaching_subject', 'hire_date') VALUES (35, '', '', '', '', '', '', '', '', '', '');

INSERT INTO 'profesori' ('id', 'first_name', 'last_name', 'dob', 'phone_number', 'address', 'email_address', 'faculty', 'teaching_subject', 'hire_date') VALUES (36, '', '', '', '', '', '', '', '', '', '');
INSERT INTO 'profesori' ('id', 'first_name', 'last_name', 'dob', 'phone_number', 'address', 'email_address', 'faculty', 'teaching_subject', 'hire_date') VALUES (37, '', '', '', '', '', '', '', '', '', '');
INSERT INTO 'profesori' ('id', 'first_name', 'last_name', 'dob', 'phone_number', 'address', 'email_address', 'faculty', 'teaching_subject', 'hire_date') VALUES (38, '', '', '', '', '', '', '', '', '', '');
INSERT INTO 'profesori' ('id', 'first_name', 'last_name', 'dob', 'phone_number', 'address', 'email_address', 'faculty', 'teaching_subject', 'hire_date') VALUES (39, '', '', '', '', '', '', '', '', '', '');
INSERT INTO 'profesori' ('id', 'first_name', 'last_name', 'dob', 'phone_number', 'address', 'email_address', 'faculty', 'teaching_subject', 'hire_date') VALUES (40, '', '', '', '', '', '', '', '', '', '');

##########################
#STUDENTS -- personal data
##########################

CREATE TABLE 'studenti'(
    'id' int(10) NOT NULL,
    'first_name' varchar(30) NOT NULL,
    'last_name' varchar(30) NOT NULL,
    'dob' date NOT NULL,
    'phone_number' varchar(12) NOT NULL, 
    'address' varchar(30) NOT NULL,
    'email_address' varchar(70) NOT NULL,
    'faculty' varchar(15) NOT NULL,
    'department' varchar(15) NOT NULL,
    PRIMARY KEY('id')
    )ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO 'studenti' ('id', "first_name", 'last_name', 'dob', 'phone_number', 'address', 'email_address', 'faculty', 'department') VALUES (1, '', '', '', '', '', '', '', '');
INSERT INTO 'studenti' ('id', "first_name", 'last_name', 'dob', 'phone_number', 'address', 'email_address', 'faculty', 'department') VALUES (2, '', '', '', '', '', '', '', '');
INSERT INTO 'studenti' ('id', "first_name", 'last_name', 'dob', 'phone_number', 'address', 'email_address', 'faculty', 'department') VALUES (3, '', '', '', '', '', '', '', '');
INSERT INTO 'studenti' ('id', "first_name", 'last_name', 'dob', 'phone_number', 'address', 'email_address', 'faculty', 'department') VALUES (4, '', '', '', '', '', '', '', '');
INSERT INTO 'studenti' ('id', "first_name", 'last_name', 'dob', 'phone_number', 'address', 'email_address', 'faculty', 'department') VALUES (5, '', '', '', '', '', '', '', '');
INSERT INTO 'studenti' ('id', "first_name", 'last_name', 'dob', 'phone_number', 'address', 'email_address', 'faculty', 'department') VALUES (6, '', '', '', '', '', '', '', '');
INSERT INTO 'studenti' ('id', "first_name", 'last_name', 'dob', 'phone_number', 'address', 'email_address', 'faculty', 'department') VALUES (7, '', '', '', '', '', '', '', '');
INSERT INTO 'studenti' ('id', "first_name", 'last_name', 'dob', 'phone_number', 'address', 'email_address', 'faculty', 'department') VALUES (8, '', '', '', '', '', '', '', '');
INSERT INTO 'studenti' ('id', "first_name", 'last_name', 'dob', 'phone_number', 'address', 'email_address', 'faculty', 'department') VALUES (9, '', '', '', '', '', '', '', '');
INSERT INTO 'studenti' ('id', "first_name", 'last_name', 'dob', 'phone_number', 'address', 'email_address', 'faculty', 'department') VALUES (10, '', '', '', '', '', '', '', '');

INSERT INTO 'studenti' ('id', "first_name", 'last_name', 'dob', 'phone_number', 'address', 'email_address', 'faculty', 'department') VALUES (11, '', '', '', '', '', '', '', '');
INSERT INTO 'studenti' ('id', "first_name", 'last_name', 'dob', 'phone_number', 'address', 'email_address', 'faculty', 'department') VALUES (12, '', '', '', '', '', '', '', '');
INSERT INTO 'studenti' ('id', "first_name", 'last_name', 'dob', 'phone_number', 'address', 'email_address', 'faculty', 'department') VALUES (13, '', '', '', '', '', '', '', '');
INSERT INTO 'studenti' ('id', "first_name", 'last_name', 'dob', 'phone_number', 'address', 'email_address', 'faculty', 'department') VALUES (14, '', '', '', '', '', '', '', '');
INSERT INTO 'studenti' ('id', "first_name", 'last_name', 'dob', 'phone_number', 'address', 'email_address', 'faculty', 'department') VALUES (15, '', '', '', '', '', '', '', '');
INSERT INTO 'studenti' ('id', "first_name", 'last_name', 'dob', 'phone_number', 'address', 'email_address', 'faculty', 'department') VALUES (16, '', '', '', '', '', '', '', '');
INSERT INTO 'studenti' ('id', "first_name", 'last_name', 'dob', 'phone_number', 'address', 'email_address', 'faculty', 'department') VALUES (17, '', '', '', '', '', '', '', '');
INSERT INTO 'studenti' ('id', "first_name", 'last_name', 'dob', 'phone_number', 'address', 'email_address', 'faculty', 'department') VALUES (18, '', '', '', '', '', '', '', '');
INSERT INTO 'studenti' ('id', "first_name", 'last_name', 'dob', 'phone_number', 'address', 'email_address', 'faculty', 'department') VALUES (19, '', '', '', '', '', '', '', '');
INSERT INTO 'studenti' ('id', "first_name", 'last_name', 'dob', 'phone_number', 'address', 'email_address', 'faculty', 'department') VALUES (20, '', '', '', '', '', '', '', '');

INSERT INTO 'studenti' ('id', "first_name", 'last_name', 'dob', 'phone_number', 'address', 'email_address', 'faculty', 'department') VALUES (21, '', '', '', '', '', '', '', '');
INSERT INTO 'studenti' ('id', "first_name", 'last_name', 'dob', 'phone_number', 'address', 'email_address', 'faculty', 'department') VALUES (22, '', '', '', '', '', '', '', '');
INSERT INTO 'studenti' ('id', "first_name", 'last_name', 'dob', 'phone_number', 'address', 'email_address', 'faculty', 'department') VALUES (23, '', '', '', '', '', '', '', '');
INSERT INTO 'studenti' ('id', "first_name", 'last_name', 'dob', 'phone_number', 'address', 'email_address', 'faculty', 'department') VALUES (24, '', '', '', '', '', '', '', '');
INSERT INTO 'studenti' ('id', "first_name", 'last_name', 'dob', 'phone_number', 'address', 'email_address', 'faculty', 'department') VALUES (25, '', '', '', '', '', '', '', '');
INSERT INTO 'studenti' ('id', "first_name", 'last_name', 'dob', 'phone_number', 'address', 'email_address', 'faculty', 'department') VALUES (26, '', '', '', '', '', '', '', '');
INSERT INTO 'studenti' ('id', "first_name", 'last_name', 'dob', 'phone_number', 'address', 'email_address', 'faculty', 'department') VALUES (27, '', '', '', '', '', '', '', '');
INSERT INTO 'studenti' ('id', "first_name", 'last_name', 'dob', 'phone_number', 'address', 'email_address', 'faculty', 'department') VALUES (28, '', '', '', '', '', '', '', '');
INSERT INTO 'studenti' ('id', "first_name", 'last_name', 'dob', 'phone_number', 'address', 'email_address', 'faculty', 'department') VALUES (29, '', '', '', '', '', '', '', '');
INSERT INTO 'studenti' ('id', "first_name", 'last_name', 'dob', 'phone_number', 'address', 'email_address', 'faculty', 'department') VALUES (30, '', '', '', '', '', '', '', '');

INSERT INTO 'studenti' ('id', "first_name", 'last_name', 'dob', 'phone_number', 'address', 'email_address', 'faculty', 'department') VALUES (31, '', '', '', '', '', '', '', '');
INSERT INTO 'studenti' ('id', "first_name", 'last_name', 'dob', 'phone_number', 'address', 'email_address', 'faculty', 'department') VALUES (32, '', '', '', '', '', '', '', '');
INSERT INTO 'studenti' ('id', "first_name", 'last_name', 'dob', 'phone_number', 'address', 'email_address', 'faculty', 'department') VALUES (33, '', '', '', '', '', '', '', '');
INSERT INTO 'studenti' ('id', "first_name", 'last_name', 'dob', 'phone_number', 'address', 'email_address', 'faculty', 'department') VALUES (34, '', '', '', '', '', '', '', '');
INSERT INTO 'studenti' ('id', "first_name", 'last_name', 'dob', 'phone_number', 'address', 'email_address', 'faculty', 'department') VALUES (35, '', '', '', '', '', '', '', '');
INSERT INTO 'studenti' ('id', "first_name", 'last_name', 'dob', 'phone_number', 'address', 'email_address', 'faculty', 'department') VALUES (36, '', '', '', '', '', '', '', '');
INSERT INTO 'studenti' ('id', "first_name", 'last_name', 'dob', 'phone_number', 'address', 'email_address', 'faculty', 'department') VALUES (37, '', '', '', '', '', '', '', '');
INSERT INTO 'studenti' ('id', "first_name", 'last_name', 'dob', 'phone_number', 'address', 'email_address', 'faculty', 'department') VALUES (38, '', '', '', '', '', '', '', '');
INSERT INTO 'studenti' ('id', "first_name", 'last_name', 'dob', 'phone_number', 'address', 'email_address', 'faculty', 'department') VALUES (39, '', '', '', '', '', '', '', '');
INSERT INTO 'studenti' ('id', "first_name", 'last_name', 'dob', 'phone_number', 'address', 'email_address', 'faculty', 'department') VALUES (40, '', '', '', '', '', '', '', '');

INSERT INTO 'studenti' ('id', "first_name", 'last_name', 'dob', 'phone_number', 'address', 'email_address', 'faculty', 'department') VALUES (41, '', '', '', '', '', '', '', '');
INSERT INTO 'studenti' ('id', "first_name", 'last_name', 'dob', 'phone_number', 'address', 'email_address', 'faculty', 'department') VALUES (42, '', '', '', '', '', '', '', '');
INSERT INTO 'studenti' ('id', "first_name", 'last_name', 'dob', 'phone_number', 'address', 'email_address', 'faculty', 'department') VALUES (43, '', '', '', '', '', '', '', '');
INSERT INTO 'studenti' ('id', "first_name", 'last_name', 'dob', 'phone_number', 'address', 'email_address', 'faculty', 'department') VALUES (44, '', '', '', '', '', '', '', '');
INSERT INTO 'studenti' ('id', "first_name", 'last_name', 'dob', 'phone_number', 'address', 'email_address', 'faculty', 'department') VALUES (45, '', '', '', '', '', '', '', '');
INSERT INTO 'studenti' ('id', "first_name", 'last_name', 'dob', 'phone_number', 'address', 'email_address', 'faculty', 'department') VALUES (46, '', '', '', '', '', '', '', '');
INSERT INTO 'studenti' ('id', "first_name", 'last_name', 'dob', 'phone_number', 'address', 'email_address', 'faculty', 'department') VALUES (47, '', '', '', '', '', '', '', '');
INSERT INTO 'studenti' ('id', "first_name", 'last_name', 'dob', 'phone_number', 'address', 'email_address', 'faculty', 'department') VALUES (48, '', '', '', '', '', '', '', '');
INSERT INTO 'studenti' ('id', "first_name", 'last_name', 'dob', 'phone_number', 'address', 'email_address', 'faculty', 'department') VALUES (49, '', '', '', '', '', '', '', '');
INSERT INTO 'studenti' ('id', "first_name", 'last_name', 'dob', 'phone_number', 'address', 'email_address', 'faculty', 'department') VALUES (50, '', '', '', '', '', '', '', '');

#########
#SUBJECTS
######### 

CREATE TABLE 'materii'(
    'id' int(10) NOT NULL,
    'title' varchar(30) NOT NULL,
    'faculty' varchar(30) NOT NULL,
    'number_of_credits' date NOT NULL,
    PRIMARY KEY('id')
    )ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (1, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (2, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (3, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (4, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (5, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (6, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (7, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (8, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (9, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (10, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (11, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (12, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (13, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (14, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (15, '', '',);

INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (16, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (17, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (18, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (19, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (20, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (21, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (22, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (23, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (24, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (25, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (26, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (27, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (28, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (29, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (30, '', '',);

INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (31, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (32, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (33, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (34, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (35, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (36, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (37, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (38, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (39, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (40, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (41, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (42, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (43, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (44, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (45, '', '',);

INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (46, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (47, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (48, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (49, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (50, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (51, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (52, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (53, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (54, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (55, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (56, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (57, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (58, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (59, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (60, '', '',);

INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (61, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (62, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (63, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (64, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (65, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (66, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (67, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (68, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (69, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (70, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (71, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (72, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (73, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (74, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (75, '', '',);

INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (76, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (77, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (78, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (79, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (80, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (81, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (82, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (83, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (84, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (85, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (86, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (87, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (88, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (89, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (90, '', '',);

INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (91, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (92, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (93, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (94, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (95, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (96, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (97, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (98, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (99, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (100, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (101, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (102, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (103, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (104, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (105, '', '',);

INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (106, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (107, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (108, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (109, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (110, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (111, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (112, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (113, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (114, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (115, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (116, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (117, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (118, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (119, '', '',);
INSERT INTO 'materii' ('id', 'title', 'faculty', 'number_of_credits') VALUES (120, '', '',);

###############################
#MARKS -- to add within the app
###############################

CREATE TABLE 'note'(
    'id' int(10) NOT NULL,
    'student_first_name' varchar(30) NOT NULL,
    'student_last_name' varchar(30) NOT NULL,
    'mark' int(2) NOT NULL,
    'subject' varchar(30) NOT NULL,
    'teacher_first_name' varchar(30) NOT NULL,
    'teacher_last_name' varchar(30) NOT NULL,
    'date_added' date NOT NULL DEFAULT GETDATE(),
    PRIMARY KEY('id')
    )ENGINE=InnoDB DEFAULT CHARSET=latin1;

##########################
#FACULTIES AND DEPARTMENTS
##########################

CREATE TABLE 'facultati'(
    'id' int(2) NOT NULL,
    'title' varchar(30) NOT NULL,
    'department' varchar(15) NOT NULL,
    PRIMARY KEY('id')
    )ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO 'facultati' ('id', 'title', 'department') VALUES (1, 'Facultatea de Litere', 'Limbi moderne si literaturi');
INSERT INTO 'facultati' ('id', 'title', 'department') VALUES (2, 'Facultatea de Litere', 'Istorie');

INSERT INTO 'facultati' ('id', 'title', 'department') VALUES (3, 'Facultatea de Fizica', 'Mecanica');
INSERT INTO 'facultati' ('id', 'title', 'department') VALUES (4, 'Facultatea de Fizica', 'Optica');

INSERT INTO 'facultati' ('id', 'title', 'department') VALUES (5, 'Facultatea de Matematica si Informatica', 'Informatica');
INSERT INTO 'facultati' ('id', 'title', 'department') VALUES (6, 'Facultatea de Matematica si Informatica', 'Matematica');

INSERT INTO 'facultati' ('id', 'title', 'department') VALUES (7, 'Facultatea de Psihologie', 'Psihologie');
INSERT INTO 'facultati' ('id', 'title', 'department') VALUES (8, 'Facultatea de Psihologie', 'Sociologie');

INSERT INTO 'facultati' ('id', 'title', 'department') VALUES (9, 'Facultatea de Comunicare', 'Stiintele comunicarii');
INSERT INTO 'facultati' ('id', 'title', 'department') VALUES (10, 'Facultatea de Comunicare', 'Stiinte politice');

INSERT INTO 'facultati' ('id', 'title', 'department') VALUES (11, 'Facultatea de Arte', 'Arte vizuale');
INSERT INTO 'facultati' ('id', 'title', 'department') VALUES (12, 'Facultatea de Arte', 'Muzica');

INSERT INTO 'facultati' ('id', 'title', 'department') VALUES (13, 'Facultatea de Chimie si Biologie', 'Chimie');
INSERT INTO 'facultati' ('id', 'title', 'department') VALUES (14, 'Facultatea de Chimie si Biologie', 'Biologie');

INSERT INTO 'facultati' ('id', 'title', 'department') VALUES (15, 'Facultatea de Economie si Administrarea Afacerilor', 'Economie si Finante-Banci');
INSERT INTO 'facultati' ('id', 'title', 'department') VALUES (16, 'Facultatea de Economie si Administrarea Afacerilor', 'Administrarea afacerilor');



