
public class EProizvodi {

	
	private String opisPoizvoda;
	private String sifraProizvoda;
	private double uvoznaCijena;
	
	
	
	
	public EProizvodi(String opisPoizvoda, String sifraProizvoda, double uvoznaCijena) {
		super();
		this.opisPoizvoda = opisPoizvoda;
		this.sifraProizvoda = sifraProizvoda;
		this.uvoznaCijena = uvoznaCijena;
	}
	
	
	

	public String getOpisPoizvoda() {
		return opisPoizvoda;
	}
	
	public String getSifraProizvoda() {
		return sifraProizvoda;
	}
	
	public double getUvoznaCijena() {
		return uvoznaCijena;
	}
	
	
	
	
	public void setOpisPoizvoda(String opisPoizvoda) {
		this.opisPoizvoda = opisPoizvoda;
	}
	
	public void setSifraProizvoda(String sifraProizvoda) {
		this.sifraProizvoda = sifraProizvoda;
	}
	
	public void setUvoznaCijena(double uvoznaCijena) {
		this.uvoznaCijena = uvoznaCijena;
	}



	public String toString() {
		return "EProizvodi [opisPoizvoda=" + opisPoizvoda + ", sifraProizvoda=" + sifraProizvoda + ", uvoznaCijena="
				+ uvoznaCijena + "]";
	}
	
	
	
	
	public double izracunajMaloprodajnuCijenu() {
		uvoznaCijena = uvoznaCijena * 1.05 ;
		
		 return uvoznaCijena;
	}
	


	public String getVrstaProizvoda() {
		 return sifraProizvoda.substring(0, 2);
	}
	

}
