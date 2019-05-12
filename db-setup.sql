drop database universitate1;
create database if not exists universitate1;

use universitate1;

##########################
#USERS(all types) -- login
##########################

CREATE TABLE userAdmin(
	id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
	email_address varchar(70) NOT NULL,
	pass varchar(100) NOT NULL,
	)ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO userAdmin (email_address, pass) VALUES ('adminUniversitate@gmail.com', 'admin1');
INSERT INTO userAdmin (email_address, pass) VALUES ('rectorUniversitate@gmail.com', 'rector1');

CREATE TABLE userSecretariat(
	id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
	faculty varchar(70) NOT NULL,
	email_address varchar(70) NOT NULL,
	pass varchar(100) NOT NULL,
	flag int NOT NULL
	)ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO userSecretariat (faculty, email_address, pass, flag) VALUES ('Facultatea de Litere', 'litere@gmail.com', 'litere1',1);
INSERT INTO userSecretariat (faculty, email_address, pass, flag) VALUES ('Facultatea de Fizica', 'fizica@gmail.com', 'fizica1',1);
INSERT INTO userSecretariat (faculty, email_address, pass, flag) VALUES ('Facultatea de Matematica si Informatica', 'Mate-Info@gmail.com', 'mateinfo1',1);
INSERT INTO userSecretariat (faculty, email_address, pass, flag) VALUES ('Facultatea de Psihologie si Sociologie', 'psihologie@gmail.com', 'psihologie1',1);
INSERT INTO userSecretariat (faculty, email_address, pass, flag) VALUES ('Facultatea de Comunicare', 'comunicare@gmail.com', 'comunicare1',1);
INSERT INTO userSecretariat (faculty, email_address, pass, flag) VALUES ('Facultatea de Arte', 'arte@gmail.com', 'arte1',1);
INSERT INTO userSecretariat (faculty, email_address, pass, flag) VALUES ('Facultatea de Chimie si Biologie', 'chimie@gmail.com', 'chimiebio1',1);
INSERT INTO userSecretariat (faculty, email_address, pass, flag) VALUES ('Facultatea de Economie si Administrarea Afacerilor', 'feaa@gmail.com', 'feaa1',1);

CREATE TABLE userProfesor(
	id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
	email_address varchar(70) NOT NULL,
	pass varchar(100) NOT NULL, 
	flag int NOT NULL
	)ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO userProfesor (email_address, pass, flag) VALUES ('maria.ionescu@gmail.com', 'litere2',1);
INSERT INTO userProfesor (email_address, pass, flag) VALUES ('mihai.ioan@gmail.com', 'litere3',1);
INSERT INTO userProfesor (email_address, pass, flag) VALUES ('roxana.popescu@gmail.com', 'litere4',1);
INSERT INTO userProfesor (email_address, pass, flag) VALUES ('ion.cristea@gmail.com', 'litere5',1);
INSERT INTO userProfesor (email_address, pass, flag) VALUES ('alexandru.rusu@gmail.com', 'litere6',1);

INSERT INTO userProfesor (email_address, pass, flag) VALUES ('grigore.dumitrascu@gmail.com', 'fizica2',1);
INSERT INTO userProfesor (email_address, pass, flag) VALUES ('florina.ionas@gmail.com', 'fizica3',1);
INSERT INTO userProfesor (email_address, pass, flag) VALUES ('diana.szabo@gmail.com', 'fizica4',1);
INSERT INTO userProfesor (email_address, pass, flag) VALUES ('mihai.mihalache@gmail.com', 'fizica5',1);
INSERT INTO userProfesor (email_address, pass, flag) VALUES ('ion.mihai@gmail.com', 'fizica6',1);

INSERT INTO userProfesor (email_address, pass, flag) VALUES ('ruxandra.ion@gmail.com', 'mateinfo2',1);
INSERT INTO userProfesor (email_address, pass, flag) VALUES ('louis.toth@gmail.com', 'mateinfo3',1);
INSERT INTO userProfesor (email_address, pass, flag) VALUES ('cristian.dan@gmail.com', 'mateinfo4',1);
INSERT INTO userProfesor (email_address, pass, flag) VALUES ('ioana.stan@gmail.com', 'mateinfo5',1);
INSERT INTO userProfesor (email_address, pass, flag) VALUES ('andreea.dumitru@gmail.com', 'mateinfo6',1);

INSERT INTO userProfesor (email_address, pass, flag) VALUES ('sorina.cristea@gmail.com', 'psihologie2',1);
INSERT INTO userProfesor (email_address, pass, flag) VALUES ('alin.ioan@gmail.com', 'psihologie3',1);
INSERT INTO userProfesor (email_address, pass, flag) VALUES ('maia.tidrea@gmail.com', 'psihologie4',1);
INSERT INTO userProfesor (email_address, pass, flag) VALUES ('valentin.damian@gmail.com', 'psihologie5',1);
INSERT INTO userProfesor (email_address, pass, flag) VALUES ('dana.radu@gmail.com', 'psihologie6',1);

INSERT INTO userProfesor (email_address, pass, flag) VALUES ('alina.almas@gmail.com', 'comunicare2',1);
INSERT INTO userProfesor (email_address, pass, flag) VALUES ('stefan.calin@gmail.com', 'comunicare3',1);
INSERT INTO userProfesor (email_address, pass, flag) VALUES ('darius.cocos@gmail.com', 'comunicare4',1);
INSERT INTO userProfesor (email_address, pass, flag) VALUES ('ramona.ionescu@gmail.com', 'comunicare5',1);
INSERT INTO userProfesor (email_address, pass, flag) VALUES ('sonia.martin@gmail.com', 'comunicare6',1);

INSERT INTO userProfesor (email_address, pass, flag) VALUES ('laura.grigorescu@gmail.com', 'arte2',1);
INSERT INTO userProfesor (email_address, pass, flag) VALUES ('gabriel.lule@gmail.com', 'arte3',1);
INSERT INTO userProfesor (email_address, pass, flag) VALUES ('diana.firu@gmail.com', 'arte4',1);
INSERT INTO userProfesor (email_address, pass, flag) VALUES ('irina.anghel@gmail.com', 'arte5',1);
INSERT INTO userProfesor (email_address, pass, flag) VALUES ('marian.tudor@gmail.com', 'arte6',1);

INSERT INTO userProfesor (email_address, pass, flag) VALUES ('simona.baisan@gmail.com', 'chimiebio2',1);
INSERT INTO userProfesor (email_address, pass, flag) VALUES ('gabriela.iuhas@gmail.com', 'chimiebio3',1);
INSERT INTO userProfesor (email_address, pass, flag) VALUES ('carmen.rosca@gmail.com', 'chimiebio4',1);
INSERT INTO userProfesor (email_address, pass, flag) VALUES ('alexandru.ros@gmail.com', 'chimiebio5',1);
INSERT INTO userProfesor (email_address, pass, flag) VALUES ('ruth.ionescu@gmail.com', 'chimiebio6',1);

INSERT INTO userProfesor (email_address, pass, flag) VALUES ('dumitru.ansz@gmail.com', 'feaa2',1);
INSERT INTO userProfesor (email_address, pass, flag) VALUES ('roxana.petrescu@gmail.com', 'feaa3',1);
INSERT INTO userProfesor (email_address, pass, flag) VALUES ('robert.popescu@gmail.com', 'feaa4',1);
INSERT INTO userProfesor (email_address, pass, flag) VALUES ('david.stoica@gmail.com', 'feaa5',1);
INSERT INTO userProfesor (email_address, pass, flag) VALUES ('alma.alexandrescu@gmail.com', 'feaa6',1);

CREATE TABLE userStudent(
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    email_address varchar(70) NOT NULL,
    pass varchar(100) NOT NULL,
    flag int NOT NULL
    )ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO userStudent (email_address, pass, flag) VALUES ('irina.damian@gmail.com', 'litere7',1);
INSERT INTO userStudent (email_address, pass, flag) VALUES ('silviu.mana@gmail.com', 'litere8', 1);
INSERT INTO userStudent (email_address, pass, flag) VALUES ('ramona.sima@gmail.com', 'litere9', 1);
INSERT INTO userStudent (email_address, pass, flag) VALUES ('gabriel.van@gmail.com', 'litere10',1);
INSERT INTO userStudent (email_address, pass, flag) VALUES ('eugen.rotaru@gmail.com', 'litere11',1);
INSERT INTO userStudent (email_address, pass, flag) VALUES ('stefania.pop@gmail.com', 'litere12',1);

INSERT INTO userStudent (email_address, pass, flag) VALUES ('tania.dumitru@gmail.com', 'fizica7',1);
INSERT INTO userStudent (email_address, pass, flag) VALUES ('ioana.ion@gmail.com', 'fizica8',1);
INSERT INTO userStudent (email_address, pass, flag) VALUES ('alexandru.stefu@gmail.com', 'fizica9',1);
INSERT INTO userStudent (email_address, pass, flag) VALUES ('alin.dinu@gmail.com', 'fizica10',1);
INSERT INTO userStudent (email_address, pass, flag) VALUES ('razvan.iuga@gmail.com', 'fizica11',1);
INSERT INTO userStudent (email_address, pass, flag) VALUES ('carmen.neagu@gmail.com', 'fizica12',1);

INSERT INTO userStudent (email_address, pass, flag) VALUES ('cristina.rusu@gmail.com', 'mateinfo7',1);
INSERT INTO userStudent (email_address, pass, flag) VALUES ('andrei.andreescu@gmail.com', 'mateinfo8',1);
INSERT INTO userStudent (email_address, pass, flag) VALUES ('matei.radu@gmail.com', 'mateinfo9',1);
INSERT INTO userStudent (email_address, pass, flag) VALUES ('mihai.silviu@gmail.com', 'mateinfo10',1);
INSERT INTO userStudent (email_address, pass, flag) VALUES ('diana.pap@gmail.com', 'mateinfo11',1);
INSERT INTO userStudent (email_address, pass, flag) VALUES ('daniela.stoica@gmail.com', 'mateinfo12',1);

INSERT INTO userStudent (email_address, pass, flag) VALUES ('anda.chirita@gmail.com', 'psihologie7',1);
INSERT INTO userStudent (email_address, pass, flag) VALUES ('zina.stan@gmail.com', 'psihologie8',1);
INSERT INTO userStudent (email_address, pass, flag) VALUES ('ina.radu@gmail.com', 'psihologie9',1);
INSERT INTO userStudent (email_address, pass, flag) VALUES ('laurentiu.mat@gmail.com', 'psihologie10',1);
INSERT INTO userStudent (email_address, pass, flag) VALUES ('tudor.milin@gmail.com', 'psihologie11',1);
INSERT INTO userStudent (email_address, pass, flag) VALUES ('ana.giurcovici@gmail.com', 'psihologie12',1);

INSERT INTO userStudent (email_address, pass, flag) VALUES ('rares.petrescu@gmail.com', 'comunicare7',1);
INSERT INTO userStudent (email_address, pass, flag) VALUES ('roxana.dumitru@gmail.com', 'comunicare8',1);
INSERT INTO userStudent (email_address, pass, flag) VALUES ('andrei.pastor@gmail.com', 'comunicare9',1);
INSERT INTO userStudent (email_address, pass, flag) VALUES ('andreea.szasz@gmail.com', 'comunicare10',1);
INSERT INTO userStudent (email_address, pass, flag) VALUES ('larisa.balas@gmail.com', 'comunicare11',1);
INSERT INTO userStudent (email_address, pass, flag) VALUES ('adela.zima@gmail.com', 'comunicare12',1);

INSERT INTO userStudent (email_address, pass, flag) VALUES ('natalia.trif@gmail.com', 'arte7',1);
INSERT INTO userStudent (email_address, pass, flag) VALUES ('horatiu.vis@gmail.com', 'arte8',1);
INSERT INTO userStudent (email_address, pass, flag) VALUES ('raluca.viziteu@gmail.com', 'arte9',1);
INSERT INTO userStudent (email_address, pass, flag) VALUES ('emanuela.pop@gmail.com', 'arte10',1);
INSERT INTO userStudent (email_address, pass, flag) VALUES ('florin.adam@gmail.com', 'arte11',1);
INSERT INTO userStudent (email_address, pass, flag) VALUES ('ramon.reiz@gmail.com', 'arte12',1);

INSERT INTO userStudent (email_address, pass, flag) VALUES ('sorina.corvu@gmail.com', 'chimiebio7',1);
INSERT INTO userStudent (email_address, pass, flag) VALUES ('victor.balaban@gmail.com', 'chimiebio8',1);
INSERT INTO userStudent (email_address, pass, flag) VALUES ('alin.cristea@gmail.com', 'chimiebio9',1);
INSERT INTO userStudent (email_address, pass, flag) VALUES ('flavia.olaru@gmail.com', 'chimiebio10',1);
INSERT INTO userStudent (email_address, pass, flag) VALUES ('ioana.teodoroiu@gmail.com', 'chimiebio11',1);
INSERT INTO userStudent (email_address, pass, flag) VALUES ('paul.rusescu@gmail.com', 'chimiebio12',1);

INSERT INTO userStudent (email_address, pass, flag) VALUES ('anita.firu@gmail.com', 'feaa7',1);
INSERT INTO userStudent (email_address, pass, flag) VALUES ('violeta.tanase@gmail.com', 'feaa8',1);
INSERT INTO userStudent (email_address, pass, flag) VALUES ('denis.groza@gmail.com', 'feaa9',1);
INSERT INTO userStudent (email_address, pass, flag) VALUES ('stefan.dumitrescu@gmail.com', 'feaa10',1);
INSERT INTO userStudent (email_address, pass, flag) VALUES ('robert.tudor@gmail.com', 'feaa11',1);
INSERT INTO userStudent (email_address, pass, flag) VALUES ('marc.popovici@gmail.com', 'feaa12',1);


##########################
#TEACHERS -- personal data
##########################

CREATE TABLE professors(
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    first_name varchar(30) NOT NULL,
    last_name varchar(30) NOT NULL,
    cnp bigint NOT NULL,
    dob date NOT NULL,
    phone_number varchar(11) NOT NULL, 
    address varchar(70) NOT NULL,
    email_address varchar(70) NOT NULL,
    faculty varchar(70) NOT NULL,
    teaching_subject varchar(30) NOT NULL,
    hire_date date NOT NULL,
    salary int(6) NOT NULL, 
    flag int NOT NULL
    )ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO professors (first_name, last_name, cnp, dob, phone_number, address, email_address, faculty, teaching_subject, hire_date, salary, flag) VALUES ('Maria', 'Ionescu', 2911003234567, '1991-10-03', '0721456793', 'Str. Lalelelor nr. 7, Timisoara, jud. Timis', 'maria.ionescu@gmail.com', 'Facultatea de Litere', 'Ortografie', '2010-09-25', 4200,1);
INSERT INTO professors (first_name, last_name, cnp, dob, phone_number, address, email_address, faculty, teaching_subject, hire_date, salary, flag) VALUES ('Mihai', 'Ioan', 1820405785342, '1982-04-05', '0775312470', 'Str. Dreptatii nr. 1A, Timisoara, jud. Timis', 'mihai.ioan@gmail.com', 'Facultatea de Litere', 'Literatura moderna', '2014-09-13', 2600,1);
INSERT INTO professors (first_name, last_name, cnp, dob, phone_number, address, email_address, faculty, teaching_subject, hire_date, salary, flag) VALUES ('Roxana', 'Popescu', 2790610693120, '1979-06-10', '0734562380', 'Bd-ul Cetatii nr. 93, Timisoara, jud. Timis', 'roxana.popescu@gmail.com', 'Facultatea de Litere', 'Istoria secolului XX', '2012-04-10', 5000,1);
INSERT INTO professors (first_name, last_name, cnp, dob, phone_number, address, email_address, faculty, teaching_subject, hire_date, salary, flag) VALUES ('Ion', 'Cristea', 1750908309457, '1975-08-08', '0754621924', 'Str. Lalelelor nr. 23, Timisoara, jud. Timis', 'ion.cristea@gmail.com', 'Facultatea de Litere', 'Limba si literatura engleza', '2013-05-29', 1900,1);
INSERT INTO professors (first_name, last_name, cnp, dob, phone_number, address, email_address, faculty, teaching_subject, hire_date, salary, flag) VALUES ('Alexandru', 'Rusu', 1881229093475, '1988-12-29', '0762347651', 'Str. Emile Zola nr. 48, Timisoara, jud. Timis', 'alexandru.rusu@gmail.com', 'Facultatea de Litere', 'Istoria romanilor', '2017-05-14', 2300,1);

INSERT INTO professors (first_name, last_name, cnp, dob, phone_number, address, email_address, faculty, teaching_subject, hire_date, salary, flag) VALUES ('Grigore', 'Dumitrascu', 1850724097324, '1985-07-24', '0743627192', 'Str. Mare nr. 21, Timisoara, jud. Timis', 'grigore.dumitrascu@gmail.com', 'Facultatea de Fizica', 'Fizica cuantica', '2014-11-29', 4500,1);
INSERT INTO professors (first_name, last_name, cnp, dob, phone_number, address, email_address, faculty, teaching_subject, hire_date, salary, flag) VALUES ('Florina', 'Ionas', 2740822573462, '1974-08-22', '0756372811', 'Str. Mircea cel Batran nr. 10, Timisoara, jud. Timis', 'florina.ionas@gmail.com', 'Facultatea de Fizica', 'Teoria relativitatii', '2011-10-23', 3000,1);
INSERT INTO professors (first_name, last_name, cnp, dob, phone_number, address, email_address, faculty, teaching_subject, hire_date, salary, flag) VALUES ('Diana', 'Szabo', 2860211093738, '1986-02-11', '0774929840', 'Bd-ul Republicii nr. 55, Timisoara, jud. Timis', 'diana.szabo@gmail.com', 'Facultatea de Fizica', 'Introducere in mecanica', '2010-05-22', 3700,1);
INSERT INTO professors (first_name, last_name, cnp, dob, phone_number, address, email_address, faculty, teaching_subject, hire_date, salary, flag) VALUES ('Mihai', 'Mihalache', 1790921232911, '1979-09-21', '0742371905', 'Str. Razboieni nr. 1, Timisoara, jud. Timis', 'mihai.mihalache@gmail.com', 'Facultatea de Fizica', 'Optica', '2016-09-15', 4100,1);
INSERT INTO professors (first_name, last_name, cnp, dob, phone_number, address, email_address, faculty, teaching_subject, hire_date, salary, flag) VALUES ('Ion', 'Mihai', 1901129093472, '1990-11-29', '0729800123', 'Str. Morii nr. 93, Timisoara, jud. Timis', 'ion.mihai@gmail.com', 'Facultatea de Fizica', 'Termodinamica', '2015-10-22', 2200,1);

INSERT INTO professors (first_name, last_name, cnp, dob, phone_number, address, email_address, faculty, teaching_subject, hire_date, salary, flag) VALUES ('Ruxandra', 'Ion', 2780408012391, '1978-04-08', '0739040506', 'Str. Crucii nr. 29, Timisoara, jud. Timis', 'ruxandra.ion@gmail.com', 'Facultatea de Matematica si Informatica', 'Analiza matematica', '2010-03-22', 3000,1);
INSERT INTO professors (first_name, last_name, cnp, dob, phone_number, address, email_address, faculty, teaching_subject, hire_date, salary, flag) VALUES ('Louis', 'Toth', 1891103029376, '1989-11-03', '0741200426', 'Bd-ul Timisoara nr. 103, Timisoara, jud. Timis', 'louis.toth@gmail.com', 'Facultatea de Matematica si Informatica', 'Programare', '2011-07-19', 5000,1);
INSERT INTO professors (first_name, last_name, cnp, dob, phone_number, address, email_address, faculty, teaching_subject, hire_date, salary, flag) VALUES ('Cristian', 'Dan', 1760130392001, '1976-01-30', '0776421991', 'Str. Revolutiei nr. 94, Timisoara, jud. Timis', 'cristian.dan@gmail.com', 'Facultatea de Matematica si Informatica', 'Baze de date', '2012-11-16', 3300,1);
INSERT INTO professors (first_name, last_name, cnp, dob, phone_number, address, email_address, faculty, teaching_subject, hire_date, salary, flag) VALUES ('Ioana', 'Stan', 2841227927121, '1984-12-27', '0754366780', 'Str. Belvedere nr. 28, Timisoara, jud. Timis', 'ioana.stan@gmail.com', 'Facultatea de Matematica si Informatica', 'Geometrie', '2013-03-13', 2900,1);
INSERT INTO professors (first_name, last_name, cnp, dob, phone_number, address, email_address, faculty, teaching_subject, hire_date, salary, flag) VALUES ('Andreea', 'Dumitru', 2920727081193, '1992-07-27', '0732469965', 'Str. Mare nr. 33, Timisoara, jud. Timis', 'andreea.dumitru@gmail.com', 'Facultatea de Matematica si Informatica', 'Sisteme de operare', '2014-07-10', 5300,1);

INSERT INTO professors (first_name, last_name, cnp, dob, phone_number, address, email_address, faculty, teaching_subject, hire_date, salary, flag) VALUES ('Sorina', 'Cristea', 2830927930472, '1983-09-27', '0725648198', 'Str. Scarita nr. 20, Timisoara, jud. Timis', 'sorina.cristea@gmail.com', 'Facultatea de Psihologie', 'Pedagogie', '2017-05-22', 2200,1);
INSERT INTO professors (first_name, last_name, cnp, dob, phone_number, address, email_address, faculty, teaching_subject, hire_date, salary, flag) VALUES ('Alin', 'Ioan', 1790506120493, '1979-05-06', '0764413486', 'Str. Tineretii nr. 10, Timisoara, jud. Timis', 'alin.ioan@gmail.com', 'Facultatea de Psihologie', 'Psihoterapie', '2014-07-02', 2500,1);
INSERT INTO professors (first_name, last_name, cnp, dob, phone_number, address, email_address, faculty, teaching_subject, hire_date, salary, flag) VALUES ('Maia', 'Tidrea', 2910820903472, '1991-08-20', '0751216759', 'Str. Soarelui nr. 30, Timisoara, jud. Timis', 'maia.tidrea@gmail.com', 'Facultatea de Psihologie', 'Consiliere familiala', '2012-03-14', 3000,1);
INSERT INTO professors (first_name, last_name, cnp, dob, phone_number, address, email_address, faculty, teaching_subject, hire_date, salary, flag) VALUES ('Valentin', 'Damian', 1870428091285, '1987-04-28', '0772115495', 'Str. Zorilor nr. 40, Timisoara, jud. Timis', 'valentin.damian@gmail.com', 'Facultatea de Psihologie', 'Neuropsihiatrie', '2012-03-14', 4200,1);
INSERT INTO professors (first_name, last_name, cnp, dob, phone_number, address, email_address, faculty, teaching_subject, hire_date, salary, flag) VALUES ('Dana', 'Radu', 2771127048392, '1977-11-27', '0726543179', 'Str. Tartei nr. 50, Timisoara, jud. Timis', 'dana.radu@gmail.com', 'Facultatea de Psihologie', 'Asistenta sociala', '2015-02-27', 4900,1);

INSERT INTO professors (first_name, last_name, cnp, dob, phone_number, address, email_address, faculty, teaching_subject, hire_date, salary, flag) VALUES ('Alina', 'Almas', 2911003938225, '1991-10-03', '0738622559', 'Str. Coroana nr. 60, Timisoara, jud. Timis', 'alina.almas@gmail.com', 'Facultatea de Comunicare', 'Discurs liber', '2013-04-30', 2400,1);
INSERT INTO professors (first_name, last_name, cnp, dob, phone_number, address, email_address, faculty, teaching_subject, hire_date, salary, flag) VALUES ('Stefan', 'Calin', 1820405930291, '1982-04-05', '0721564785', 'Str. Lunga nr. 70, Timisoara, jud. Timis', 'stefan.calin@gmail.com', 'Facultatea de Comunicare', 'Ortografie si punctuatie', '2016-05-26', 2100,1);
INSERT INTO professors (first_name, last_name, cnp, dob, phone_number, address, email_address, faculty, teaching_subject, hire_date, salary, flag) VALUES ('Darius', 'Cocos', 17906109281004, '1979-06-10', '0736511287', 'Str. Mare nr. 120, Timisoara, jud. Timis', 'darius.cocos@gmail.com', 'Facultatea de Comunicare', 'Elemente non-verbale', '2015-01-30', 2600,1);
INSERT INTO professors (first_name, last_name, cnp, dob, phone_number, address, email_address, faculty, teaching_subject, hire_date, salary, flag) VALUES ('Ramona', 'Ionescu', 2750908493385, '1975-09-08', '0741221887', 'Str. Tipografiei nr. 11C, Timisoara, jud. Timis', 'ramona.ionescu@gmail.com', 'Facultatea de Comunicare', 'Gramatica limbii engleze', '2012-06-22', 3600,1);
INSERT INTO professors (first_name, last_name, cnp, dob, phone_number, address, email_address, faculty, teaching_subject, hire_date, salary, flag) VALUES ('Sonia', 'Martin', 2881229094491, '1988-12-29', '0723157587', 'Str. Victor Hugo nr. 13, Timisoara, jud. Timis', 'sonia.martin@gmail.com', 'Facultatea de Comunicare', 'Elaborare eseuri', '2015-06-03', 4300,1);

INSERT INTO professors (first_name, last_name, cnp, dob, phone_number, address, email_address, faculty, teaching_subject, hire_date, salary, flag) VALUES ('Laura', 'Grigorescu', 2850724003912, '1985-07-24', '0743575888', 'Str. Plangerii nr. 29B, Timisoara, jud. Timis', 'laura.grigorescu@gmail.com', 'Facultatea de Arte', 'Fotografie', '2017-11-05', 3400,1);
INSERT INTO professors (first_name, last_name, cnp, dob, phone_number, address, email_address, faculty, teaching_subject, hire_date, salary, flag) VALUES ('Gabriel', 'Lule', 1740822231174, '1974-08-22', '0764121359', 'Str. Nicolae Iorga nr. 35, Timisoara, jud. Timis', 'gabriel.lule@gmail.com', 'Facultatea de Arte', 'Orchestra', '2014-10-24', 2100,1);
INSERT INTO professors (first_name, last_name, cnp, dob, phone_number, address, email_address, faculty, teaching_subject, hire_date, salary, flag) VALUES ('Diana', 'Firu', 2860211004957, '1986-02-11', '0742678439', 'Str. Liege nr. 16, Timisoara, jud. Timis', 'diana.firu@gmail.com', 'Facultatea de Arte', 'Pictura acrilica', '2015-09-22', 2600,1);
INSERT INTO professors (first_name, last_name, cnp, dob, phone_number, address, email_address, faculty, teaching_subject, hire_date, salary, flag) VALUES ('Irina', 'Anghel', 2790921003712, '1979-09-21', '0730087538', 'Str. Polona nr. 10, Timisoara, jud. Timis', 'irina.anghel@gmail.com', 'Facultatea de Arte', 'Instrumente muzicale complexe', '2014-05-08', 4000,1);
INSERT INTO professors (first_name, last_name, cnp, dob, phone_number, address, email_address, faculty, teaching_subject, hire_date, salary, flag) VALUES ('Marian', 'Tudor', 1901129074920, '1990-11-29', '0726884865', 'Str. Renasterii nr. 49, Timisoara, jud. Timis', 'marian.tudor@gmail.com', 'Facultatea de Arte', 'Desen tehnic', '2017-04-17', 3000,1);

INSERT INTO professors (first_name, last_name, cnp, dob, phone_number, address, email_address, faculty, teaching_subject, hire_date, salary, flag) VALUES ('Simona', 'Baisan', 2780408456234, '1978-04-08', '0746774279', 'Bd-ul Dambovita nr. 5A, Timisoara, jud. Timis', 'simona.baisan@gmail.com', 'Facultatea de Chimie si Biologie', 'Chimie organica', '2009-05-29', 6500,1);
INSERT INTO professors (first_name, last_name, cnp, dob, phone_number, address, email_address, faculty, teaching_subject, hire_date, salary, flag) VALUES ('Gabriela', 'Iuhas', 2891103000987, '1989-11-03', '0751097238', 'Str. Gelu nr. 2, Timisoara, jud. Timis', 'gabriela.iuhas@gmail.com', 'Facultatea de Chimie si Biologie', 'Chimie anorganica', '2016-01-25', 3200,1);
INSERT INTO professors (first_name, last_name, cnp, dob, phone_number, address, email_address, faculty, teaching_subject, hire_date, salary, flag) VALUES ('Carmen', 'Rosca', 2760130777845, '1976-01-30', '0721917621', 'Str. Dealului nr. 8, Timisoara, jud. Timis', 'carmen.rosca@gmail.com', 'Facultatea de Chimie si Biologie', 'Biologie moleculara', '2014-07-14', 2800,1);
INSERT INTO professors (first_name, last_name, cnp, dob, phone_number, address, email_address, faculty, teaching_subject, hire_date, salary, flag) VALUES ('Alexandru', 'Ros', 1841227222453, '1984-12-27', '0731938219', 'Str. Ion Creanga nr. 3, Timisoara, jud. Timis', 'alexandru.ros@gmail.com', 'Facultatea de Chimie si Biologie', 'Anatomie si fiziologie umana', '2013-03-28', 3800,1);
INSERT INTO professors (first_name, last_name, cnp, dob, phone_number, address, email_address, faculty, teaching_subject, hire_date, salary, flag) VALUES ('Ruth', 'Ionescu', 2920727908675, '1992-07-27', '0721019386', 'Str. Revolutiei nr. 9, Timisoara, jud. Timis', 'ruth.ionescu@gmail.com', 'Facultatea de Chimie si Biologie', 'Botanica', '2014-02-24', 2500,1);

INSERT INTO professors (first_name, last_name, cnp, dob, phone_number, address, email_address, faculty, teaching_subject, hire_date, salary, flag) VALUES ('Dumitru', 'Ansz', 1830927444567, '1983-09-27', '0774526122', 'Str. Mihai Eminescu nr. 66, Timisoara, jud. Timis', 'dumitru.ansz@gmail.com', 'Facultatea de Economie si Administrarea Afacerilor', 'Econometrie', '2015-09-10', 3200,1);
INSERT INTO professors (first_name, last_name, cnp, dob, phone_number, address, email_address, faculty, teaching_subject, hire_date, salary, flag) VALUES ('Roxana', 'Petrescu', 2790506900643, '1979-05-06', '0738393817', 'Str. Tineretii nr. 45, Timisoara, jud. Timis', 'roxana.petrescu@gmail.com', 'Facultatea de Economie si Administrarea Afacerilor', 'Marketing', '2009-04-23', 4000,1);
INSERT INTO professors (first_name, last_name, cnp, dob, phone_number, address, email_address, faculty, teaching_subject, hire_date, salary, flag) VALUES ('Robert', 'Popescu', 1910820154722, '1991-08-20', '0721928381', 'Bd-ul Dragalina nr. 3, Timisoara, jud. Timis', 'robert.popescu@gmail.com', 'Facultatea de Economie si Administrarea Afacerilor', 'Produsul intern brut', '2016-11-25', 4600,1);
INSERT INTO professors (first_name, last_name, cnp, dob, phone_number, address, email_address, faculty, teaching_subject, hire_date, salary, flag) VALUES ('David', 'Stoica', 1870428076553, '1987-04-28', '0742918291', 'Str. Zorilor nr. 19D, Timisoara, jud. Timis', 'david.stoica@gmail.com', 'Facultatea de Economie si Administrarea Afacerilor', 'Plan de afaceri', '2017-07-11', 3000,1);
INSERT INTO professors (first_name, last_name, cnp, dob, phone_number, address, email_address, faculty, teaching_subject, hire_date, salary, flag) VALUES ('Alma', 'Alexandrescu', 2771127623345, '1977-11-27', '0742019293', 'Str. Lalelelor nr. 12, Timisoara, jud. Timis', 'alma.alexandrescu@gmail.com', 'Facultatea de Economie si Administrarea Afacerilor', 'Investitii', '2009-09-09', 5400,1);

##########################
#STUDENTS -- personal data
##########################

CREATE TABLE students(
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    first_name varchar(30) NOT NULL,
    last_name varchar(30) NOT NULL,
    cnp bigint NOT NULL,
    dob date NOT NULL,
    phone_number varchar(11) NOT NULL, 
    address varchar(70) NOT NULL,
    email_address varchar(70) NOT NULL,
    faculty varchar(70) NOT NULL,
    department varchar(30) NOT NULL,
    degree varchar(11) NOT NULL,
    year int(2) NOT NULL,
    number_of_credits int(4) NOT NULL,
    flag int NOT NULL
    )ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO students (first_name, last_name, cnp, dob, phone_number, address, email_address, faculty, department, degree, year, number_of_credits, flag) VALUES ('Irina', 'Damian', 2960504098129, '1996-05-04', '0732491082','Str. Independentei nr. 19, Timisoara, jud. Timis','irina.damian@gmail.com', 'Facultatea de Litere','Limbi si literaturi moderne','LICENTA',2,110,1);
INSERT INTO students (first_name, last_name, cnp, dob, phone_number, address, email_address, faculty, department, degree, year, number_of_credits, flag) VALUES ('Silviu', 'Mana', 1970730904728, '1997-07-30', '0747392433', 'Bd-ul Dragalina nr. 56, Timisoara, jud. Timis','silviu.mana@gmail.com','Facultatea de Litere', 'Limbi si literaturi moderne','LICENTA', 1,30,1);
INSERT INTO students (first_name, last_name, cnp, dob, phone_number, address, email_address, faculty, department, degree, year, number_of_credits, flag) VALUES ('Ramona', 'Sima', 2950312091274, '1996-03-12', '0752122984','Str. Nicolae Labis nr. 12, Timisoara, jud. Timis', 'ramona.sima@gmail.com','Facultatea de Litere', 'Limbi si literaturi moderne','LICENTA', 3,140,1);
INSERT INTO students (first_name, last_name, cnp, dob, phone_number, address, email_address, faculty, department, degree, year, number_of_credits, flag) VALUES ('Gabriel', 'Van', 1970219093572, '1997-02-19', '0776251823', 'Str. Mare nr. 3, Timisoara, jud. Timis','gabriel.van@gmail.com','Facultatea de Litere', 'Istorie','LICENTA',1,28,1);
INSERT INTO students (first_name, last_name, cnp, dob, phone_number, address, email_address, faculty, department, degree, year, number_of_credits, flag) VALUES ('Eugen', 'Rotaru', 1930917029571, '1993-09-17', '0763527194', 'Str. Revolutiei nr. 44, Timisoara, jud. Timis','eugen.rotaru@gmail.com','Facultatea de Litere', 'Istorie','LICENTA',2, 60,1);
INSERT INTO students (first_name, last_name, cnp, dob, phone_number, address, email_address, faculty, department, degree, year, number_of_credits, flag) VALUES ('Stefania', 'Pop', 2951120983655, '1995-11-20', '0751882232', 'Str. Zorilor nr. 5, Timisoara, jud. Timis','stefania.pop@gmail.com','Facultatea de Litere', 'Istorie','LICENTA',3,120,1);

INSERT INTO students (first_name, last_name, cnp, dob, phone_number, address, email_address, faculty, department, degree, year, number_of_credits, flag) VALUES ('Tania', 'Dumitru', 2930629013726, '1993-06-29', '0728473633', 'Str. Elisabeta nr. 90, Timisoara, jud. Timis','tania.dumitru@gmail.com','Facultatea de Fizica', 'Mecanica', 'LICENTA',2,120,1);
INSERT INTO students (first_name, last_name, cnp, dob, phone_number, address, email_address, faculty, department, degree, year, number_of_credits, flag) VALUES ('Ioana', 'Ion', 2921104291048, '1992-11-04', '0746291999','Piata Constitutiei nr. 72, Timisoara, jud. Timis','ioana.ion@gmail.com', 'Facultatea de Fizica', 'Mecanica', 'LICENTA',1,25,1);
INSERT INTO students (first_name, last_name, cnp, dob, phone_number, address, email_address, faculty, department, degree, year, number_of_credits, flag) VALUES ('Alexandru', 'Stefu', 1920922903337, '1992-09-22', '0753622281','Str. Daliei nr. 5A, Timisoara, jud. Timis','alexandru.stefu@gmail.com', 'Facultatea de Fizica', 'Mecanica','LICENTA', 3,150,1);
INSERT INTO students (first_name, last_name, cnp, dob, phone_number, address, email_address, faculty, department, degree, year, number_of_credits, flag) VALUES ('Alin', 'Dinu', 1961224010294, '1996-12-24', '0773728100', 'Bd-ul I. Vacarescu nr. 21, Timisoara, jud. Timis','alin.dinu@gmail.com','Facultatea de Fizica', 'Optica','LICENTA', 1,10,1);
INSERT INTO students (first_name, last_name, cnp, dob, phone_number, address, email_address, faculty, department, degree, year, number_of_credits, flag) VALUES ('Razvan', 'Iuga', 1840507102948, '1984-05-07', '0762516000', 'Str. Miron Costin nr. 7, Timisoara, jud. Timis','razvan.iuga@gmail.com','Facultatea de Fizica', 'Optica','LICENTA', 2,110,1);
INSERT INTO students (first_name, last_name, cnp, dob, phone_number, address, email_address, faculty, department, degree, year, number_of_credits, flag) VALUES ('Carmen', 'Neagu', 2940130291837, '1994-01-30', '0752718990','Str. Ana Blandiana nr. 88, Timisoara, jud. Timis','carmen.neagu@gmail.com', 'Facultatea de Fizica', 'Optica', 'LICENTA',3,140,1);

INSERT INTO students (first_name, last_name, cnp, dob, phone_number, address, email_address, faculty, department, degree, year, number_of_credits, flag) VALUES ('Cristina', 'Rusu', 2951123072651, '1997-11-23', '0732910092','Str. Regina Maria nr. 3, Timisoara, jud. Timis','cristina.rusu@gmail.com', 'Facultatea de Matematica si Informatica', 'Matematica', 'LICENTA',2,120,1);
INSERT INTO students (first_name, last_name, cnp, dob, phone_number, address, email_address, faculty, department, degree, year, number_of_credits, flag) VALUES ('Andrei', 'Andreescu', 1960213192800, '1996-02-13', '0729994672','Str. Poiana Mare nr. 91, Timisoara, jud. Timis','andrei.andreescu@gmail.com', 'Facultatea de Matematica si Informatica', 'Matematica','LICENTA', 1,25,1);
INSERT INTO students (first_name, last_name, cnp, dob, phone_number, address, email_address, faculty, department, degree, year, number_of_credits, flag) VALUES ('Matei', 'Radu', 1930429104981, '1993-04-29', '0772618495','Str. Pomiculturii nr. 32, Timisoara, jud. Timis','matei.radu@gmail.com', 'Facultatea de Matematica si Informatica', 'Matematica', 'LICENTA',3,145,1);
INSERT INTO students (first_name, last_name, cnp, dob, phone_number, address, email_address, faculty, department, degree, year, number_of_credits, flag) VALUES ('Mihai', 'Silviu', 1970322039582, '1997-03-22', '0734999102','P-ta Libertatii nr. 102, Timisoara, jud. Timis','mihai.silviu@gmail.com', 'Facultatea de Matematica si Informatica', 'Informatica','LICENTA', 1,30,1);
INSERT INTO students (first_name, last_name, cnp, dob, phone_number, address, email_address, faculty, department, degree, year, number_of_credits, flag) VALUES ('Diana', 'Pap', 2960728190093, '1996-07-28', '0754002002','Str. Madona nr. 28, Timisoara, jud. Timis','diana.pap@gmail.com', 'Facultatea de Matematica si Informatica', 'Informatica','LICENTA', 2,90,1);
INSERT INTO students (first_name, last_name, cnp, dob, phone_number, address, email_address, faculty, department, degree, year, number_of_credits, flag) VALUES ('Daniela', 'Stoica', 2851123019377, '1985-11-23', '0724001388','Str. Semicerc nr. 34, Timisoara, jud. Timis','daniela.stoica@gmail.com' ,'Facultatea de Matematica si Informatica', 'Informatica','LICENTA', 3,150,1);

INSERT INTO students (first_name, last_name, cnp, dob, phone_number, address, email_address, faculty, department, degree, year, number_of_credits, flag) VALUES ('Anda', 'Chirita', 2810219039532, '1981-02-19', '0743829900','Str. Taborului nr. 77, Timisoara, jud. Timis','anda.chirita@gmail.com', 'Facultatea de Psihologie', 'Psihologie','LICENTA', 2,85,1);
INSERT INTO students (first_name, last_name, cnp, dob, phone_number, address, email_address, faculty, department, degree, year, number_of_credits, flag) VALUES ('Zina', 'Stan', 2920918029399, '1992-09-18', '0721009382','Str. Zarandului nr. 102C, Timisoara, jud. Timis','zina.stan@gmail.com', 'Facultatea de Psihologie', 'Psihologie','LICENTA', 1,15,1);
INSERT INTO students (first_name, last_name, cnp, dob, phone_number, address, email_address, faculty, department, degree, year, number_of_credits, flag) VALUES ('Ina', 'Radu', 2840819049291, '1984-08-19', '0773628199','Str. Intrarea Lunga nr. 94, Timisoara, jud. Timis','ina.radu@gmail.com', 'Facultatea de Psihologie', 'Psihologie','LICENTA', 3,150,1);
INSERT INTO students (first_name, last_name, cnp, dob, phone_number, address, email_address, faculty, department, degree, year, number_of_credits, flag) VALUES ('Laurentiu', 'Mat', 1931030920012, '1993-10-30', '0767288001','Str. Stefan cel Mare nr. 46, Timisoara, jud. Timis','laurentiu.mat@gmail.com', 'Facultatea de Psihologie', 'Sociologie','LICENTA', 1,30,1);
INSERT INTO students (first_name, last_name, cnp, dob, phone_number, address, email_address, faculty, department, degree, year, number_of_credits, flag) VALUES ('Tudor', 'Milin', 1970526072812, '1997-05-26', '0730294764','Str. Dunarii nr. 85, Timisoara, jud. Timis','tudor.milin@gmail.com', 'Facultatea de Psihologie', 'Sociologie', 'LICENTA',2,80,1);
INSERT INTO students (first_name, last_name, cnp, dob, phone_number, address, email_address, faculty, department, degree, year, number_of_credits, flag) VALUES ('Ana', 'Giurcovici', 2951114762516, '1995-11-14','0757000452', 'Str. Al. Donici nr. 55, Timisoara, jud. Timis','ana.giurcovici@gmail.com', 'Facultatea de Psihologie', 'Sociologie','LICENTA', 3,100,1);

INSERT INTO students (first_name, last_name, cnp, dob, phone_number, address, email_address, faculty, department, degree, year, number_of_credits, flag) VALUES ('Rares', 'Petrescu', 1920617092848, '1992-06-17', '0742103002','Str. Circumvalatiunii nr. 48, Timisoara, jud. Timis','rares.petrescu@gmail.com', 'Facultatea de Comunicare', 'Stiintele comunicarii','LICENTA', 2,65,1);
INSERT INTO students (first_name, last_name, cnp, dob, phone_number, address, email_address, faculty, department, degree, year, number_of_credits, flag) VALUES ('Roxana', 'Dumitru', 2941229057219, '1994-12-29', '0723019992','Str. Eugeniu de Savoya nr. 9, Timisoara, jud. Timis','roxana.dumitru@gmail.com', 'Facultatea de Comunicare', 'Stiintele comunicarii', 'LICENTA',1,30,1);
INSERT INTO students (first_name, last_name, cnp, dob, phone_number, address, email_address, faculty, department, degree, year, number_of_credits, flag) VALUES ('Andrei', 'Pastor', 1950707192039, '1995-07-07', '0757288001','Str. Borzesti nr. 14, Timisoara, jud. Timis','andrei.pastor@gmail.com', 'Facultatea de Comunicare', 'Stiintele comunicarii', 'LICENTA',3,90,1);
INSERT INTO students (first_name, last_name, cnp, dob, phone_number, address, email_address, faculty, department, degree, year, number_of_credits, flag) VALUES ('Andreea', 'Szasz', 2960328039100, '1996-03-28', '0767283929','Str. George Enescu nr. 2, Timisoara, jud. Timis','andreea.szasz@gmail.com', 'Facultatea de Comunicare', 'Stiinte politice', 'LICENTA',1,25,1);
INSERT INTO students (first_name, last_name, cnp, dob, phone_number, address, email_address, faculty, department, degree, year, number_of_credits, flag) VALUES ('Larisa', 'Balas', 2930731029994, '1993-07-31', '0778003211','Str. Sacului nr. 33, Timisoara, jud. Timis','larisa.balas@gmail.com', 'Facultatea de Comunicare', 'Stiinte politice', 'LICENTA',2,40,1);
INSERT INTO students (first_name, last_name, cnp, dob, phone_number, address, email_address, faculty, department, degree, year, number_of_credits, flag) VALUES ('Adela', 'Zima', 2910529033371, '1991-05-29', '0731023324','Str. Ciresului nr. 4, Timisoara, jud. Timis','adela.zima@gmail.com', 'Facultatea de Comunicare', 'Stiinte politice','LICENTA', 3,150,1);

INSERT INTO students (first_name, last_name, cnp, dob, phone_number, address, email_address, faculty, department, degree, year, number_of_credits, flag) VALUES ('Natalia', 'Trif', 2810417920392, '1881-04-17', '0720039139','Str. Lacului nr. 46, Timisoara, jud. Timis','natalia.trif@gmail.com', 'Facultatea de Arte', 'Arte vizuale','LICENTA', 2,75,1);
INSERT INTO students (first_name, last_name, cnp, dob, phone_number, address, email_address, faculty, department, degree, year, number_of_credits, flag) VALUES ('Horatiu', 'Vis', 1891206928812, '1989-12-06', '0742712993','Str. Ady Endre nr. 19, Timisoara, jud. Timis','horatiu.vis@gmail.com', 'Facultatea de Arte', 'Arte vizuale','LICENTA', 1,30,1);
INSERT INTO students (first_name, last_name, cnp, dob, phone_number, address, email_address, faculty, department, degree, year, number_of_credits, flag) VALUES ('Raluca', 'Viziteu', 2940906291899, '1994-09-06', '0721099023','Str. Citadelei nr. 40, Timisoara, jud. Timis','raluca.viziteu@gmail.com', 'Facultatea de Arte', 'Arte vizuale','LICENTA', 3,45,1);
INSERT INTO students (first_name, last_name, cnp, dob, phone_number, address, email_address, faculty, department, degree, year, number_of_credits, flag) VALUES ('Emanuela', 'Pop', 2921014272930, '1992-10-14', '0776260012','Str. Petalelor nr. 36, Timisoara, jud. Timis','emanuela.pop@gmail.com', 'Facultatea de Arte', 'Muzica','LICENTA', 1,25,1);
INSERT INTO students (first_name, last_name, cnp, dob, phone_number, address, email_address, faculty, department, degree, year, number_of_credits, flag) VALUES ('Florin', 'Adam', 1931120019273, '1993-11-20', '0753000214','Bd-ul 16 Decembrie 1989 nr. 26, Timisoara, jud. Timis','florin.adam@gmail.com', 'Facultatea de Arte', 'Muzica','LICENTA', 2,90,1);
INSERT INTO students (first_name, last_name, cnp, dob, phone_number, address, email_address, faculty, department, degree, year, number_of_credits, flag) VALUES ('Ramon', 'Reiz', 1941209105526, '1994-12-09', '0759930212','Str. Zugrav Nedelcu nr. 7, Timisoara, jud. Timis','ramon.reiz@gmail.com', 'Facultatea de Arte', 'Muzica','LICENTA', 3,150,1);

INSERT INTO students (first_name, last_name, cnp, dob, phone_number, address, email_address, faculty, department, degree, year, number_of_credits, flag) VALUES ('Sorina', 'Corvu', 2961227932017, '1996-12-27', '0763800122','Splaiul T. Vladimirescu nr. 41, Timisoara, jud. Timis','sorina.corvu@gmail.com', 'Facultatea de Chimie si Biologie', 'Chimie', 'LICENTA',2,90,1);
INSERT INTO students (first_name, last_name, cnp, dob, phone_number, address, email_address, faculty, department, degree, year, number_of_credits, flag) VALUES ('Victor', 'Balaban', 1831126921918, '1983-11-26', '0773519923','Bd-ul Regele Carol I nr. 5B, Timisoara, jud. Timis','victor.balaban@gmail.com', 'Facultatea de Chimie si Biologie', 'Chimie','LICENTA', 1,30,1);
INSERT INTO students (first_name, last_name, cnp, dob, phone_number, address, email_address, faculty, department, degree, year, number_of_credits, flag) VALUES ('Alin', 'Cristea', 1921025911819, '1992-10-25', '0739002145','Str. Al. Vlahuta nr. 6, Timisoara, jud. Timis','alin.cristea@gmail.com', 'Facultatea de Chimie si Biologie', 'Chimie','LICENTA', 3,30,1);
INSERT INTO students (first_name, last_name, cnp, dob, phone_number, address, email_address, faculty, department, degree, year, number_of_credits, flag) VALUES ('Flavia', 'Olaru', 2860924901720, '1986-09-24', '0740902023','Str. Mangalia nr. 49, Timisoara, jud. Timis','flavia.olaru@gmail.com', 'Facultatea de Chimie si Biologie', 'Biologie','LICENTA', 1,5,1);
INSERT INTO students (first_name, last_name, cnp, dob, phone_number, address, email_address, faculty, department, degree, year, number_of_credits, flag) VALUES ('Ioana', 'Teodoroiu', 2720823891621, '1972-08-23', '0729300193','Str. Ion Ghica nr. 105, Timisoara, jud. Timis','ioana.teodoroiu@gmail.com', 'Facultatea de Chimie si Biologie', 'Biologie','LICENTA', 2,65,1);
INSERT INTO students (first_name, last_name, cnp, dob, phone_number, address, email_address, faculty, department, degree, year, number_of_credits, flag) VALUES ('Paul', 'Rusescu', 1940722881522, '1994-07-22', '0754029102','Str. P. Constantinescu nr. 4, Timisoara, jud. Timis','paul.rusescu@gmail.com', 'Facultatea de Chimie si Biologie', 'Biologie','LICENTA', 3,95,1);

INSERT INTO students (first_name, last_name, cnp, dob, phone_number, address, email_address, faculty, department, degree, year, number_of_credits, flag) VALUES ('Anita', 'Firu', 2810621871423, '1981-06-21', '0762700123','Str. Laurentiu Nicoara nr. 8C, Timisoara, jud. Timis','anita.firu@gmail.com', 'Facultatea de Economie si Administrarea Afacerilor', 'Economie si Finante-Banci','LICENTA', 2,90,1);
INSERT INTO students (first_name, last_name, cnp, dob, phone_number, address, email_address, faculty, department, degree, year, number_of_credits, flag) VALUES ('Violeta', 'Tanase', 2960520861324, '1996-05-20', '0720972001','Str. Veveritei nr. 21, Timisoara, jud. Timis','violeta.tanase@gmail.com', 'Facultatea de Economie si Administrarea Afacerilor', 'Economie si Finante-Banci', 'LICENTA',1,25,1);
INSERT INTO students (first_name, last_name, cnp, dob, phone_number, address, email_address, faculty, department, degree, year, number_of_credits, flag) VALUES ('Denis', 'Groza', 1950419851225, '1995-04-19', '0746270016','Str. Dreptatea nr. 71, Timisoara, jud. Timis','denis.groza@gmail.com', 'Facultatea de Economie si Administrarea Afacerilor', 'Economie si Finante-Banci','LICENTA', 3,55,1);
INSERT INTO students (first_name, last_name, cnp, dob, phone_number, address, email_address, faculty, department, degree, year, number_of_credits, flag) VALUES ('Stefan', 'Dumitrescu', 1940318841126, '1994-03-18', '0773282910','Str. Tacit nr. 93, Timisoara, jud. Timis','stefan.dumitrescu@gmail.com', 'Facultatea de Economie si Administrarea Afacerilor', 'Administrarea Afacerilor','LICENTA', 1,30,1);
INSERT INTO students (first_name, last_name, cnp, dob, phone_number, address, email_address, faculty, department, degree, year, number_of_credits, flag) VALUES ('Robert', 'Tudor', 1930217831027, '1993-02-17', '0753620122','Str. Valiug nr. 30, Timisoara, jud. Timis','robert.tudor@gmail.com', 'Facultatea de Economie si Administrarea Afacerilor', 'Administrarea Afacerilor','LICENTA', 2,80,1);
INSERT INTO students (first_name, last_name, cnp, dob, phone_number, address, email_address, faculty, department, degree, year, number_of_credits, flag) VALUES ('Marc', 'Popovici', 1920116820928, '1992-01-16', '0736193002', 'Str. Ardealul nr. 22, Timisoara, jud. Timis','marc.popovici@gmail.com','Facultatea de Economie si Administrarea Afacerilor', 'Administrarea Afacerilor', 'LICENTA',3,100,1);


#########
#SUBJECTS
######### 

CREATE TABLE subjects(
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    title varchar(50) NOT NULL,
    faculty varchar(70) NOT NULL,
    department varchar(30) NOT NULL,
    degree varchar(11) NOT NULL,
    semester int(2) NOT NULL,
    number_of_credits int(2) NOT NULL,
    teacher_first_name varchar(30) NOT NULL,
    teacher_last_name varchar(30) NOT NULL,
    flag int NOT NULL
    )ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO subjects (title, faculty, department, degree, semester, number_of_credits, teacher_first_name, teacher_last_name, flag) VALUES ('Ortografie', 'Facultatea de Litere', 'Limbi si literaturi moderne', 'LICENTA',2, 5, 'Maria', 'Ionescu',1);
INSERT INTO subjects (title, faculty, department, degree, semester, number_of_credits, teacher_first_name, teacher_last_name, flag) VALUES ('Literatura moderna', 'Facultatea de Litere', 'Limbi si literaturi moderne', 'LICENTA',1, 8, 'Mihai', 'Ioan',1);
INSERT INTO subjects (title, faculty, department, degree, semester, number_of_credits, teacher_first_name, teacher_last_name, flag) VALUES ('Istoria secolului XX', 'Facultatea de Litere', 'Istorie','LICENTA',3, 6, 'Roxana', 'Popescu',1);
INSERT INTO subjects (title, faculty, department, degree, semester, number_of_credits, teacher_first_name, teacher_last_name, flag) VALUES ('Limba si literatura engleza', 'Facultatea de Litere', 'Limbi si literaturi moderne','LICENTA',1, 5, 'Ion', 'Cristea',1);
INSERT INTO subjects (title, faculty, department, degree, semester, number_of_credits, teacher_first_name, teacher_last_name, flag) VALUES ('Istoria romanilor', 'Facultatea de Litere','Istorie','LICENTA',4,4,'Alexandru','Rusu',1);

INSERT INTO subjects (title, faculty, department, degree, semester, number_of_credits, teacher_first_name, teacher_last_name, flag) VALUES ('Fizica cuantica', 'Facultatea de Fizica','Mecanica','LICENTA',6,5,'Grigore','Dumitrascu',1);
INSERT INTO subjects (title, faculty, department, degree, semester, number_of_credits, teacher_first_name, teacher_last_name, flag) VALUES ('Teoria relativitatii', 'Facultatea de Fizica','Optica','LICENTA',4,6,'Florina','Ionas',1);
INSERT INTO subjects (title, faculty, department, degree, semester, number_of_credits, teacher_first_name, teacher_last_name, flag) VALUES ('Introducere in mecanica', 'Facultatea de Fizica','Mecanica','LICENTA',1,3,'Diana','Szabo',1);
INSERT INTO subjects (title, faculty, department, degree, semester, number_of_credits, teacher_first_name, teacher_last_name, flag) VALUES ('Optica', 'Facultatea de Fizica','Optica','LICENTA',2,7,'Mihai','Mihalache',1);
INSERT INTO subjects (title, faculty, department, degree, semester, number_of_credits, teacher_first_name, teacher_last_name, flag) VALUES ('Termodinamica', 'Facultatea de Fizica','Mecanica','LICENTA',5,5,'Ion','Mihai',1);

INSERT INTO subjects (title, faculty, department, degree, semester, number_of_credits, teacher_first_name, teacher_last_name, flag) VALUES ('Analiza matematica', 'Facultatea de Matematica si Informatica','Matematica','LICENTA',1,8,'Ruxandra','Ion',1);
INSERT INTO subjects (title, faculty, department, degree, semester, number_of_credits, teacher_first_name, teacher_last_name, flag) VALUES ('Programare', 'Facultatea de Matematica si Informatica','Informatica','LICENTA',1,6,'Louis','Toth',1);
INSERT INTO subjects (title, faculty, department, degree, semester, number_of_credits, teacher_first_name, teacher_last_name, flag) VALUES ('Baze de date', 'Facultatea de Matematica si Informatica','Informatica','LICENTA',4,6,'Cristian','Dan',1);
INSERT INTO subjects (title, faculty, department, degree, semester, number_of_credits, teacher_first_name, teacher_last_name, flag) VALUES ('Geometrie', 'Facultatea de Matematica si Informatica','Matematica','LICENTA',3,5,'Ioana','Stan',1);
INSERT INTO subjects (title, faculty, department, degree, semester, number_of_credits, teacher_first_name, teacher_last_name, flag) VALUES ('Sisteme de operare', 'Facultatea de Matematica si Informatica','Informatica','LICENTA',5,5,'Andreea','Dumitru',1);

INSERT INTO subjects (title, faculty, department, degree, semester, number_of_credits, teacher_first_name, teacher_last_name, flag) VALUES ('Pedagogie', 'Facultatea de Psihologie','Psihologie','LICENTA',4,6,'Sorina','Cristea',1);
INSERT INTO subjects (title, faculty, department, degree, semester, number_of_credits, teacher_first_name, teacher_last_name, flag) VALUES ('Psihoterapie', 'Facultatea de Psihologie','Psihologie','LICENTA',2,5,'Alin','Ioan',1);
INSERT INTO subjects (title, faculty, department, degree, semester, number_of_credits, teacher_first_name, teacher_last_name, flag) VALUES ('Consiliere familiala', 'Facultatea de Psihologie','Sociologie','LICENTA',6,5,'Maia','Tidrea',1);
INSERT INTO subjects (title, faculty, department, degree, semester, number_of_credits, teacher_first_name, teacher_last_name, flag) VALUES ('Neuropsihiatrie', 'Facultatea de Psihologie','Psihologie','LICENTA',3,4,'Valentin','Damian',1);
INSERT INTO subjects (title, faculty, department, degree, semester, number_of_credits, teacher_first_name, teacher_last_name, flag) VALUES ('Asistenta sociala', 'Facultatea de Psihologie','Sociologie','LICENTA',1,5,'Dana','Radu',1);

INSERT INTO subjects (title, faculty, department, degree, semester, number_of_credits, teacher_first_name, teacher_last_name, flag) VALUES ('Discurs liber', 'Facultatea de Comunicare','Stiinte politice','LICENTA',2,5,'Alina','Almas',1);
INSERT INTO subjects (title, faculty, department, degree, semester, number_of_credits, teacher_first_name, teacher_last_name, flag) VALUES ('Ortografie si punctuatie', 'Facultatea de Comunicare','Stiintele comunicarii','LICENTA',1,4,'Stefan','Calin',1);
INSERT INTO subjects (title, faculty, department, degree, semester, number_of_credits, teacher_first_name, teacher_last_name, flag) VALUES ('Elemente non-verbale', 'Facultatea de Comunicare','Stiinte politice','LICENTA',5,4,'Darius','Cocos',1);
INSERT INTO subjects (title, faculty, department, degree, semester, number_of_credits, teacher_first_name, teacher_last_name, flag) VALUES ('Gramatica limbii engleze', 'Facultatea de Comunicare','Stiintele comunicarii','LICENTA',3,6,'Ramona','Ionescu',1);
INSERT INTO subjects (title, faculty, department, degree, semester, number_of_credits, teacher_first_name, teacher_last_name, flag) VALUES ('Elaborare eseuri', 'Facultatea de Comunicare','Stiintele comunicarii','LICENTA',5,5,'Sonia','Martin',1);

INSERT INTO subjects (title, faculty, department, degree, semester, number_of_credits, teacher_first_name, teacher_last_name, flag) VALUES ('Fotografie', 'Facultatea de Arte','Arte vizuale','LICENTA',2,6,'Laura','Grigorescu',1);
INSERT INTO subjects (title, faculty, department, degree, semester, number_of_credits, teacher_first_name, teacher_last_name, flag) VALUES ('Orchestra', 'Facultatea de Arte','Muzica','LICENTA',1,4,'Gabriel','Lule',1);
INSERT INTO subjects (title, faculty, department, degree, semester, number_of_credits, teacher_first_name, teacher_last_name, flag) VALUES ('Pictura acrilica', 'Facultatea de Arte','Arte vizuale','LICENTA',3,4,'Diana','Firu',1);
INSERT INTO subjects (title, faculty, department, degree, semester, number_of_credits, teacher_first_name, teacher_last_name, flag) VALUES ('Instrumente muzicale complexe', 'Facultatea de Arte','Muzica','LICENTA',5,5,'Irina','Anghel',1);
INSERT INTO subjects (title, faculty, department, degree, semester, number_of_credits, teacher_first_name, teacher_last_name, flag) VALUES ('Desen tehnic', 'Facultatea de Arte','Arte vizuale','LICENTA',3,5,'Marian','Tudor',1);

INSERT INTO subjects (title, faculty, department, degree, semester, number_of_credits, teacher_first_name, teacher_last_name, flag) VALUES ('Chimie organica', 'Facultatea de Chimie si Biologie','Chimie','LICENTA',6,5,'Simona','Baisan',1);
INSERT INTO subjects (title, faculty, department, degree, semester, number_of_credits, teacher_first_name, teacher_last_name, flag) VALUES ('Chimie anorganica', 'Facultatea de Chimie si Biologie','Chimie','LICENTA',4,5,'Gabriela','Iuhas',1);
INSERT INTO subjects (title, faculty, department, degree, semester, number_of_credits, teacher_first_name, teacher_last_name, flag) VALUES ('Biologie moleculara', 'Facultatea de Chimie si Biologie','Biologie','LICENTA',3,5,'Carmen','Rosca',1);
INSERT INTO subjects (title, faculty, department, degree, semester, number_of_credits, teacher_first_name, teacher_last_name, flag) VALUES ('Anatomie si fiziologie umana', 'Facultatea de Chimie si Biologie','Biologie','LICENTA',2,6,'Alexandru','Ros',1);
INSERT INTO subjects (title, faculty, department, degree, semester, number_of_credits, teacher_first_name, teacher_last_name, flag) VALUES ('Botanica', 'Facultatea de Chimie si Biologie','Biologie','LICENTA',5,4,'Ruth','Ionescu',1);

INSERT INTO subjects (title, faculty, department, degree, semester, number_of_credits, teacher_first_name, teacher_last_name, flag) VALUES ('Econometrie', 'Facultatea de Economie si Administrarea Afacerilor','Economie si Finante-Banci','LICENTA',5,4,'Dumitru','Ansz',1);
INSERT INTO subjects (title, faculty, department, degree, semester, number_of_credits, teacher_first_name, teacher_last_name, flag) VALUES ('Marketing', 'Facultatea de Economie si Administrarea Afacerilor','Administrarea afacerilor','LICENTA',3,6,'Roxana','Petrescu',1);
INSERT INTO subjects (title, faculty, department, degree, semester, number_of_credits, teacher_first_name, teacher_last_name, flag) VALUES ('Produsul intern brut', 'Facultatea de Economie si Administrarea Afacerilor','Economie si Finante-Banci','LICENTA',2,5,'Robert','Popescu',1);
INSERT INTO subjects (title, faculty, department, degree, semester, number_of_credits, teacher_first_name, teacher_last_name, flag) VALUES ('Plan de afaceri', 'Facultatea de Economie si Administrarea Afacerilor','Administrarea afacerilor','LICENTA',1,5,'David','Stoica',1);
INSERT INTO subjects (title, faculty, department, degree, semester, number_of_credits, teacher_first_name, teacher_last_name, flag) VALUES ('Investitii', 'Facultatea de Economie si Administrarea Afacerilor','Administrarea afacerilor','LICENTA',6,4,'Alma','Alexandrescu',1);

###############################
#MARKS -- to add within the app
###############################

CREATE TABLE marks(
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    student_first_name varchar(30) NOT NULL,
    student_last_name varchar(30) NOT NULL,
    mark int(3) NOT NULL,
    subject varchar(50) NOT NULL,
    teacher_first_name varchar(30) NOT NULL,
    teacher_last_name varchar(30) NOT NULL,
    date_added timestamp NOT NULL DEFAULT current_timestamp,
    flag int NOT NULL
    )ENGINE=InnoDB DEFAULT CHARSET=latin1;

##########
#FACULTIES 
##########

CREATE TABLE faculties(
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    title varchar(50) NOT NULL,
    flag int NOT NULL
    )ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO faculties (title, flag) VALUES ('Facultatea de Litere',1);
INSERT INTO faculties (title, flag) VALUES ('Facultatea de Fizica',1);
INSERT INTO faculties (title, flag) VALUES ('Facultatea de Matematica si Informatica',1);
INSERT INTO faculties (title, flag) VALUES ('Facultatea de Psihologie',1);
INSERT INTO faculties (title, flag) VALUES ('Facultatea de Comunicare',1);
INSERT INTO faculties (title, flag) VALUES ('Facultatea de Arte',1);
INSERT INTO faculties (title, flag) VALUES ('Facultatea de Chimie si Biologie',1);
INSERT INTO faculties (title, flag) VALUES ('Facultatea de Economie si Administrarea Afacerilor',1);

############
#DEPARTMENTS
############

CREATE TABLE departments(
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    title varchar(50) NOT NULL,
    faculty varchar(50) NOT NULL,
    degree varchar(10) NOT NULL,
    flag int NOT NULL
    )ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO departments (title, faculty, degree, flag) VALUES ('Limbi si literaturi moderne', 'Facultatea de Litere', 'LICENTA',1);
INSERT INTO departments (title, faculty, degree, flag) VALUES ('Istorie', 'Facultatea de Litere', 'LICENTA',1);

INSERT INTO departments (title, faculty, degree, flag) VALUES ('Mecanica', 'Facultatea de Fizica', 'LICENTA',1);
INSERT INTO departments (title, faculty, degree, flag) VALUES ('Optica', 'Facultatea de Fizica', 'LICENTA',1);

INSERT INTO departments (title, faculty, degree, flag) VALUES ('Matematica', 'Facultatea de Matematica si Informatica', 'LICENTA',1);
INSERT INTO departments (title, faculty, degree, flag) VALUES ('Informatica', 'Facultatea de Litere', 'LICENTA',1);

INSERT INTO departments (title, faculty, degree, flag) VALUES ('Psihologie', 'Facultatea de Psihologie', 'LICENTA',1);
INSERT INTO departments (title, faculty, degree, flag) VALUES ('Sociologie', 'Facultatea de Psihologie', 'LICENTA',1);

INSERT INTO departments (title, faculty, degree, flag) VALUES ('Stiintele comunicarii', 'Facultatea de Comunicare', 'LICENTA',1);
INSERT INTO departments (title, faculty, degree, flag) VALUES ('Stiinte politice', 'Facultatea de Comunicare', 'LICENTA',1);

INSERT INTO departments (title, faculty, degree, flag) VALUES ('Arte vizuale', 'Facultatea de Arte', 'LICENTA',1);
INSERT INTO departments (title, faculty, degree, flag) VALUES ('Muzica', 'Facultatea de Arte', 'LICENTA',1);

INSERT INTO departments (title, faculty, degree, flag) VALUES ('Chimie', 'Facultatea de Chimie si Biologie', 'LICENTA',1);
INSERT INTO departments (title, faculty, degree, flag) VALUES ('Biologie', 'Facultatea de Chimie si Biologie', 'LICENTA',1);

INSERT INTO departments (title, faculty, degree, flag) VALUES ('Economie si Finante-Banci', 'Facultatea de Economie si Administrarea Afacerilor', 'LICENTA',1);
INSERT INTO departments (title, faculty, degree, flag) VALUES ('Administrarea Afacerilor', 'Facultatea de Economie si Administrarea Afacerilor', 'LICENTA',1);
