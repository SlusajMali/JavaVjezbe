import java.util.ArrayList;

public class Zaposleni {
    protected int id;
    protected String ime;
    protected String prezime;
    protected double plataPoSatu;
    protected int ukupanBrojSat;
    
   

    public Zaposleni(int id, String ime, String prezime, double plataPoSatu, int ukupanBrojSat) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.plataPoSatu = plataPoSatu;
        this.ukupanBrojSat = ukupanBrojSat;
    }

    public int getId() { 
    	return id;
    }
    
    public String getIme() { 
    	return ime; 
    }
    
    public String getPrezime() { 
    	return prezime; 
    }
    
    public double getPlataPoSatu() { 
    	return plataPoSatu; 
    }
    
    public int getUkupanBrojSat() { 
    	return ukupanBrojSat; 
    }

  
    
    
   
    
    
    public void setId(int id) { 
    	this.id = id; 
    }
    
    public void setIme(String ime) { 
    	this.ime = ime; 
    }
    
    public void setPrezime(String prezime) { 
    	this.prezime = prezime; 
    }
    
    public void setPlataPoSatu(double plataPoSatu) { 
    	this.plataPoSatu = plataPoSatu; 
    }
    
    public void setUkupanBrojSat(int ukupanBrojSat) { 
    	this.ukupanBrojSat = ukupanBrojSat; 
    }
 
    

    
    
    public double izracunajPlatu() {
        return 0;
    }

    
    
    @Override
    public String toString() {
        return id + " " + ime + " " + prezime + ", sati: " + ukupanBrojSat + ", satnica: " + plataPoSatu;
    }
    
    
   
    
  
    
}
