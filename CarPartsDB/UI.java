import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.List;
import java.util.LinkedList;


public class UI {
    public void runUI() {
        WorkSQL db = new WorkSQL();
        BufferedReader bufRead = new BufferedReader(new InputStreamReader(System.in));
        int choice = 1;

        printChoices();

        while (choice != 0) {
            try {
                System.out.print(">");
                choice = Integer.parseInt(bufRead.readLine());

                switch (choice) {
                    case  0: break;
                    case  1: rastiGamintojus(bufRead, db);
                        break;
                    case  2: pridetiGamintoja(bufRead, db);
                        break;
                    case  3: pridetiAutomobili(bufRead, db);
                        break;
                    case  4: pridetiFiltra(bufRead, db);
                        break;
                    case  5: keistiIndeksa(bufRead, db);
                        break;
                    case  6: TinkantysFiltrai(bufRead, db);
                        break;
		    case  7: IsimtiDetale(bufRead, db);
                        break;

                    default: System.out.println("Blogas pasirinkimas");
                        break;
                }
            } catch (IOException e) {
                System.out.println("Klaida skaitant ivesti");
            } catch(NumberFormatException e) {
                System.out.println("Netinkamas ivesties formatas");
            }
        }

        db.closeConnection();
    }
    private void printChoices() {
        System.out.println("Meniu:");
        System.out.println("[0] - baigti darba");
        System.out.println("[1] - Spausdinti konkrecia lentele");
        System.out.println("[2] - prideti gamintoja");
        System.out.println("[3] - prideti automobili");
        System.out.println("[4] - prideti filtra");
        System.out.println("[5] - pakeisti gamintojo kainos arba kokybes indeksa");
        System.out.println("[6] - spausdinti filtrus tinkancius pasirinktam automobiliui");
	System.out.println("[7] - isimti filtra is duombzes");

    }
    private void rastiGamintojus(BufferedReader bufRead, WorkSQL db) {
        int choice = 0;
        System.out.println("Kokia lentele noretumete matyti?");
        System.out.println("[1] - Gamintojai");
        System.out.println("[2] - Automobiliai");
        System.out.println("[3] - Filtrai");
        System.out.println("[4] - Taikomumas");
        System.out.print(">");
        
        try {
	    choice = Integer.parseInt(bufRead.readLine());
            switch (choice) {
                case  1: Gamintojai(db);
                    break;
                case  2: Automobiliai(db);
                    break;
                case  3: Filtrai(db);
                    break;
                case  4: Taikomumas(db);
                    break;
                default: System.out.println("Blogas pasirinkimas");
                    break;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
    private void pridetiGamintoja(BufferedReader bufRead, WorkSQL db) {
        System.out.println("Iveskite naujo gamintojo pavadinima, sali,"
                + " kokybes ir kainos indeksus");

        try {
            db.queryDb("INSERT INTO neza4283.Gamintojas VALUES "
                    + "('" + bufRead.readLine() + "','" + bufRead.readLine()
                    + "'," + bufRead.readLine() + "," + bufRead.readLine() + ")");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    private void pridetiAutomobili(BufferedReader bufRead, WorkSQL db) {
        System.out.println("Iveskite automobilio koda, gamintoja, modeli"
                + " variklio galinguma ir pagaminimo metus");

        try {
            db.queryDb("INSERT INTO neza4283.Automobilis VALUES "
                    + "('" + bufRead.readLine() + "','" + bufRead.readLine()
                    + "','" + bufRead.readLine() + "'," + bufRead.readLine() + ",'" + bufRead.readLine()+"')");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    private void Gamintojai(WorkSQL db)
    {
        List<List> result = new LinkedList<List>();
        try {
            result = db.queryDb("SELECT * FROM neza4283.Gamintojas");

            System.out.println("Gamintojai:");
            for (int i = 0; i < result.size(); i++) {
                System.out.println((String) result.get(i).get(0) + " " +
                        result.get(i).get(1)+  " " +
                        result.get(i).get(2)+ " " +
                        result.get(i).get(3));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    private void Automobiliai(WorkSQL db)
    {
        List<List> result = new LinkedList<List>();
        try {
            result = db.queryDb("SELECT * FROM neza4283.Automobilis");

            System.out.println("Automobiliai:");
            for (int i = 0; i < result.size(); i++) {
                System.out.println((String) result.get(i).get(0) + " " +
                        result.get(i).get(1)+ " "+result.get(i).get(2) + " "+result.get(i).get(3) + " "+result.get(i).get(4));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    private void Filtrai(WorkSQL db)
    {
        List<List> result = new LinkedList<List>();
        try {
            result = db.queryDb("SELECT * FROM neza4283.Filtras");

            System.out.println("Filtrai:");
            for (int i = 0; i < result.size(); i++) {
                System.out.println((String) result.get(i).get(0) + " " +
                        result.get(i).get(1)+" "+result.get(i).get(2) + " "+result.get(i).get(3));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    private void Taikomumas(WorkSQL db)
    {
        List<List> result = new LinkedList<List>();
        try {
            result = db.queryDb("SELECT * FROM neza4283.FiltroTaikomumas");

            System.out.println("Taikomumai:");
            for (int i = 0; i < result.size(); i++) {
                System.out.println((String) result.get(i).get(0) + " " +
                        result.get(i).get(1));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    private void keistiIndeksa(BufferedReader bufRead, WorkSQL db) {
        List<List> result = new LinkedList<List>();

        try {
            result = db.queryDb("SELECT * FROM neza4283.Gamintojas");

            System.out.println("Gamintojai:");
            for (int i = 0; i < result.size(); i++) {
                System.out.println((String) result.get(i).get(0) + " " +
                        result.get(i).get(1) + " " + result.get(i).get(2) +
                        " " + result.get(i).get(3)+" " + result.get(i).get(3));
            }

            System.out.println("Iveskite gamintojo nauja kainos, kokybes indeksa ir gamintojo pavadinima:");

            result = db.queryDb("UPDATE neza4283.Gamintojas SET Kokybes_Indeksas = " +
                    bufRead.readLine() + ", Kainos_Indeksas = " + bufRead.readLine() + " WHERE Pavadinimas = '" + bufRead.readLine() + "'");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void pridetiFiltra(BufferedReader bufRead, WorkSQL db) {
        System.out.println("Iveskite filtro koda, gamintoja, kategorija"
                + " kieki sandelyje");
        try {
            db.queryDb("INSERT INTO neza4283.Filtras VALUES "
                    + "('" + bufRead.readLine() + "','" + bufRead.readLine()
                    + "','" + bufRead.readLine() + "'," + bufRead.readLine()+")");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    private void TinkantysFiltrai(BufferedReader bufRead, WorkSQL db)
    {
	int nr = 1;
        int choice = 0;
        String carnr = "";
        List<List> result = new LinkedList<List>();
        System.out.println("Pasirinkite kuriam automobiliui tinkamus filtrus norite matyti");
        try {
            result = db.queryDb("SELECT * FROM neza4283.Automobilis");
            for (int i = 0; i < result.size(); i++) {
		System.out.print(nr +". ");
                System.out.println((String) result.get(i).get(0) + " " +
                        result.get(i).get(1) + " " + result.get(i).get(2) +
                        " " + result.get(i).get(3) + " " + result.get(i).get(3));
                nr++;
            }
	    System.out.print(">");
	}catch (Exception e) {
            System.out.println("Erroras: " + e.getMessage());
        }
	    try{
		choice = Integer.parseInt(bufRead.readLine());
		for (int i = 0; i < result.size(); i++) {
               	if((choice - 1) == i)
		       	{
		            carnr = (String)result.get(i).get(0);
		        }
            	}
	    result = db.queryDb("SELECT Kodas from neza4283.FiltroTaikomumas WHERE Auto_Kodas = '"+carnr+"'");
	    for (int i = 0; i < result.size(); i++) {
                System.out.println((String) result.get(i).get(0));
            }
	    
	    }catch (IOException e) {
               System.out.println("Klaida skaitant ivesti");
            }catch (Exception e) {
            System.out.println("Erroras2: " + e.getMessage());
            }

    }
     private void IsimtiDetale(BufferedReader bufRead, WorkSQL db) {
        List<List> result = new LinkedList<List>();
        try {
            result = db.queryDb("SELECT * FROM neza4283.Filtras");
            System.out.println("Filtrai:");
            for (int i = 0; i < result.size(); i++) {
                System.out.println((String) result.get(i).get(0) + " " + 
                        result.get(i).get(1) + " " + result.get(i).get(2) + 
                        " " + result.get(i).get(3));
            }
            System.out.println("Iveskite detales koda:");
            result = db.queryDb("DELETE FROM neza4283.Filtras WHERE Kodas = '" + 
                    bufRead.readLine() +  "'");
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
