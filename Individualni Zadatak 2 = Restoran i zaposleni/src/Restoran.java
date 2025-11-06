import java.util.ArrayList;

public class Restoran {
    private String naziv;
    private String adresa;
    private String pib;
    private ArrayList<Zaposleni> zaposleni;

    
    public Restoran(String naziv, String adresa, String pib) {
        this.naziv = naziv;
        this.adresa = adresa;
        this.pib = pib;
        this.zaposleni = new ArrayList<>();
    }

    
    public String getNaziv() {
    	return naziv; 
    }
    
    public String getAdresa() {
    	return adresa; 
    }
    
    public String getPib() { 
    	return pib; 
    }
    
    public ArrayList<Zaposleni> getZaposleni() {
    	return zaposleni; 
    }
   
    
    
    
    public void setNaziv(String naziv) { 
    	this.naziv = naziv;
    }

    public void setAdresa(String adresa) { 
    	this.adresa = adresa;
    }

    public void setPib(String pib) { 
    	this.pib = pib; 
    }

    public void setZaposleni(ArrayList<Zaposleni> zaposleni) { 
    	this.zaposleni = zaposleni; 
    }
    
    
    
    //metoda za dodavanje novih lica u firmu  
    
    public void dodajZaposlenog(Zaposleni z){
        zaposleni.add(z);
    }

    
    
    //metoda za uklanjanje bjegunaca iz postojanja 
    
    public void ukloniZaposlenog(int id){
    	
        for(int i = 0; i < zaposleni.size(); i++){
            if(zaposleni.get(i).getId() == id) {
                zaposleni.remove(i);
              
                
               break;
            }
        }
    }

    
    //metoda za pronalazenje bjeguncaca po id
    
    public Zaposleni nadjiZaposlenog(int id) {
    	
        for(Zaposleni z : zaposleni){
            if(z.getId() == id) return z;
        }
        
        return null;
    }
    
    
    //racunanje plata
    
    
    public double ukupniTrosakPlata() {
    	
        double suma = 0;
        
        for(Zaposleni z : zaposleni)
            suma += z.izracunajPlatu();
        return suma;
    }


    //obracun za zaposlene 
    
    public void obracunajPlate() {
    	
        System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s%n", "ID", "Ime", "Prezime", "Tip", "Sati", "Prekovremeni", "Bonus", "Plata");
        
        for(Zaposleni z : zaposleni){
        	
            String tip = z.getClass().getSimpleName();
            int prekovremeni = (z instanceof Konobar) ? ((Konobar)z).getPrekovremeniSati() : 0;
            double bonus = (z instanceof Menadzer) ? ((Menadzer)z).getBonus() : 0.0;
            
            System.out.printf("%-15d %-15s %-15s %-15s %-15d %-15d %-15.2f %-15.2f%n", z.getId(), z.getIme(), z.getPrezime(), tip, z.getUkupanBrojSat(), prekovremeni, bonus, z.izracunajPlatu());
        }
    }


	
}
