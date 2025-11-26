
public class Razlomak {

	private int brojilac;
	private int imenilac;
	
	
	
	public Razlomak () {
		this(0,1);
	}
	
	public Razlomak(int brojilac, int imenilac) {
		super();
		this.setBrojilac( brojilac);
		this.setImenilac (imenilac);
		this.skrati();
	}
	
	
	
	
	public int getBrojilac() {
		return brojilac;
	}
	public void setBrojilac(int brojilac) {
		this.brojilac = brojilac;
		this.skrati();
	}
	public int getImenilac() {
		return imenilac;
	}
	public void setImenilac(int imenilac) {
		this.imenilac = imenilac;
		this.skrati();
	}
	
	
	
	@Override
	public String toString() {
		
		if ((this.getBrojilac() < 0 && this.getImenilac() > 0) || (this.getBrojilac() > 0  && this.getImenilac() < 0)) {
			return String.format("-%d/%d", Math.abs(this.getBrojilac()), Math.abs(this.getImenilac()));
			
		}
		else
			return String.format("%d/%d" , Math.abs(this.getBrojilac()), Math.abs(this.getImenilac()));
	
	}
	
	
	public static Razlomak saberi(Razlomak a, Razlomak b) {
		
	Razlomak rez = new Razlomak();
	rez.setBrojilac(a.getBrojilac() * b.getImenilac() + b.getBrojilac() * a.getImenilac());
	rez.setImenilac(a.getImenilac() * b.getImenilac());
	
	return rez;
	
	}
	
	
	public static Razlomak pomnozi(Razlomak a, Razlomak b) {
		
		Razlomak rez = new Razlomak();
		rez.setBrojilac(a.getBrojilac() * b.getBrojilac());
		rez.setImenilac(a.getImenilac() * b.getImenilac());
		
		return rez;
		
	}
	
	
	
	public static Razlomak podeli(Razlomak a, Razlomak b) {
		
		Razlomak rez = new Razlomak();
		rez.setBrojilac(a.getBrojilac() * b.getImenilac());
		rez.setImenilac(a.getImenilac() * b.getBrojilac());
		
		return rez;
		
	}
	
	public void skrati () {
		
		int a = Math.abs(this.getBrojilac());
		int b = Math.abs(this.getImenilac());
		
		for (int i = 2 ; i <= Math.min(a,b); i++) {
			while(this.getBrojilac() % i == 0 && this.getImenilac() % i == 0) {
				this.setBrojilac(this.getBrojilac() / i);
				this.setImenilac(this.getImenilac() / i);
			}
		}
	}
	
	
	
	
	
}
