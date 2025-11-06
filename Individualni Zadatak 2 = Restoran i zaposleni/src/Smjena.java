import java.util.ArrayList;

public class Smjena {
    private String datum;
    private String pocetak;
    private String kraj;
    private String tipSmjene;
    private ArrayList<Zaposleni> odradili;

    public Smjena(String datum, String pocetak, String kraj, String tipSmjene) {
        this.datum = datum;
        this.pocetak = pocetak;
        this.kraj = kraj;
        this.tipSmjene = tipSmjene;
        this.odradili = new ArrayList<>();
    }
    
    
    public String getDatum() { 
    	return datum; 
    }
    
    public String getPocetak() {
    	return pocetak; 
    }
    
    public String getKraj() { 
    	return kraj; 
    }
    
    public String getTipSmjene() {
    	return tipSmjene;
    }
    
    public ArrayList<Zaposleni> getOdradili() { 
    	return odradili;
    }
    
    
    
    
    
    public void setDatum(String datum) { 
    	this.datum = datum; 
    }

    public void setPocetak(String pocetak) { 
    	this.pocetak = pocetak; 
    }

    public void setKraj(String kraj) { 
    	this.kraj = kraj; 
    }

    public void setTipSmjene(String tipSmjene) { 
    	this.tipSmjene = tipSmjene; 
    }

    public void setOdradili(ArrayList<Zaposleni> odradili) {
    	this.odradili = odradili;
    }
    
    public void dodajZaposlenog(Zaposleni z) {
        odradili.add(z);
    }

    
    
}
