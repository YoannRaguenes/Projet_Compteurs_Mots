import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Splitter {
	
	Path  listSplits []  = new Path [10];
	
	
	
	public Path[] getListSplits() {
		return listSplits;
	}



	public void splitTextFiles(Path bigFile, int maxRows) throws IOException{
		
		

        int i = 1;
        
        try(BufferedReader reader = Files.newBufferedReader(bigFile)){
            String line = null;
            int lineNum = 1;

            Path splitFile = Paths.get(i + "split.txt");
            listSplits[i]=splitFile;
            BufferedWriter writer = Files.newBufferedWriter(splitFile, StandardOpenOption.CREATE);

            while ((line = reader.readLine()) != null) {

                if(lineNum > maxRows){
                    writer.close();
                    lineNum = 1;
                    i++;
                    splitFile = Paths.get(i + "split.txt");
                    listSplits[i]=splitFile;
                    System.out.println(listSplits);
                    writer = Files.newBufferedWriter(splitFile, StandardOpenOption.CREATE);
                }

                writer.append(line);
                writer.newLine();
                lineNum++;
            }
           
            writer.close();
        }
        
        
}

}
