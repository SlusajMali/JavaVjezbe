import java.util.Scanner;

public class TestRestoran {
    public static void main(String[] args) {
    	
    	
        Scanner sc = new Scanner(System.in);
        
        
        
        Restoran r = new Restoran("Bistro 2025", "Glavna 5", "123456789");

        Konobar k1 = new Konobar(1, "Marko", "Markovic", 5.5, 42, 8); 
        
        Kuvar ku1 = new Kuvar(2, "Ana", "Anic", 8.0, 44);                
        
        Menadzer m1 = new Menadzer(3, "Jovan", "Jovanovic", 12.0, 40, 400); 

        Konobar k2 = new Konobar(4, "Sara", "Saric", 6, 36, 2);
        
        Kuvar ku2 = new Kuvar(5, "Ilija", "Ilic", 7.3, 37);

        
     
        r.dodajZaposlenog(k1);
        r.dodajZaposlenog(ku1);
        r.dodajZaposlenog(m1);
        r.dodajZaposlenog(k2);
        r.dodajZaposlenog(ku2);
        
        
        while (true) {
            System.out.println("\nmeny sirr:");
            System.out.println("1  Dodaj zaposlenog");
            System.out.println("2  Prikazi sve zaposlene sa iznosom plata");
            System.out.println("3  Prikazi platu zaposlenog po ID-u");
            System.out.println("4  Obrisi zaposlenog po ID-u");
            System.out.println("5  Ukupni trosak plata restorana");
            System.out.println("6  Izlaz\n");
            System.out.print("Unesi kod opcije: \n");
            int izbor = sc.nextInt();
           
            if (izbor == 6) {
                System.out.println("kraj");
                break;
            }

            
            
            switch (izbor) {
                case 1:
                    System.out.print("unesi tip (konobar/kuvar/menadzer): ");
                    String tip = sc.nextLine().toLowerCase();

                    System.out.print("Unesi ID: ");
                    	int id = sc.nextInt();
                    	sc.nextLine();
                    System.out.print("Ime: ");
                    String ime = sc.nextLine();
                    System.out.print("Prezime: ");
                    String prezime = sc.nextLine();
                    System.out.print("Plata po satu: ");
                    	double plata = sc.nextDouble();
                    System.out.print("Ukupan broj sati (sedmicno): ");
                    	int sati = sc.nextInt();

                    if (tip.equals("konobar")) {
                        System.out.print("Prekovremeni sati (sedmicno): ");
                        int prekovr = sc.nextInt();
                        r.dodajZaposlenog(new Konobar(id, ime, prezime, plata, sati, prekovr));
                    } 
                    
                    else if (tip.equals("kuvar")) {
                        r.dodajZaposlenog(new Kuvar(id, ime, prezime, plata, sati));
                    } 
                    
                    else if (tip.equals("menadzer")) {
                        System.out.print("Bonus: ");
                        double bonus = sc.nextDouble();
                        r.dodajZaposlenog(new Menadzer(id, ime, prezime, plata, sati, bonus));
                    }
                    
                    else {
                        System.out.println("Tip nije prepoznat!");
                    	}
                    
                    	sc.nextLine();
                    	break;

                    	
                    	
                case 2:
                    System.out.println("\nZAPOSLENI I IZNOSI PLATA:");
                    r.obracunajPlate();
                    break;

                    
                case 3:
                    System.out.print("Unesi ID zaposlenog: ");
                    int trazeniId = sc.nextInt();
                    Zaposleni z = r.nadjiZaposlenog(trazeniId);
                    if (z != null) {
                        System.out.println("Podaci zaposlenog:");
                        System.out.println(z);
                        System.out.println("Plata: " + z.izracunajPlatu());
                    }
                    	
                    else {
                        System.out.println("Zaposleni nije pronađen");
                    }
                    
                    break;

                    
                    
                case 4:
                    System.out.print("Unesi ID zaposlenog za brisanje: ");
                    int idBrisanje = sc.nextInt();
                    r.ukloniZaposlenog(idBrisanje);
                    System.out.println("Zaposleni obrisan (ako je uopste ikad i postojao).");
                    break;

                    
                    
                case 5:
                    System.out.println("Ukupni trošak plata restorana: " + r.ukupniTrosakPlata());
                    break;

                default:
                    System.out.println("Nepoznato! Unesi kod od 1 do 6.");
            }
        }
        
        
        sc.close();
        
        
        
    }
}
