
import edu.stanford.nlp.tagger.maxent.MaxentTagger;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Taggers {


    public static void main(String[] args) throws IOException, ClassNotFoundException {

        MaxentTagger tagger = new MaxentTagger("taggers/english-left3words-distsim.tagger");

        System.setOut(new PrintStream("C:/Users/congs/Documents/NetBeansProjects/taggers/realPartsOfSpeech.txt"));
        String currentDirectory = System.getProperty("user.dir");
        String fullFileName = currentDirectory + "/realWithContractions.txt";
            
        FileReader fr = new FileReader(fullFileName);
        BufferedReader br = new BufferedReader(fr);
        
        ArrayList<String> stuff = new ArrayList();
        String line = "";
        while ((line = br.readLine()) != null){
            stuff.add(line);
        }
        br.close();
        for (int k = 0; k < stuff.size(); k++){
            String sample = stuff.get(k);
            String tagged = tagger.tagString(sample);
            System.out.println(tagged);

        }
        
//            String sample = "washington";
//            String tagged = tagger.tagString(sample);
//            System.out.println(tagged);




    }
    
}
