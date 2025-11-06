
public class Telefoni extends EProizvodi {

	private String operativniSistem;
	private double ekranVelicina;
	
	
	
	public Telefoni(String opisPoizvoda, String sifraProizvoda, double uvoznaCijena, String operativniSistem, double ekranVelicina) {
		super(opisPoizvoda, sifraProizvoda, uvoznaCijena);
		this.operativniSistem = operativniSistem;
		this.ekranVelicina = ekranVelicina;
	}



	public String getOperativniSistem() {
		return operativniSistem;
	}

	public double getEkranVelicina() {
		return ekranVelicina;
	}




	public void setOperativniSistem(String operativniSistem) {
		this.operativniSistem = operativniSistem;
	}

	public void setEkranVelicina(double ekranVelicina) {
		this.ekranVelicina = ekranVelicina;
	}

	
	
	  @Override
	    public double izracunajMaloprodajnuCijenu() {
	        double cijena = super.izracunajMaloprodajnuCijenu();
	        if (ekranVelicina > 6.0) cijena *= 1.03; 
	        return cijena;
	    }
	
	
}
