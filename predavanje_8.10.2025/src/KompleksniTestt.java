import java.util.ArrayList;
import java.util.Scanner;

public class KompleksniTestt {

    public static void main(String[] args) {

        int N, i;
        float re, im;

        Scanner u = new Scanner(System.in);

        KompleksniBroj z1 = new KompleksniBroj(2, 3);
        KompleksniBroj z2 = new KompleksniBroj(5, 7);
        KompleksniBroj z3, z4;
        
        
        z3 = z1.saberi(z2);
        System.out.print("\nNestaticka metoda: ");
        z3.odstampaj();
        
        z4 = KompleksniBroj.saberi(z1, z2);
        System.out.print("\nStaticka metoda: ");
        z4.odstampaj();
        		
        z3 = z1.podijeli(z2);
        z3.odstampaj();

        System.out.print("Unesi broj elemenata niza: ");
        N = u.nextInt();
        
        ArrayList <KompleksniBroj>  x = new ArrayList <KompleksniBroj> ();
        
   

        for (i = 0; i < N; i++) {
            System.out.printf("Unesite %d. elemenat niza (realni i imaginarni dio): ", i + 1);
            re = u.nextFloat();
            im = u.nextFloat();
            x.add(new KompleksniBroj(re, im));
            
        } 

        /*
        System.out.println("Uneseni niz je: \n");
        for(KompleksniBroj a : x) {
			a.odstampaj();
			System.out.print("\n");
		}
        */
        /*
        Scanner ff = new Scanner(new File("C:\\Temp\\Brojevi.txt"));
        while(ff.hasNext()) {
			re = ff.nextFloat();
			im = ff.nextFloat();
			x.add(new KompleksniBroj(re, im));
		}
        ff.close();
        
        
/*
        KompleksniBroj[] x = new KompleksniBroj[N];

        for (i = 0; i < N; i++) {
            System.out.printf("Unesite %d. elemenat niza (realni i imaginarni dio): ", i + 1);
            re = u.nextFloat();
            im = u.nextFloat();
            x[i] = new KompleksniBroj(re, im);
        }
        
        
       KompleksniBroj max = x[0];
     
       
        for(KompleksniBroj a : x) {
			if(max.moduo() < a.moduo()) {
				max = a;
		
        
        for (i = 1; i < N; i++) {
			if(max.moduo() < x[i].moduo()) {
				max = x[i];
		
		System.out.print("Max niza po modulu je: ");
		z3.odrediMaxMin(x, false).odstampaj();
			}
        }
        
        
        System.out.print("\nMin niza po modulu je: ");
        z3.odrediMaxMin(x, true).odstampaj();
        
        
     
        System.out.println("Elementi niza su:");
        for (KompleksniBroj a : x) {
            a.odstampaj();
            System.out.print("\n");
        }
        */
    
    u.close();
    }
}
