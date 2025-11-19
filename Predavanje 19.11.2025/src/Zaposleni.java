public abstract class Zaposleni implements Trosak {
	
	
	
	
// Atributi klase
	
	
private String imePrezime;
private String id;
private float osnovnaPlata;






// Geteri i seteri


public String getImePrezime() {
    return imePrezime;
}
public String getId() {
    return id;
}
public float getOsnovnaPlata() {
    return osnovnaPlata;
}




public void setImePrezime(String imePrezime) {
    this.imePrezime = imePrezime;
}
public void setId(String id) {
    this.id = id;
}
public void setOsnovnaPlata(float osnovnaPlata) {
    this.osnovnaPlata = osnovnaPlata;
}





public Zaposleni() {
    this(null, null, 0);
    
    
    
    
    
}
public Zaposleni(String imePrezime, String id, float osnovnaPlata) {
    super();
    this.setImePrezime(imePrezime);
    this.setId(id);
    this.setOsnovnaPlata(osnovnaPlata);
}



@Override
public String toString() {
    return "{'klasa': 'Zaposleni', 'imePrezime': '" + getImePrezime() + "', 'id':'" + getId() +
            "', 'osnovnaPlata':='" + getOsnovnaPlata() + "'}";
		}



public abstract float izracunajPlatu();



}



