import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.StringTokenizer;
import java.util.Scanner;

public class Test   {
	
	

	
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
		
	   
		new Thread(new MonThread2()).start();
		new Thread(new MonThread3()).start();
		new Thread(new MonThread4()).start();
		new Thread(new MonThread5()).start();
		
	    
	    
		
		Hashtable table = new Hashtable();
	      BufferedReader entree = new BufferedReader(new FileReader("1split.txt"));
	      String ligne;
	      StringTokenizer st;
	      String mot;
	      int nbOcc;
		
		
		
		
		while ((ligne = entree.readLine()) != null)
		{
		  st = new StringTokenizer(ligne, " ,.;:_-+*/\\.;\n\"'{}()=><\t!?");
		  while(st.hasMoreTokens())
		    {
		      mot = st.nextToken();
		      if (table.containsKey(mot))
			{
			  nbOcc = ((Integer)table.get(mot)).intValue();
			  nbOcc++;
			}
		      
		      
		      else nbOcc = 1;
		      table.put(mot, new Integer(nbOcc));
		    }
		  
		}
	      

	      Enumeration lesMots = table.keys();
	      while (lesMots.hasMoreElements())
		{
	      	  
		  mot = (String)lesMots.nextElement();
		  nbOcc = ((Integer)table.get(mot)).intValue();
		  System.out.println("Le mot " + mot + " figure " +
				     nbOcc + " fois");
		}
	      entree.close();
	    
		
		
		
		
		
		
		
		
		
}
	
	
	
}
