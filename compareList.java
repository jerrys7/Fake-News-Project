
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class compareList {
    
    public static void main(String[] args) throws FileNotFoundException, IOException {

    String currentDirectory = System.getProperty("user.dir");
    String fullFileName = currentDirectory + "/mixmilk.in";
    
    FileReader fr = new FileReader(fullFileName);
    BufferedReader f = new BufferedReader(fr);
                                                  // input file name goes above
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("mixmilk.out")));
    
    StringTokenizer st;
    String s;
    s = f.readLine();
    ArrayList <Integer> a = new ArrayList();
    ArrayList <Integer> b = new ArrayList();
    
    while ( s!=null && s.length() > 0){
        st = new StringTokenizer(s);
        a.add(Integer.parseInt(st.nextToken()));    // first integer
        b.add(Integer.parseInt(st.nextToken()));
        s = f.readLine();
    };
    
    f.close();
    fr.close();                             
    out.close();                                  
    }
    
}
