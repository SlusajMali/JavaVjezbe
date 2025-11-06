public class Kuvar extends Zaposleni {
	
	
	
    public Kuvar(int id, String ime, String prezime, double plataPoSatu, int ukupanBrojSat) {
        super(id, ime, prezime, plataPoSatu, ukupanBrojSat);
    }
    
    

    @Override
    public double izracunajPlatu() {
        return 1500 + 4 * ukupanBrojSat * plataPoSatu;
    }
}
