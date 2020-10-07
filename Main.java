import java.io.*;
import java.util.*;

public class Main {
	
	public static void main (String[] argv) throws IOException
    {
      Hashtable table = new Hashtable();
      BufferedReader entree = new BufferedReader(new FileReader("plushaut.txt"));
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


