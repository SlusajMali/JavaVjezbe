public class SluzbenikSaltera extends Zaposleni {

	
	
	
	// Atributi
	private int brojObradjenihZahteva;
	private float bonusPoZahtevu;

	
	
	
	
	
	// Geteri i seteri
	public int getBrojObradjenihZahteva() {
	    return brojObradjenihZahteva;
	}
	public float getBonusPoZahtevu() {
	    return bonusPoZahtevu;
	}
	
	
	
	public void setBrojObradjenihZahteva(int brojObradjenihZahteva) {
	    this.brojObradjenihZahteva = brojObradjenihZahteva;
	}
	public void setBonusPoZahtevu(float bonusPoZahtevu) {
	    this.bonusPoZahtevu = bonusPoZahtevu;
	}

	

	
	
	
	// Konstruktori
	public SluzbenikSaltera() {
	    this(null, null, 0, 0, 0);
	}

	public SluzbenikSaltera(String imePrezime, String id, float osnovnaPlata, int brojObradjenihZahteva, float bonusPoZahtevu) {
	    super(imePrezime, id, osnovnaPlata);
	    this.setBrojObradjenihZahteva(brojObradjenihZahteva);
	    this.setBonusPoZahtevu(bonusPoZahtevu);
	}

	
	
	@Override
	public float izracunajPlatu() {
	    return this.getOsnovnaPlata() + this.getBrojObradjenihZahteva() * this.getBonusPoZahtevu();
	}

	
	
	@Override
	public float obracunajTrosak() {
	    return this.izracunajPlatu();
	}

	
	
	@Override
	public String toString() {
	    return "{'klasa': 'SluzbenikSaltera', 'brojObradjenihZahteva': " + getBrojObradjenihZahteva() +
	           ", 'bonusPoZahtevu': " + getBonusPoZahtevu() +
	           ", 'imePrezime': '" + getImePrezime() +
	           "', 'id':'" + getId() +
	           "', 'osnovnaPlata':" + getOsnovnaPlata() + "}";
	}

		
}
