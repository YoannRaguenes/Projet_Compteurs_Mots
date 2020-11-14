import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.StringTokenizer;
import java.util.Scanner;

public class Test {
	
	

	public static void ecritureFichier(Hashtable<String, Integer> table_paire, Hashtable<String, Integer> table_impaire) throws IOException {
		Hashtable<String, Integer> table = new Hashtable<String, Integer>();
		String mot;
		Integer nbOcc;
		Integer cpt = 0;
		FileWriter fw = new FileWriter("fichier_final.txt");
		while (cpt != 2) {
		table = (cpt == 0) ? table_paire : table_impaire;
		Enumeration<String> lesMots = table.keys();
		while (lesMots.hasMoreElements())
		{
			mot = (String)lesMots.nextElement();
			nbOcc = ((Integer)table.get(mot)).intValue();
			String phrase = "Le mot " + mot + " figure " +
					nbOcc + " fois";
			fw.write(phrase + "\n");
		}
		cpt++;
		}

		fw.close();
	}
	
	
	
	
	
	public static void main (String[] argv) throws IOException, InterruptedException
    {
		Splitter split = new Splitter();
		CompteurMots compteur = new CompteurMots();

		
		Hashtable<String, Integer> table0 = new Hashtable<String, Integer>();
		Hashtable<String, Integer> table1 = new Hashtable<String, Integer>();
		Hashtable<String, Integer> table2 = new Hashtable<String, Integer>();
		Hashtable<String, Integer> table3 = new Hashtable<String, Integer>();
		Hashtable<String, Integer> table4 = new Hashtable<String, Integer>();
		Hashtable<String, Integer> table5 = new Hashtable<String, Integer>();
		Hashtable<String, Integer> table6 = new Hashtable<String, Integer>();
		Hashtable<String, Integer> table7 = new Hashtable<String, Integer>();
		
		
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
	    
	    Map thread1 = new Map(table0,table1,"1split.txt");
	    thread1.start();
	    
	    Map thread2 = new Map(table2,table3,"2split.txt");
	    thread2.start();
	    
	    Map thread3 = new Map(table4,table5,"3split.txt");
	    thread3.start();
	    
	    Map thread4 = new Map(table6,table7,"4split.txt");
	    thread4.start();
	    
	    
		ArrayList<Hashtable<String, Integer>> paires = new ArrayList<Hashtable<String, Integer>>();
		ArrayList<Hashtable<String, Integer>> impaires = new ArrayList<Hashtable<String, Integer>>();
		
		paires.add(table0);
		paires.add(table2);
		paires.add(table4);
		paires.add(table6);
		impaires.add(table1);
		impaires.add(table3);
		impaires.add(table5);
		impaires.add(table7);

		
		
		Reduce r = new Reduce(paires);
		r.start();
		r = new Reduce(impaires);
		r.start();		
		r.join();
		System.out.println(table0);
		System.out.println(table1);
		ecritureFichier(table0,table1);
				
	    
	    
		
		
	
	
}}
