
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ScienceFair2018 {
    
//    public ScienceFair2018(){
//    
//    return;
//    }
    
    public ArrayList readFile(String filename) throws FileNotFoundException, IOException{
        String currentDirectory = System.getProperty("user.dir");
        String fullFileName = currentDirectory + filename;
        FileReader FileReader = new FileReader(fullFileName);
        BufferedReader BufferedReader = new BufferedReader(FileReader);
        
        ArrayList<String> stuff = new ArrayList();
        ArrayList<Integer> wordLength = new ArrayList();
        String line = "";
        while ((line = BufferedReader.readLine()) != null){
            //System.out.println("Just read: " + line);&
            stuff.add(line);
        }
        BufferedReader.close();
        //int total = 0;
        return(stuff);
    }
       
}







