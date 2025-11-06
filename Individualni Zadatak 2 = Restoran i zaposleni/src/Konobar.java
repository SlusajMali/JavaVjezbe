public class Konobar extends Zaposleni {
	
	
    private int prekovremeniSati;

    
    public Konobar(int id, String ime, String prezime, double plataPoSatu, int ukupanBrojSat, int prekovremeniSati) {
        super(id, ime, prezime, plataPoSatu, ukupanBrojSat);
        this.prekovremeniSati = prekovremeniSati;
    }
    

    
    
    public int getPrekovremeniSati() { 
    	return prekovremeniSati; 
    }
    
    
    
    
    public void setPrekovremeniSati(int prekovremeniSati) {
    	this.prekovremeniSati = prekovremeniSati; 
    }

    
    
    
    @Override
    public double izracunajPlatu() {
        int redovni = ukupanBrojSat - prekovremeniSati;
        double sedmicnaPlata = redovni * plataPoSatu + prekovremeniSati * plataPoSatu * 1.2;
        return 4 * sedmicnaPlata;
    }
}
