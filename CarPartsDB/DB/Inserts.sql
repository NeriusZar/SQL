INSERT INTO neza4283.Gamintojas VALUES   ('MANN-FILTER',   'Vokietija', 8, 7);
INSERT INTO neza4283.Gamintojas VALUES   ('BOSCH', 'Vokietija'  , 9, 9);
INSERT INTO neza4283.Gamintojas VALUES   ('FILTRON',   'Lenkija', 6, 5);
INSERT INTO neza4283.Gamintojas VALUES   ('VALEO',   'Prancuzija', 7, 6);

INSERT INTO neza4283.Filtras VALUES   ('1.457.433.588','BOSCH','Oro',DEFAULT);
INSERT INTO neza4283.Filtras VALUES   ('PP850' ,   'FILTRON',    'Kuro',  2);
INSERT INTO neza4283.Filtras VALUES   ('586541-VALEO',   'VALEO',  'Tepalo',  3);
INSERT INTO neza4283.Filtras VALUES   ('CUK2939-MANN',   'MANN-FILTER',   'Salono',  1);
INSERT INTO neza4283.Filtras VALUES   ('586522-VALEO',   'VALEO',  'Salono',  3);
INSERT INTO neza4283.Filtras VALUES   ('PP811' ,   'FILTRON',    'Salono',  2);
INSERT INTO neza4283.Filtras VALUES   ('1.457.433.222','BOSCH','Salono',	5);

INSERT INTO neza4283.Automobilis VALUES   ('122-AUDI','Audi','TT Roadster',2.0,'2007-02-25');
INSERT INTO neza4283.Automobilis VALUES   ('129-AUDI','Audi','A3',1.2,'2010-10-15');--MANN-FILTER
INSERT INTO neza4283.Automobilis VALUES   ('111-VW','VW','PASSAT',1.9,'1996-02-23');--FILTRON
INSERT INTO neza4283.Automobilis VALUES   ('456-FORD','FORD','FOCUS',2.5,'2005-01-05');--VALEO
INSERT INTO neza4283.Automobilis VALUES   ('121-VW','VW','PASSAT',2.5,'1998-03-24');--BOSCH

INSERT INTO neza4283.FiltroTaikomumas VALUES   ('1.457.433.588','121-VW');
INSERT INTO neza4283.FiltroTaikomumas VALUES   ('PP850',  '111-VW');
INSERT INTO neza4283.FiltroTaikomumas VALUES   ('586541-VALEO',   '456-FORD');
INSERT INTO neza4283.FiltroTaikomumas VALUES   ('CUK2939-MANN',   '122-AUDI');
INSERT INTO neza4283.FiltroTaikomumas VALUES   ('CUK2939-MANN',   '129-AUDI');
INSERT INTO neza4283.FiltroTaikomumas VALUES   ('PP850',  '121-VW');
INSERT INTO neza4283.FiltroTaikomumas VALUES   ('PP811',   '129-AUDI ');
INSERT INTO neza4283.FiltroTaikomumas VALUES   ('586522-VALEO',   '129-AUDI');
INSERT INTO neza4283.FiltroTaikomumas VALUES   ('PP850',  '122-AUDI');