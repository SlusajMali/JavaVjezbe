public class Menadzer extends Zaposleni  {
  
	
	
	
	// Atributi
    private float koeficijentOdgovornosti;

    
    
    
    
    // Geteri i seteri
    public float getKoeficijentOdgovornosti() {
        return koeficijentOdgovornosti;
    }

    public void setKoeficijentOdgovornosti(float koeficijentOdgovornosti) {
        this.koeficijentOdgovornosti = koeficijentOdgovornosti;
    }

    
  
    
    
 // Konstruktori
    public Menadzer() {
        this(null, null, 0, 0);
    }

    public Menadzer(String imePrezime, String id, float osnovnaPlata, float koeficijentOdgovornosti) {
        super(imePrezime, id, osnovnaPlata);
        this.setKoeficijentOdgovornosti(koeficijentOdgovornosti);
    }

    
    
    
    @Override
    public float obracunajTrosak() {
        return this.izracunajPlatu();
    }

    
    
    @Override
    public float izracunajPlatu() {
        return this.getOsnovnaPlata() * this.getKoeficijentOdgovornosti();
    }

    
    
    
    @Override
    public String toString() {
        return "{'klasa': 'Menadzer', 'koeficijentOdgovornosti': " + getKoeficijentOdgovornosti() +
               ", 'imePrezime': '" + getImePrezime() +
               "', 'id': '" + getId() + "', 'osnovnaPlata': " + getOsnovnaPlata() + "}";
    }

   
}