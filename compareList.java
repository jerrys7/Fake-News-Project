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
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        
    //for fake 
    String currentDirectory = System.getProperty("user.dir");
    String fullFileName = currentDirectory + "/fake common 90 words.txt";
    
    FileReader fakeFileReader = new FileReader(fullFileName);
    BufferedReader fakeBufferedReader = new BufferedReader(fakeFileReader);
    //for real
    String currentDirectory1 = System.getProperty("user.dir");
    String fullFileName1 = currentDirectory1 + "/real common 90 words.txt";
    
    FileReader realFileReader = new FileReader(fullFileName1);
    BufferedReader realBufferedReader = new BufferedReader(realFileReader);
    
    // input file name goes above
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("comparedLists.txt")));
    //for fake
    StringTokenizer stf;
    String sf;
    sf = fakeBufferedReader.readLine();
    //initialize fake
    ArrayList <Integer> countFake = new ArrayList();
    ArrayList <String> wordFake = new ArrayList();
    //initialize real
    ArrayList <Integer> countReal = new ArrayList();
    ArrayList <String> wordReal = new ArrayList();
    //adding data to arraylists
    while ( sf!=null && sf.length() > 0){
        stf = new StringTokenizer(sf);
        countFake.add(Integer.parseInt(stf.nextToken())); //first integer
        wordFake.add(stf.nextToken()); //second word
        sf = fakeBufferedReader.readLine();
    }
    
    StringTokenizer str;
    String sr;
    sr = realBufferedReader.readLine();
    
    while ( sr!=null && sr.length() > 0){
    str = new StringTokenizer(sr);
    countReal.add(Integer.parseInt(str.nextToken())); //first integer
    wordReal.add(str.nextToken()); //second word
    sr = realBufferedReader.readLine();
    }
    
    //maps for fake words
     Map <String, Integer> mapFakeWords = new HashMap<>();
    for (int k = 0; k < countFake.size(); k++){
        mapFakeWords.put(wordFake.get(k), countFake.get(k));
    }
    
    //maps for real words
    Map <String, Integer> mapRealWords = new HashMap<>();
    for (int k = 0; k < countReal.size(); k++){
        mapRealWords.put(wordReal.get(k), countReal.get(k));
    }
    
//    for (int k = 0; k < mapRealWords.size(); k++){
//        for(int j = 0; j < mapFakeWords.size(); j++){
//            if(mapFakeWords.containsKey(wordReal.get(k))){
//                out.print(wordReal.get(k));
//                out.println(mapFakeWords.get(wordReal.get(k))-mapRealWords.get(wordReal.get(k)));
//            }else{
//                out.print(wordReal.get(k));
//                out.println();
//            }
//        }
//    }
    Map <String, Integer> combined = new HashMap<>();
    combined.putAll(mapRealWords);
    combined.putAll(mapFakeWords);
    Map <String, Integer> end = new HashMap<>();
    for(String name: combined.keySet()){
        if(mapRealWords.containsKey(name)==false){
            mapRealWords.put(name, 0);
        }
    }
    
    for(String name: combined.keySet()){
        if(mapFakeWords.containsKey(name)==false){
            mapFakeWords.put(name, 0);
        }
    }
    
    for(String name: combined.keySet()){
        end.put(name, mapRealWords.get(name) - mapFakeWords.get(name));
    }   
    
    
    
    for (String name: end.keySet()){
            String key =name;
            String value = end.get(name).toString();  
            System.out.println(key + " " + value);
            out.println(key + " " + value);
    }
    
    System.out.println(countFake);
    System.out.println(wordFake);
    
    fakeBufferedReader.close();
    fakeFileReader.close();    
    realBufferedReader.close();
    realFileReader.close();
    out.close();                                  
    }
    
}
