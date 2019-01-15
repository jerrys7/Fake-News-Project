import java.io.File;
import java.io.FileInputStream; 
import java.io.InputStream;  

import opennlp.tools.postag.POSModel; 
import opennlp.tools.postag.POSSample; 
import opennlp.tools.postag.POSTaggerME; 
import opennlp.tools.tokenize.WhitespaceTokenizer;  

public class PosTaggerExample { 
  
   public static void main(String args[]) throws Exception{ 
    
    //Loading Parts of speech-maxent model      
    String currentDirectory = System.getProperty("user.dir");
    //System.out.println("Your directory is " + currentDirectory);
    String fullFileName = currentDirectory + "/test.txt";
//    InputStream inputStream = new FileInputStream(fullFileName); 
    File f = new File(fullFileName);
    POSModel model = new POSModel(f); 

    //Instantiating POSTaggerME class 
    POSTaggerME tagger = new POSTaggerME(model); 

    String sentence = "Hi welcome to Tutorialspoint"; 

    //Tokenizing the sentence using WhitespaceTokenizer class  
    WhitespaceTokenizer whitespaceTokenizer= WhitespaceTokenizer.INSTANCE; 
    String[] tokens = whitespaceTokenizer.tokenize(sentence); 

    //Generating tags 
    String[] tags = tagger.tag(tokens);

    //Instantiating the POSSample class 
    POSSample sample = new POSSample(tokens, tags); 
    System.out.println(sample.toString()); 
   
   } 
}  