CREATE FUNCTION KiekioTikrinimas() RETURNS "trigger" as $$ 
DECLARE
	FiltroKategorija CHAR(30);
BEGIN
	SELECT Kategorija INTO FiltroKategorija
	FROM neza4283.Filtras 
	WHERE NEW.Kodas = neza4283.Filtras.Kodas;
	
	IF (SELECT COUNT(*) FROM neza4283.FiltraiPagalKategorija
 	WHERE neza4283.FiltraiPagalKategorija.Auto_Kodas = NEW.Auto_Kodas AND neza4283.FiltraiPagalKategorija.Kategorija = FiltroKategorija) >= 3
	THEN RAISE EXCEPTION 'Vienam automobiliui gali buti taikoma ne daugiau kaip 3 skirtingu gamintoju tos pacios kategorijos detales';
	END IF;
	RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER MinFiltruSkaicius
BEFORE INSERT OR UPDATE ON neza4283.FiltroTaikomumas
FOR EACH ROW EXECUTE PROCEDURE KiekioTikrinimas();





CREATE FUNCTION KiekioTikrinimas2() RETURNS "trigger" as $$ 
BEGIN
	IF (SELECT COUNT(*) FROM neza4283.FiltroTaikomumas
 	WHERE neza4283.FiltroTaikomumas.Kodas = NEW.Kodas) >= 3
	THEN RAISE EXCEPTION 'Viena detale gali buti taikoma ne daugiau kaip 3 skirtingiems automobiliams';
	END IF;
	RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER MinFiltruSkaicius2
BEFORE INSERT OR UPDATE ON neza4283.FiltroTaikomumas
FOR EACH ROW EXECUTE PROCEDURE KiekioTikrinimas2();


