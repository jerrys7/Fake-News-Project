import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Matrice {
    
    public static void main(String[] args) throws FileNotFoundException, IOException{



        //get the path of the words
        String currentDirectory = System.getProperty("user.dir");
        System.out.println("Your directory is " + currentDirectory);
        String fullFileName = currentDirectory + "/5000words.txt";
        System.out.println("The file path is " + fullFileName);
        
        FileReader fr = new FileReader(fullFileName);
        BufferedReader br = new BufferedReader(fr);
        //read the file of words      
        ArrayList<String> words = new ArrayList();
        String line = "";
        while ((line = br.readLine()) != null){
            //System.out.println("Just read: " + line);
            words.add(line);
        }
        br.close();
        //get the path of the number of articles 
        int wordSize = words.size();
        
        //get the path of the websties
        String websitesFile = System.getProperty("user.dir");
        System.out.println("Your directory is " + currentDirectory);
        String websitesFileName = websitesFile + "/fakeStemmedFinal.txt";
        System.out.println("The file path is " + websitesFileName);
        
        FileReader fr1 = new FileReader(websitesFileName);
        BufferedReader br1 = new BufferedReader(fr1);
        
        ArrayList<String> links = new ArrayList();
        String newLine = "";
        while ((newLine = br1.readLine()) != null){
            //System.out.println("Just read: " + line);&
            links.add(newLine);
            //System.out.println("Printing new Line" + newLine);
        }
        br1.close();
        
        int linkSize = links.size();
//create a 1019 by 20432 ? smt like that 
        int matrix[][] = new int[linkSize][wordSize+1];
        //loop through every single article  k = number of articles 
        PrintWriter out = new PrintWriter("pseudoRealTraining501.csv");
        System.out.println(wordSize);
        for (int k = 0; k < 100; k++){
            System.out.println(String.format("%d out of total %d is processed", k+1, linkSize));
            //get the article
            //Document doc = Jsoup.connect(links.get(k)).get();
            //String s = doc.getElementsByTag("p").text();
            String s = links.get(k);
            String wordsInWebSite[] = s.split(" ");

            for (int m = 0; m < wordsInWebSite.length; m++){
                int index = words.indexOf(wordsInWebSite[m]);
                    if (index >= 0) 
                    matrix[k][index] = 1;
            }     
            //for real news = 1, fake news = 0
            matrix[k][wordSize] = 1;
            String temp = Arrays.toString(matrix[k]);
            temp = temp.substring(1, temp.length()-1);
            out.println(temp);

        }
        
    }    
}
