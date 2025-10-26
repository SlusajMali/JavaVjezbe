package com.udg.edu.me;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentTest {

	
	public
	static 
	void main(String[] args) 
	throws IOException {



	Student.setProlazNaIspitu(50);



	Student 
	s1 = new Student("Marko",
	"Markovic", "25/001",
	"Oktoih 1, 81000 Podgorica", 65);


	System.out.println(s1.toString());



	s1.setBrojBodova(23);


	System.out.println(s1.toString());



	ArrayList<Student> 
	x = new ArrayList<Student>();


	/*


	x.add(new Student("Marko",
	 "Markovic", "25/001", "Oktoih
	 1, 81000 Podgorica", 65));


	x.add(new Student("Marko",
	 "Marinkovic", "25/001", "Njegoseva
	 3, 81000 Podgorica", 92));


	x.add(new Student("Maja",
	 "Markovic", "25/101", "oktoih
	 1, 81400 Niksic", 11));


	x.add(new Student("Marko",
	 "Nikolic", "25/301", "Oktoih
	 1, 81000 Cetinje", 34));


	x.add(new Student("Majda",
	 "Markovic", "25/021", "Janka
	Djonovica 1, 81000
	Podgorica", 48));


	*/



	String 
	ime, prezime, 
	brojIndeksa, adresa;


	float
	brojBodova;


	int
	poz, poz1;


	Scanner 
	u = new Scanner(new File("C:\\Temp\\StudentiNovi.txt"));


	while(u.hasNext()) {


	String 
	linija = u.nextLine();


	poz =
	linija.indexOf("|");


	ime =
	linija.substring(0, 
	poz);


	poz1 =
	linija.indexOf("|",
	poz + 1);


	prezime =
	linija.substring(poz + 1,
	poz1);


	poz =
	poz1;


	poz1 =
	linija.indexOf("|",
	poz + 1);


	brojIndeksa =
	linija.substring(poz + 1,
	poz1);


	poz =
	poz1;


	poz1 =
	linija.indexOf("|",
	poz + 1);


	adresa =
	linija.substring(poz + 1,
	poz1);


	brojBodova = Float.parseFloat(linija.substring(poz1 + 1));



	x.add(new Student(ime,
	prezime, brojIndeksa,
	adresa, brojBodova));



	}



	/*


	Scanner u = new Scanner(new File("C:\\Temp\\StudentiNovi.txt"));


	u.useDelimiter("[|\n]");


	while(u.hasNext()) {


	System.out.println("Tu");


	ime
	 = u.next();


	prezime
	 = u.next();


	brojIndeksa = u.next();


	adresa
	 = u.next();


	brojBodova = Float.parseFloat(u.next());


	x.add(new Student(ime,
	prezime, brojIndeksa,
	adresa, brojBodova));


	}


	*/



	u.close();



	ArrayList<Student> 
	izdvojeno = Student.izdvojUlica(x,
	"Oktoih");


	System.out.println("Studenti iz ulice Oktoih:");


	for(Student
	s: izdvojeno)


	System.out.println(s.toString());










	ArrayList<Student> 
	izdvojenoPolozili = Student.izdvojProlazNaIspitu(x,
	true);


	BufferedWriter 
	upis = new BufferedWriter(new FileWriter("C:\\Temp\\Polozili.txt"));






	System.out.println("Polozili:");


	for(Student
	s: izdvojenoPolozili) {


	System.out.println(s.toString());


	upis.write(s.toString());


	upis.write("\n");


	}



	upis.close();



	ArrayList<Student> 
	izdvojenoNisuPolozili = Student.izdvojProlazNaIspitu(x,
	false);


	System.out.println("Nisu polozili:");


	for(Student
	s: izdvojenoNisuPolozili)


	System.out.println(s.toString());


	

	}






	}