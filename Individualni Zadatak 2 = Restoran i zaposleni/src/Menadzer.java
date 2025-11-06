public class Menadzer extends Zaposleni {
	
	
    private double bonus;

    public Menadzer(int id, String ime, String prezime, double plataPoSatu, int ukupanBrojSat, double bonus) {
        super(id, ime, prezime, plataPoSatu, ukupanBrojSat);
        this.bonus = bonus;
    }
    
    
    
    public double getBonus() { 
    	return bonus; 
    }
    
    
    
    public void setBonus(double bonus) { 
    	this.bonus = bonus; 
    }

    
    
    @Override
    public double izracunajPlatu() {
        return 1300 + 4 * ukupanBrojSat * plataPoSatu + bonus;
    }
}
