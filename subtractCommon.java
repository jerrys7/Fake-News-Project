import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class subtractCommon {
    
    static void subtractMethod(String filename, Map<String, Integer> words)throws FileNotFoundException, IOException{
            Scanner file = new Scanner(new File(filename));
            Set<Map.Entry<String,Integer>> entries = words.entrySet();
            while (file.hasNext()){
                for(Map.Entry<String,Integer> e : entries){
                    if(e.getValue()==5 ||e.getValue()==4||e.getValue()==3||e.getValue()==2||e.getValue()==1 ){
                    words.remove(e.getKey());
                    }   
                }
            }          
    }        
    public static void main(String[] args) throws IOException{
//        Map<String, Integer> words = new HashMap<>();
//        subtractMethod(new File(".txt").getAbsolutePath(), words);
    String s = "{abcdefghijkl}";
    String d = s.substring(1, s.length()-1);
    System.out.println(d);
   
    }
}
    