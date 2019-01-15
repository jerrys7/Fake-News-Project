import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


public class compareList {
    
    
    public static <K, V> Map<K, V> mapDifference(Map<? extends K, ? extends V> left, Map<? extends K, ? extends V> right) {
    Map<K, V> difference = new HashMap<>();
    difference.putAll(left);
    difference.putAll(right);
    difference.entrySet().removeAll(right.entrySet());
    return difference;
    }
    
//    public static <String, Integer> Map<String,Integer> nulltoZero(Map<String, Integer> left, Map<String, Integer> right){
//        Map <String, Integer> zero = new HashMap<>();
//        int ling = 0;
//        Integer ero = new Integer("ling");
//        for(String word: left.keySet()){
//            if(right.containsKey(word) == false){
//                zero.put(word, 0);
//            }
//        }
//        
//        return zero;
//    }
    public static Map createMap(String filename) throws FileNotFoundException, IOException{
        String currentDirectory = System.getProperty("user.dir");
        String fullFileName = currentDirectory + filename;
        FileReader fakeFileReader = new FileReader(fullFileName);
        BufferedReader fakeBufferedReader = new BufferedReader(fakeFileReader);
        
        StringTokenizer stf;
        String sf;
        sf = fakeBufferedReader.readLine();
        
        ArrayList <Integer> countFake = new ArrayList();
        ArrayList <String> wordFake = new ArrayList();
        
        while ( sf!=null && sf.length() > 0){
        stf = new StringTokenizer(sf);
        countFake.add(Integer.parseInt(stf.nextToken())); //first integer
        wordFake.add(stf.nextToken()); //second word
        sf = fakeBufferedReader.readLine();
        }
        
        Map <String, Integer> mapFakeWords = new HashMap<>();
        for (int k = 0; k < countFake.size(); k++){
        mapFakeWords.put(wordFake.get(k), countFake.get(k));
        }
        fakeBufferedReader.close();
        fakeFileReader.close();
        return(mapFakeWords);
        
        
    }
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
    String currentDirectory = System.getProperty("user.dir");
    String fullFileName = currentDirectory + "/397common90 stemmed.txt";    
    FileReader wordFileReader = new FileReader(fullFileName);
    BufferedReader wordBufferedReader = new BufferedReader(wordFileReader); 
    
    StringTokenizer st;
    String s = wordBufferedReader.readLine();
    ArrayList <String> word = new ArrayList();

    while ( s!=null && s.length() > 0){
    st = new StringTokenizer(s);
    word.add(st.nextToken()); //second word
    s = wordBufferedReader.readLine();
    }

    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("fake vs real news comparing frequency of words.txt")));
    
    //maps for fake words
     Map <String, Integer> mapFakeWords = new HashMap<>();
     mapFakeWords = createMap("/fake common 90 words.txt"); 
    //maps for real words
    Map <String, Integer> mapRealWords = new HashMap<>();
    mapRealWords = createMap("/real common 90 words.txt");

    //which word appears more often in the 397 most commonly shared words
    for (int k = 0; k < word.size(); k++){
        if (mapFakeWords.containsKey(word.get(k))&& mapRealWords.containsKey(word.get(k))){
            if (mapFakeWords.get(word.get(k))> mapRealWords.get(word.get(k))){
                out.println("0");
            }else if (mapFakeWords.get(word.get(k)) < mapRealWords.get(word.get(k))){
                out.println("1");
            }else{
                out.println("0.5");
            }
        }else if (mapFakeWords.containsKey(word.get(k)) && mapRealWords.containsKey(word.get(k)) == false){
            out.println("0");
        }else if(mapFakeWords.containsKey(word.get(k)) == false && mapRealWords.containsKey(word.get(k))){
            out.println("1");
        }else{
            out.println("DNEeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeefjakl;fjl0130-18jdkalfkl;0");
        }
    }
    
    
    //finding differences, with 0 as placeholder
//    Map <String, Integer> combined = new HashMap<>();
//    combined.putAll(mapRealWords);
//    combined.putAll(mapFakeWords);
//    
//    for(String name: combined.keySet()){
//        if(mapRealWords.containsKey(name)==false){
//            mapRealWords.put(name, 0);
//        }
//    }
//    
//    for(String name: combined.keySet()){
//        if(mapFakeWords.containsKey(name)==false){
//            mapFakeWords.put(name, 0);
//        }
//    }
//    
//    for(String name: combined.keySet()){
//        end.put(name, mapRealWords.get(name) - mapFakeWords.get(name));
//    }   

//for finding the differences between the two maps
/* 
    Map <String, Integer> end = new HashMap<>();
    end = mapDifference(mapFakeWords, mapRealWords);
    
    for (String name: end.keySet()){
            String key =name;
            String value = end.get(name).toString();  
            System.out.println(key + " " + value);
            out.println(key + " " + value);
    }
*/
    
    out.close();                                  
    }
    
}
