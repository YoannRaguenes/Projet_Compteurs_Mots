import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.StringTokenizer;
import java.util.Scanner;

public class Test {
	
	

	
	public static void main (String[] argv) throws IOException
    {
		Splitter split = new Splitter();
		CompteurMots compteur = new CompteurMots();

		
		
		Scanner scanFichier = new Scanner(System.in); 
		
	    System.out.println("Veuillez saisir le fichier que vous voulez traiter");
	    String fichier = scanFichier.nextLine();  
	    Path chemin = Paths.get(fichier);
	    String document = chemin.toString();
	    
	    Scanner scanThread = new Scanner(System.in);
	    
	    System.out.println("Combien de thread voulez vous utiliser ?");
	    int threads = scanThread.nextInt();
	    
	    int lignes = compteur.run(document);
	    
	    int lignesMax = lignes/threads;
	    
	    split.splitTextFiles(chemin,lignesMax);
	    
	    MonThread2 thread1 = new MonThread2();
	    thread1.partieAMaper="1split.txt";
	    thread1.start();
	    
	    MonThread2 thread2 = new MonThread2();
	    thread2.partieAMaper="2split.txt";
	    thread2.start();
	    
	    MonThread2 thread3 = new MonThread2();
	    thread3.partieAMaper="3split.txt";
	    thread3.start();
	    
	    MonThread2 thread4 = new MonThread2();
	    thread4.partieAMaper="4split.txt";
	    thread4.start();
	    
	    MonThread2 thread5 = new MonThread2();
	    thread5.partieAMaper="5split.txt";
	    thread5.start();
	    
	    
		
	   
		//new Thread(new MonThread2()).start();
		//new Thread(new MonThread3()).start();
		//new Thread(new MonThread4()).start();
		//new Thread(new MonThread5()).start();
		
	    
	    
		
		
	
	
}}
