import java.util.ArrayList;
import java.util.Scanner;

public class MainZaStampanje {
    public static void main(String[] args) {
    	
        Scanner unos = new Scanner(System.in);
        ArrayList<EProizvodi> proizvodi = new ArrayList<>();

        System.out.println("Sada cete dobiti kodove za vas izbor zahtjeva , pazljivo odaberite opcije 1. 2. ili 3. :   \n");

        while (true) {
            System.out.println("1 Unos uređaja");
            System.out.println("2 Pregled svih uređaja sa maloprodajnom cijenom");
            System.out.println("3 Pregled uređaja određenog tipa");
            System.out.println("0 Izlaz\n");
            System.out.print("Izbor: \n");

            int izbor = unos.nextInt();
            unos.nextLine(); 

            if (izbor == 0) break;

            if (izbor == 1) {
                System.out.print("Unesi opis: ");
                String opis = unos.nextLine();
                System.out.print("Unesi sifru (npr. RA01, TE23, TV96): ");
                String sifra = unos.nextLine();
                System.out.print("Unesi uvoznu cijenu: \n");
                double cijena = unos.nextDouble();
               
                
                String VrstaProizvoda = sifra.substring(0, 2);
                	
                	
                if (VrstaProizvoda.equalsIgnoreCase("RA")) {
                    System.out.print("unesi procesor: \n");
                    String proc = unos.nextLine();
                    System.out.print("unesi memoriju: \n");
                    int mem = unos.nextInt();
                    unos.nextLine();
                    proizvodi.add(new Racunari(opis, sifra, cijena, proc, mem));
                } 
                
                
                else if (VrstaProizvoda.equalsIgnoreCase("TE")) {
                    System.out.print("unesi operativni sistem: ");
                    String os = unos.nextLine();
                    System.out.print("unesi velicinu ekrana: ");
                    double velicinaEkrana = unos.nextDouble();
                    unos.nextLine();
                    proizvodi.add(new Telefoni(opis, sifra, cijena, os, velicinaEkrana));
                } 
                
                
                else if (VrstaProizvoda.equalsIgnoreCase("TV")) {
                    System.out.print("unesi velicinu ekrana: ");
                    double velicinaEkrana = unos.nextDouble();
                    unos.nextLine();
                    proizvodi.add(new TV(opis, sifra, cijena, velicinaEkrana));
                } 
                
                
                else {
                    System.out.println("nepoznata sifra ");
                }
                
                
            } 
            
            else if (izbor == 2) {
                for (EProizvodi p : proizvodi) {
                    System.out.println(p + ", maloprodajna cijena: " + p.izracunajMaloprodajnuCijenu());
                }
                
            }
            else if (izbor == 3) {
                System.out.print("unesi tip uredjaja (RA/TE/TV): ");
                String tip = unos.nextLine();
                for (EProizvodi p : proizvodi) {
                    if (p.getVrstaProizvoda().equalsIgnoreCase(tip)) {
                        System.out.println(p + ", maloprodajna cijena: " + p.izracunajMaloprodajnuCijenu());
                    }
                }
            }
            
        }
        unos.close();
    }
}
