drop database if exists Spotify;
create database if not exists Spotify;
use Spotify;

create table Genere(
	genere varchar(10) PRIMARY KEY
);

create table Artista(
	nome_arte varchar(50) PRIMARY KEY,
	numero_brani int,
	tipologia bool
);

create table Compone(
	genere varchar(40),
	nome_arte varchar (50),
	
	CONSTRAINT PK_Compone PRIMARY KEY (genere,nome_arte),
	FOREIGN KEY (genere) REFERENCES Genere(genere),
	FOREIGN KEY (nome_arte) REFERENCES Artista(nome_arte)	
);

create table Brano(
	titolo varchar(40) PRIMARY KEY,
	durata time, 
	nome_arte varchar(50),
	
	FOREIGN KEY (nome_arte) REFERENCES Artista(nome_arte)
);

create table Abbonamento(
	id int auto_increment,
	descrizione varchar(50),
	
	PRIMARY KEY(id)
);

create table Cliente(
	id int auto_increment,
	email varchar(40),
	nome_cognome varchar(50),
	data_di_nascita date,
	cf char(16),
    passwd varchar(40),
	abbonamento int,
	
    PRIMARY KEY(id),
	FOREIGN KEY (abbonamento) references Abbonamento(id)
);

create table Paypal(
	email varchar(40),
	id int,
    
	PRIMARY KEY(email),
    FOREIGN KEY (id) REFERENCES Cliente(id)
);

create table Ascolta(
	id int,
    titolo varchar(40),
    nome_arte varchar(50),
    
    CONSTRAINT PK_Compone PRIMARY KEY (id, titolo, nome_arte),
    FOREIGN KEY (id) REFERENCES Cliente(id),
    FOREIGN KEY (titolo) REFERENCES Brano(titolo),
    FOREIGN KEY (nome_arte) REFERENCES Artista(nome_arte)
);

insert into Genere (genere) values
("POP"),
("ROCK"),
("RAP"),
("CLASSICA"),
("INDIE"),
("BLUES"),
("JAZZ");

insert into Artista (nome_arte, tipologia) values
("J-Ax", 0),
("Jake la Furia", 0),
("Federico Salvatore", 0),
("Skillet", 1),
("Tullio de Piscopo", 0),
("Il Volo", 1),
("Rihanna", 0),
("Annalisa", 0),
("Paparotti", 0),
("Eiffel 65", 1),
("Art Blakey", 0),
("Gazzelle", 0),
("AC-DC", 1),
("Linkin Park", 1),
("Miles Davis", 0),
("Louis Armstrong", 0),
("Sorelle Marinetti", 1),
("The Blue Brothers", 1),
("Delta Moon", 1),
("Club Dogo", 1);

insert into Brano(titolo, durata, nome_arte) values
("Intro", "00:03:53", "J-Ax"),
("Deca Dance", "00:03:09", "J-Ax"),
("Ostia Lido", "00:02:52", "J-Ax"),
("El Chapo", "00:04:12", "Jake la Furia"),
("El Party", "00:03:31", "Jake la Furia"),
("Bandita", "00:03:24", "Jake la Furia"),
("Se io fossi San Gennaro", "00:06:11", "Federico Salvatore"),
("Cornutone", "00:03:55", "Federico Salvatore"),
("Napocalisse", "00:04:53","Federico Salvatore"),
("Monster", "00:02:58", "Skillet"),
("Hero", "00:03:06", "Skillet"),
("Feel Invicible", "00:03:49", "Skillet"),
("Andamento Lento", "00:04:16", "Tullio de Piscopo"),
("Stop Bajon", "00:05:08", "Tullio de Piscopo"),
("Libero", "00:05:01", "Tullio de Piscopo"),
("L'amore si muove", "00:03:39", "Il Volo"),
("Grande amore", "00:03:44", "Il Volo"),
("A chi mi dice", "00:03:39", "Il Volo"),
("Diamonds", "00:03:45", "Rihanna"),
("Rude boy", "00:03:42", "Rihanna"),
("Needed me", "00:03:11", "Rihanna"),
("Avocado Toast", "00:02:23", "Annalisa"),
("Bye Bye", "00:02:56", "Annalisa"),
("Il mondo prima di te", "00:03:38", "Annalisa"),
("Caruso", "00:05:18", "Paparotti"),
("O sole mio", "00:03:22", "Paparotti"),
("Nessun dorma", "00:02:57", "Paparotti"),
("Blue", "00:03:40", "Eiffel 65"),
("Figli di pitagora", "00:04:20", "Eiffel 65"),
("Today", "00:04:25", "Eiffel 65"),
("Moanin", "00:09:35", "Art Blakey"),
("Along came betty", "00:06:11", "Art Blakey"),
("Are you real", "00:04:49", "Art Blakey"),
("Una canzone che non so", "00:03:05", "Gazzelle"),
("Polynesia", "00:03:14", "Gazzelle"),
("Scintille", "00:03:11", "Gazzelle"),
("Thunderstruck", "00:04:52", "AC-DC"),
("Back in Black", "00:04:15", "AC-DC"),
("T.N.T", "00:03:34", "AC-DC"),
("In the end", "00:03:36", "Linkin Park"),
("Numb", "00:03:05", "Linkin Park"),
("What I've done", "00:03:25", "Linkin Park"),
("Blue in green", "00:05:37", "Miles Davis"),
("So what", "00:09:22", "Miles Davis"),
("Stella by starlight", "00:04:44", "Miles Davis"),
("La vie en rose", "00:03:26", "Louis Armstrong"),
("Summer time", "00:04:58", "Louis Armstrong"),
("Cheek to cheek", "00:05:54", "Louis Armstrong"),
("Ma le gambe", "00:02:28", "Sorelle Marinetti"),
("Il pinguino innamorato", "00:02:35", "Sorelle Marinetti"),
("Tulipan", "00:03:07", "Sorelle Marinetti"),
("Think", "00:03:15", "The Blue Brothers"),
("Soul man", "00:03:00", "The Blue Brothers"),
("Sweet home chigaco", "00:07:53", "The Blue Brothers"),
("Clear blue flame", "00:04:07", "Delta Moon"),
("Open al night", "00:02:23", "Delta Moon"),
("Jessie mae", "00:04:20", "Delta Moon"),
("PES", "00:03:48", "Club Dogo"),
("Lisa", "00:03:25", "Club Dogo"),
("Puro Bogotà", "00:04:24", "Club Dogo");

insert into Abbonamento(descrizione) values
("Abbonamento free con pubblicità"),
("Abbonamento premium mensile senza pubblicità");

insert into Cliente(email, nome_cognome, data_di_nascita, cf, abbonamento) values
("salvatore@gmail.com", "Salvatore De Sanzo", "1999-12-01", "SLTDSZ99H12F815F", 2),
("lenovo@gmail.com", "Mario Rossi", "1975-10-22", "MRORSS75H22F879G", 1),
("btcino@gmail.com", "Amedeo Cesarano", "1966-09-23", "AMDCSR66F23E456V", 1),
("dell@gmail.com", "Gabriella Manzo", "2000-05-12", "GBRMNZ00K12L963N", 1),
("object@gmail.com", "Maurizio D'Auria", "2000-01-07", "FRCDRA00B07G159J", 2),
("java@gmail.com", "Salvatore Le Tarri", "1969-10-28", "SLTLTR69J28V741Z", 2);

insert into Paypal(email, id) values
("salvatore@gmail.com", 1),
("albero@gmail.com", 5),
("maria@gmail.com", 6);

insert into Compone (nome_arte, genere) values
("J-Ax","RAP"),
("Jake la Furia","RAP"),
("Federico Salvatore","POP"),
("Skillet","ROCK"),
("Tullio de Piscopo","POP"),
("Il Volo","CLASSICA"),
("Rihanna","POP"),
("Annalisa","POP"),
("Paparotti","CLASSICA"),
("Eiffel 65","POP"),
("Art Blakey","JAZZ"),
("Gazzelle","INDIE"),
("AC-DC","ROCK"),
("Linkin Park","ROCK"),
("Miles Davis","JAZZ"),
("Louis Armstrong","JAZZ"),
("Sorelle Marinetti","JAZZ"),
("The Blue Brothers","BLUES"),
("Delta Moon","BLUES"),
("Club Dogo","RAP");

insert into Ascolta(id, titolo, nome_arte) values
(1, "Intro", "J-Ax"),
(2, "Diamonds", "Rihanna"),
(3, "Monster", "Skillet"),
(5, "Caruso", "Paparotti"),
(1, "Lisa", "Club Dogo"),
(6, "Cheek to cheek", "Louis Armstrong");