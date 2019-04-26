SELECT neza4283.Filtras.Kodas, Kategorija, Gamintojas 
from neza4283.FiltroTaikomumas, neza4283.Filtras
WHERE neza4283.Filtras.Kodas = neza4283.FiltroTaikomumas.Kodas AND neza4283.FiltroTaikomumas.Auto_Kodas = '129-AUDI';