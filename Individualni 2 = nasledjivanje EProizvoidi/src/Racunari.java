
public class Racunari extends EProizvodi {

	private String procesor;
	private double memorija;
	
	
	
	public Racunari(String opisPoizvoda, String sifraProizvoda, double uvoznaCijena, String procesor, double memorija) {
		super(opisPoizvoda, sifraProizvoda, uvoznaCijena);
		this.procesor = procesor;
		this.memorija = memorija;
	}



	public String getProcesor() {
		return procesor;
	}

	public double getMemorija() {
		return memorija;
	}


	
	
	
	public void setProcesor(String procesor) {
		this.procesor = procesor;
	}

	public void setMemorija(double memorija) {
		this.memorija = memorija;
	}

	
	


	@Override
	public String toString() {
		return "Racunari [procesor=" + procesor + ", memorija=" + memorija + "]";
	}
	
	
	@Override
    public double izracunajMaloprodajnuCijenu() {
        return super.izracunajMaloprodajnuCijenu() * 1.1; 
    }
	
	
	
}
