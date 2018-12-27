import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class firstSixty {
    public static void main(String[] args) throws Exception {
        
        String currentDirectory = System.getProperty("user.dir");
        //System.out.println("Your directory is " + currentDirectory);
        String fullFileName = currentDirectory + "/cleanedrealnews447.txt";
        //System.out.println("The file path is " + fullFileName);
            
        FileReader fr = new FileReader(fullFileName);
        BufferedReader br = new BufferedReader(fr);
        
        ArrayList<String> stuff = new ArrayList();
        String line = "";
        while ((line = br.readLine()) != null){
            //System.out.println("Just read: " + line);&
            stuff.add(line);
        }
        br.close();
        //int total = 0;
        for (int k = 0; k < stuff.size(); k++){
            
            StringTokenizer st = new StringTokenizer(stuff.get(k));
            for(int i = 0; i < 120 && st.hasMoreTokens(); i++){
                System.out.print(st.nextToken() + " ");
            }
            System.out.println("");
        
            
        }
    }
 
        
}
