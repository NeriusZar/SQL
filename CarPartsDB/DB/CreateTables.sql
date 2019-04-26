CREATE TABLE neza4283.Gamintojas (   
    Pavadinimas           CHAR(20)    NOT NULL,
    Salis                 CHAR(20)    NOT NULL,
    Kokybes_Indeksas	INT	CONSTRAINT TinkamiKokybesIndeksai 
    CHECK (Kokybes_Indeksas BETWEEN 1 AND 10)
    DEFAULT 5,
    Kainos_Indeksas	INT	CONSTRAINT TinkamiKainosIndeksai 
    CHECK (Kainos_Indeksas BETWEEN 1 AND 10)
    DEFAULT 5,     
    PRIMARY KEY (Pavadinimas)
);
CREATE TABLE neza4283.Filtras (
	Kodas				CHAR(20) 	NOT NULL,
	Gamintojas		CHAR(20)		NOT NULL,
	Kategorija		CHAR(30)		NOT NULL CONSTRAINT Kategorijos
	CHECK (Kategorija IN ('Oro','Tepalo', 'Kuro', 'Salono', 'Hidraulinis')),
	Kiekis	INT CHECK(Kiekis >= 0)
	DEFAULT 0,
	PRIMARY KEY (Kodas),
	FOREIGN KEY (Gamintojas) REFERENCES neza4283.Gamintojas	ON DELETE CASCADE
);
CREATE TABLE neza4283.Automobilis (
	Auto_Kodas 					CHAR(10)			NOT NULL,
	Gamintojas					CHAR(20)			NOT NULL,
	Modelis						CHAR(20)			NOT NULL,
	Variklio_Galingumas		FLOAT 			NOT NULL,
	Pagaminimo_Metai			DATE 				NOT NULL,
	PRIMARY KEY	(Auto_Kodas) 
);
CREATE TABLE neza4283.FiltroTaikomumas (
	Kodas							CHAR(20) 	NOT NULL,
	Auto_Kodas 					CHAR(10)		NOT NULL,
	PRIMARY KEY (Kodas,Auto_Kodas),
	FOREIGN KEY (Kodas) REFERENCES neza4283.Filtras ON DELETE CASCADE,
	FOREIGN KEY (Auto_Kodas) REFERENCES neza4283.Automobilis ON DELETE CASCADE
);