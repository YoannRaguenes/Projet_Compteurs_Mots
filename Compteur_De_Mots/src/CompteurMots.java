
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CompteurMots {
	
	public int run(String fichier) throws IOException {
		File file = new File(fichier); 
	     
	      int nbrLine = 0;            
	      
	      FileReader fr = new FileReader(file);
	       
	      BufferedReader br = new BufferedReader(fr);  
	      String str;
	      
	      while((str = br.readLine()) != null)
	      {
	         
	         nbrLine++;          
	       
	}
	      return nbrLine;  
	      }
	}
