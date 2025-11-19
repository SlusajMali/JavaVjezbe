

public class TehnickaPodrska extends Zaposleni  {
	
	
	
	
    // Atributi
	
	
    private int brojRijesenihTiketa;
    private float koeficijentUcinka;

    
    
    
    
    
    // Geteri i seteri
    
    
    public int getBrojRijesenihTiketa() {
        return brojRijesenihTiketa;
    }
    public float getKoeficijentUcinka() {
        return koeficijentUcinka;
    }
    
    
    
    public void setBrojRijesenihTiketa(int brojRijesenihTiketa) {
        this.brojRijesenihTiketa = brojRijesenihTiketa;
    }
   
    public void setKoeficijentUcinka(float koeficijentUcinka) {
        this.koeficijentUcinka = koeficijentUcinka;
    }
    
    
    

    // Konstruktori
    public TehnickaPodrska() {
        this(null, null, 0, 0, 0);
    }
    public TehnickaPodrska(String imePrezime, String id, float osnovnaPlata, int brojRijesenihTiketa, float koeficijentUcinka) {
        super(imePrezime, id, osnovnaPlata);
        this.setBrojRijesenihTiketa(brojRijesenihTiketa);
        this.setKoeficijentUcinka(koeficijentUcinka);
    }

    
    
    
    @Override
    public float obracunajTrosak() {
        return this.izracunajPlatu();
    }
    
    
    
    @Override
    public float izracunajPlatu() {
        return this.getOsnovnaPlata() * this.getKoeficijentUcinka();
    }
    
    
    @Override
    public String toString() {
        return "{'klasa': 'TehnickaPodrska', 'brojRijesenihTiketa': " + getBrojRijesenihTiketa() +
                ", 'koeficijentUcinka': " + getKoeficijentUcinka() +
                ", 'imePrezime': '" + getImePrezime() +
                "', 'id': '" + getId() + "'}";
    }
}

