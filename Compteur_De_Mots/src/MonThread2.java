import java.io.*;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.StringTokenizer;



public class MonThread2 extends Thread implements Runnable   {
	
	public String partieAMaper;
	public Hashtable listMaps [] = new Hashtable[10];
	
	public Hashtable[] getListMaps() {
		return listMaps;
	}

	@Override
	public void run() {
		
		Hashtable table = new Hashtable();
	      BufferedReader entree = null;
		try {
			entree = new BufferedReader(new FileReader(partieAMaper));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      String ligne;
	      StringTokenizer st;
	      String mot;
	      int nbOcc;
		
		
		
		
		try {
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
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      

	      Enumeration lesMots = table.keys();
	      while (lesMots.hasMoreElements())
		{
	      	  
		  mot = (String)lesMots.nextElement();
		  nbOcc = ((Integer)table.get(mot)).intValue();
		  System.out.println("Le mot " + mot + " figure " +
				     nbOcc + " fois");
		}
	      try {
			entree.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      
	    
		
		
		
		
}

	

	
		
	}


