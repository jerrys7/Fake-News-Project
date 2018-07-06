import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class WordCounter extends URLReader{
    
    static void countEachWord(String filename, Map <String, Integer> words)throws FileNotFoundException, IOException{
        // Path filePath = Paths.get(filename);
//        System.out.println(filename);
//        System.out.println(new File(filename).exists());
//        System.out.println(new File("helloworld.txt").getAbsolutePath());
        Scanner file = new Scanner(new File(filename));
        while(file.hasNext()){
            String word = file.next();
//            System.out.println(word);
//this is the part where u want to count it 
//            Integer count = words.get(word);
//            if(count != null)
//                count++;    
//            else 
//                count=1;
//            
//            words.put(word, count);
        
        }
        file.close();
    }

    public static void main(String[] args) throws FileNotFoundException, IOException{
        Map<String, Integer> words = new HashMap<String, Integer>();
        countEachWord(new File("helloworld.txt").getAbsolutePath(), words);
        System.out.println(words);
//        for ((Map.get(Key) entry : words) {
//           if (words.get(key) <= 5)  {
//            words.remove(key);
//           }
//  }
    }
}
