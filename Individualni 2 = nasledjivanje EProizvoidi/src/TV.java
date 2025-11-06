
public class TV extends EProizvodi {
	
	private double velicinaEkrana;
	
	
	
	
	public TV(String opisPoizvoda, String sifraProizvoda, double uvoznaCijena, double velicinaEkrana) {
		super(opisPoizvoda, sifraProizvoda, uvoznaCijena);
		this.velicinaEkrana = velicinaEkrana;
		
	}



	

	public double getVelicinaEkrana() {
		return velicinaEkrana;
	}

	public void setVelicinaEkrana(double velicinaEkrana) {
		this.velicinaEkrana = velicinaEkrana;
	}




	@Override
	public String toString() {
		return "TV [velicinaEkrana=" + velicinaEkrana + "]";
	}

	
	
	
	
	  @Override
	    public double izracunajMaloprodajnuCijenu() {
	        double cijena = super.izracunajMaloprodajnuCijenu();
	        if (velicinaEkrana > 65.0) cijena *= 1.1; 
	        return cijena;
	    }
	

	
}
