CREATE VIEW neza4283.KokybiskiFiltrai AS
	SELECT Kodas, Gamintojas 
	FROM neza4283.Filtras, neza4283.Gamintojas
	WHERE Pavadinimas = neza4283.Filtras.Gamintojas AND Kokybes_Indeksas > 8;

CREATE VIEW neza4283.Filtrai AS
	SELECT Kodas, Kategorija
	FROM neza4283.Filtras;
	
CREATE VIEW neza4283.FiltraiPagalKategorija AS 
	SELECT Kategorija, neza4283.FiltroTaikomumas.Kodas ,Auto_Kodas 
	FROM neza4283.Filtras, neza4283.FiltroTaikomumas
	WHERE neza4283.Filtras.Kodas = neza4283.FiltroTaikomumas.Kodas;