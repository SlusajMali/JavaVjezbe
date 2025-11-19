import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
    	
    	
        ArrayList<Trosak> x = new ArrayList<Trosak>();
        
        float ukupniTrosak = 0;

        
        
        x.add(new Menadzer("Ana Anic", "M001", 2000, (float) 1.3));
        x.add(new SluzbenikSaltera("Ivan Ivic", "S002", 1200, 40, 18));
        x.add(new Menadzer("Mira Miric", "M002", 2300, (float) 1.6));
        x.add(new TehnickaPodrska("Petar Peric", "T003", 900, 22, (float) 1.4));
        x.add(new Faktura("F001", "Nabavka opreme", 380, 21));

        
        
        for (Trosak t : x)
            ukupniTrosak += t.obracunajTrosak();

        
        
        System.out.printf("Ukupni trosak je %.2f EUR", ukupniTrosak);
    }
}
