import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CompteurMots {
	
	public int run(String fichier) throws IOException {
		File file = new File(fichier); 
	      // Initialiser le compteur à zéro
	      int nbrLine = 0;            
	      // Créer l'objet File Reader
	      FileReader fr = new FileReader(file);
	      // Créer l'objet BufferedReader 
	      BufferedReader br = new BufferedReader(fr);  
	      String str;
	      // Lire le contenu du fichier
	      while((str = br.readLine()) != null)
	      {
	         //Pour chaque ligne, incrémentez le nombre de lignes
	         nbrLine++;          
	       
	}
	      return nbrLine;  
	      }
	}


