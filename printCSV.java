import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class printCSV {
    
    public static void main (String [] args) throws FileNotFoundException, IOException{
        
        String currentDirectory = System.getProperty("user.dir");
        System.out.println(currentDirectory);
        String fullFileName = currentDirectory + "/real shared without function words.txt";
        FileReader fr = new FileReader(fullFileName);
        BufferedReader f = new BufferedReader(fr);
                                                      
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("real shared without function words.csv")));

        StringTokenizer st;
        String s;
        s = f.readLine();
        ArrayList <Integer> a = new ArrayList();
        ArrayList <String> b = new ArrayList();
        while ( s!=null && s.length() > 0){
            st = new StringTokenizer(s);
            b.add(st.nextToken());              
            if(st.hasMoreTokens()){
                 a.add(Integer.parseInt(st.nextToken()));
            }
            s = f.readLine();
        };
        out.println(a);
        
        out.println(b);
        f.close();
        fr.close();
        out.close();
        
    }
}
