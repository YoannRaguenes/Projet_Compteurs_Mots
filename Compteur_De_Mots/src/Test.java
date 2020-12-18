import java.io.*;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
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
	
	
	
	private static String readFile(String path) throws IOException {
		  FileInputStream stream = new FileInputStream(new File(path));
		  try {
		    FileChannel fc = stream.getChannel();
		    MappedByteBuffer bb = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size());
		    /* Instead of using default, pass in a decoder. */
		    
		    return Charset.defaultCharset().decode(bb).toString();
		  }
		  finally {
		    stream.close();
		  }
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
		Hashtable<String, Integer> table8 = new Hashtable<String, Integer>();
		Hashtable<String, Integer> table9 = new Hashtable<String, Integer>();
		Hashtable<String, Integer> table10 = new Hashtable<String, Integer>();
		Hashtable<String, Integer> table11 = new Hashtable<String, Integer>();
		Hashtable<String, Integer> table12 = new Hashtable<String, Integer>();
		Hashtable<String, Integer> table13 = new Hashtable<String, Integer>();
		Hashtable<String, Integer> table14 = new Hashtable<String, Integer>();
		Hashtable<String, Integer> table15 = new Hashtable<String, Integer>();
		
		
		Scanner scanFichier = new Scanner(System.in); 
		
	    System.out.println("Veuillez saisir le fichier que vous voulez traiter");
	    String fichier = scanFichier.nextLine();
	    	    
	    Path chemin = Paths.get(fichier);
	    
	    String replacedTxt = readFile(fichier).replaceAll(",", "");
	    
	    replacedTxt = replacedTxt.replaceAll("\\(","");
	    replacedTxt = replacedTxt.replaceAll("\\)","");
	    	    
	    
	    try (PrintWriter out = new PrintWriter(fichier)) {
	        out.println(replacedTxt);
	    }

	    String document = chemin.toString();
	    
	    
	    Scanner scanThread = new Scanner(System.in);
	    
	    System.out.println("Combien de thread voulez vous utiliser ? (max 8 - et pair)");
	    int threads = scanThread.nextInt();
	    
	    int lignes = compteur.run(document);
	    
	    int lignesMax = lignes/threads;
	    
	    split.splitTextFiles(chemin,lignesMax);
	    
	    
	    
	    
	    if (threads == 2) {
	    	Map thread1 = new Map(table0,table1,"1split.txt");
		    thread1.start();
		    
		    Map thread2 = new Map(table2,table3,"2split.txt");
		    thread2.start();
		    
	    }else if(threads == 4){
	    	Map thread1 = new Map(table0,table1,"1split.txt");
		    thread1.start();
		    
		    Map thread2 = new Map(table2,table3,"2split.txt");
		    thread2.start();
		    
		    Map thread3 = new Map(table4,table5,"3split.txt");
		    thread3.start();
		    
		    Map thread4 = new Map(table6,table7,"4split.txt");
		    thread4.start();
		    
	    }else if(threads == 6){
	    	Map thread1 = new Map(table0,table1,"1split.txt");
		    thread1.start();
		    
		    Map thread2 = new Map(table2,table3,"2split.txt");
		    thread2.start();
		    
		    Map thread3 = new Map(table4,table5,"3split.txt");
		    thread3.start();
		    
		    Map thread4 = new Map(table6,table7,"4split.txt");
		    thread4.start();
		    
		    Map thread6 = new Map(table8,table9,"5split.txt");
		    thread6.start();
		    
		    Map thread7 = new Map(table10,table11,"6split.txt");
		    thread7.start();
		    
	    }else if(threads == 8){
	    	Map thread1 = new Map(table0,table1,"1split.txt");
		    thread1.start();
		    
		    Map thread2 = new Map(table2,table3,"2split.txt");
		    thread2.start();
		    
		    Map thread3 = new Map(table4,table5,"3split.txt");
		    thread3.start();
		    
		    Map thread4 = new Map(table6,table7,"4split.txt");
		    thread4.start();
		    
		    Map thread6 = new Map(table8,table9,"5split.txt");
		    thread6.start();
		    
		    Map thread7 = new Map(table10,table11,"6split.txt");
		    thread7.start();
		    
		    Map thread8 = new Map(table12,table13,"7split.txt");
		    thread8.start();
		    
		    Map thread9 = new Map(table14,table15,"8split.txt");
		    thread9.start();
	    }
	    
	    
	    
	    
		ArrayList<Hashtable<String, Integer>> paires = new ArrayList<Hashtable<String, Integer>>();
		ArrayList<Hashtable<String, Integer>> impaires = new ArrayList<Hashtable<String, Integer>>();
		
		paires.add(table0);
		paires.add(table2);
		paires.add(table4);
		paires.add(table6);
		paires.add(table8);
		paires.add(table10);
		paires.add(table12);
		paires.add(table14);


		impaires.add(table1);
		impaires.add(table3);
		impaires.add(table5);
		impaires.add(table7);
		impaires.add(table9);
		impaires.add(table11);
		impaires.add(table13);
		impaires.add(table15);


		
		
		Reduce r = new Reduce(paires);
		r.start();
		r = new Reduce(impaires);
		r.start();		
		r.join();
		System.out.println(table0);
		System.out.println(table1);
		ecritureFichier(table0,table1);
				    
	
}}
