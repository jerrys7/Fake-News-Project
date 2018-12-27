import java.io.BufferedReader;
import java.io.FileReader;
import java.io.StringWriter;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

 
public class URLReader extends ReadAndWrite{
    
	public static void main(String[] args) throws Exception {
 
            String currentDirectory = System.getProperty("user.dir");
            //System.out.println("Your directory is " + currentDirectory);
            String fullFileName = currentDirectory + "/ultimateRealNews.txt";
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
            String d ="Settings Cancel Set Have an existing account? Already have a subscription? Don't have an account? Get the news Let friends in your social network know what you are reading about"; 
            String f = "Story Continued Below";
            String e = "RIGHT WING TRIBUNE –";
            String g = "RIGHT WING TRIBUNE–";
            String a = "AMERICA’S FREEDOM FIGHTERS –";
            String b = "by The Lapine";
            String z = "Supported by By ";
            String y = "Last Updated Apr";
            String fox = "All rights reserved. All market data delayed 20 minutes.";
        //int total = 0;
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

                if(s.contains(f)){
                    s = s.substring(s.indexOf(f) + 22);
                }else if(s.contains(d)){  
                    s=s.substring(s.indexOf("Get the news Let friends in your social network know what you are reading about")+80);
                }else if (s.contains("�")){
                    s=s.substring(s.indexOf("�")+1);
                }else if (s.contains("WASHINGTON—")){
                    s=s.substring(s.indexOf("WASHINGTON—")+12);    
                }else if(s.contains(e)){
                    s=s.substring(s.indexOf(e) + e.length()+ 1);
                }else if(s.contains(g)){
                    s=s.substring(s.indexOf(g) +g.length() + 1);
                }else if (s.contains("Posted By: Dean James III%")){
                    s=s.substring(s.indexOf("Posted By: Dean James III%") + 41);
                }else if (s.contains("Posted By: Chris Badger Thomas")){
                    s=s.substring(s.indexOf("Posted By: Chris Badger Thomas") + 45);
                }else if (s.contains("Posted By: Prissy Holly")){
                    s=s.substring(s.indexOf("Posted By: Prissy Holly") + 38);
                }else if(s.contains("Please disable your Ad Blocker to better interact with this website.")){
                    s=s.substring(s.indexOf("Please disable your Ad Blocker to better interact with this website.") + 69);
                }else if(s.contains("WASHINGTON, D.C. —")){
                    s=s.substring(s.indexOf("WASHINGTON, D.C. —") + 19);
                }else if(s.contains(a)){
                    s=s.substring(s.indexOf(a) + a.length() +1);
                }else if(s.contains(b)){
                    s=s.substring(s.indexOf(b) +b.length() + 20);
                }else if(s.contains(z)){
                    s=s.substring(s.indexOf(z) + z.length() + 15);
                }else if (s.contains(y)){
                    s=s.substring(s.indexOf(y) +y.length() + 10);
                }else if (s.contains(fox)){
                    s=s.substring(s.indexOf(fox) + fox.length() + 1);
                }else if (s.indexOf("December") == 0){
                    s=s.substring(18);
                }else if(s.indexOf("Keep Me Logged In")==0){
                    s=s.substring(18);
                }else if (s.indexOf("—")< s.indexOf(".")|| s.indexOf("—") < s.indexOf(";")){
                    s = s.substring(s.indexOf("—")+1);
                }
                




                System.out.println(s);

            }
        //System.out.println(total);
                
	}   
 
    }