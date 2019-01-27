import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class extractPOS {
    
    public static void main(String[] args) throws Exception {
        System.setOut(new PrintStream("C:/Users/congs/Documents/NetBeansProjects/taggers/ddddddddd.txt"));
        String currentDirectory = System.getProperty("user.dir");
        String fullFileName = currentDirectory + "/realPartsOfSpeech.txt";

        FileReader fr = new FileReader(fullFileName);
        BufferedReader f = new BufferedReader(fr);

        StringTokenizer st;
        String s;
        s = f.readLine();
        ArrayList <String> stuff = new ArrayList();
        while ( s!=null && s.length() > 0){
            st = new StringTokenizer(s);
            while(st.hasMoreTokens()){
                stuff.add(st.nextToken());
            }            
            s = f.readLine();
        };
        for(String k: stuff){
            String replaced = k.replace(k, k.substring(k.indexOf("_")));
            System.out.println(replaced);  
        }
        
        
            
    }
    
}
