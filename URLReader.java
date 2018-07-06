import java.io.BufferedReader;
import java.io.FileReader;
import java.io.StringWriter;
import java.util.ArrayList;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

 
public class URLReader extends ReadAndWrite{
    
	public static void main(String[] args) throws Exception {
 
        String currentDirectory = System.getProperty("user.dir");
        //System.out.println("Your directory is " + currentDirectory);
        String fullFileName = currentDirectory + "/helloworld.txt";
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
        String[] array = new String[23402];
        for (int k = 0; k < stuff.size(); k++){
            //System.out.println("Stuff index " + k  + " is " + stuff.get(k));
            Document doc = Jsoup.connect(stuff.get(k)).get();
            //String s = doc.getElementsByTag("p").text();
//            int spaceCount = 0;
//            for (int l = 0; l < s.length(); l++) {
//                if (s.substring(l,l+1).equals(" ")) {
//                    spaceCount++;
//                }
//            }
//            total = total + spaceCount;
            //System.out.println("The number of words in article " + k + " is " + spaceCount + " and the total so far is " + total);


           String s = doc.getElementsByTag("p").text();
            
           
            //System.out.println(doc.getElementsByTag("p").text());
            //finding the location, deleteing everything before it 
            if (s.indexOf("—")< s.indexOf(".")|| s.indexOf("—") < s.indexOf(";")){
                
                s = s.substring(s.indexOf("—")+1);
            }
            
            System.out.println(s);

        }
        //System.out.println(total);
                
	}   
 
    }