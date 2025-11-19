 public class Faktura implements Trosak {
	 
	 
	 
        // Atributi
        private String brojFakture;
        private String opis;
        private float iznosBezPDV;
        private float pdvStopa;

        
        
        // Geteri i seteri
        public String getBrojFakture() {
            return brojFakture;
        }
        public String getOpis() {
            return opis;
        }
        public float getIznosBezPDV() {
            return iznosBezPDV;
        }
        public float getPdvStopa() {
            return pdvStopa;
        }
        
        
        
        public void setBrojFakture(String brojFakture) {
            this.brojFakture = brojFakture;
        }
        public void setOpis(String opis) {
            this.opis = opis;
        }
        public void setIznosBezPDV(float iznosBezPDV) {
            this.iznosBezPDV = iznosBezPDV;
        }
        public void setPdvStopa(float pdvStopa) {
            this.pdvStopa = pdvStopa;
        }
    
		
		 
		 
		//Konstruktori
		public Faktura() {
		  this(null, null, 0, 0);
		}
		
		
		
		public Faktura(String brojFakture, String opis, float iznosBezPDV, float pdvStopa) {
		  super();
		  this.setBrojFakture(brojFakture);
		  this.setOpis(opis);
		  this.setIznosBezPDV(iznosBezPDV);
		  this.setPdvStopa(pdvStopa);
		}
		
		
		
		
		@Override
		public float obracunajTrosak() {
		  return this.getIznosBezPDV() + this.getIznosBezPDV() * this.getPdvStopa() / 100;
		}




		@Override
		public String toString() {
		  return "{'klasa': 'Faktura', 'brojFakture':'" + getBrojFakture() + "', 'opis':'" + getOpis()
		          + "', 'iznosBezPDV':" + getIznosBezPDV() + ", 'pdvStopa':" + getPdvStopa() + "}";
		}

 }
