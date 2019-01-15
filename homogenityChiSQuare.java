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
public class homogenityChiSQuare {
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        
    //for fake 
    String currentDirectory = System.getProperty("user.dir");
    String fullFileName = currentDirectory + "/fake common 90 words.txt";
    
    FileReader fakeFileReader = new FileReader(fullFileName);
    BufferedReader fakeBufferedReader = new BufferedReader(fakeFileReader);
    //for real
    String currentDirectory1 = System.getProperty("user.dir");
    String fullFileName1 = currentDirectory1 + "/real without function.txt";
    
    FileReader realFileReader = new FileReader(fullFileName1);
    BufferedReader realBufferedReader = new BufferedReader(realFileReader);
    
    // input file name goes above
    PrintWriter fake = new PrintWriter(new BufferedWriter(new FileWriter("fake shared without function words.txt")));
    PrintWriter real = new PrintWriter(new BufferedWriter(new FileWriter("real shared without function words.txt")));
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
    //initialize without function words for 90 words 
    ArrayList <String> wordFunction90 = new ArrayList();
    //adding data to arraylists
    while ( sf!=null && sf.length() > 0){
        stf = new StringTokenizer(sf);
        countFake.add(Integer.parseInt(stf.nextToken())); //first integer
        wordFake.add(stf.nextToken()); //second word
        sf = fakeBufferedReader.readLine();
    }
    
    StringTokenizer str;
    String sr = realBufferedReader.readLine();
    
    while ( sr!=null && sr.length() > 0){
    str = new StringTokenizer(sr);
    countReal.add(Integer.parseInt(str.nextToken())); //first integer
    wordReal.add(str.nextToken()); //second word
    sr = realBufferedReader.readLine();
    }
    
    StringTokenizer stc;
    String sc = realBufferedReader.readLine();
    
    while ( sc!=null && sc.length() > 0){
    stc = new StringTokenizer(sf);
    wordFunction90.add(stc.nextToken()); //word
    sc = realBufferedReader.readLine();
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
    
    Map <String, Integer> mapFakeWordsShared = new HashMap<>();
    Map <String, Integer> mapRealWordsShared = new HashMap<>();
    
    for (String temp: mapRealWords.keySet()){
        if(mapFakeWords.containsKey(temp)){
            mapFakeWordsShared.put(temp, mapFakeWords.get(temp));
            mapRealWordsShared.put(temp, mapRealWords.get(temp));
        }
    }
    
    for (String name: mapRealWordsShared.keySet()){
        String key =name;
        String value = mapRealWordsShared.get(name).toString();  
        System.out.println(key + " " + value);
        real.println(key + " " + value);
    }
    
    for (String name: mapFakeWordsShared.keySet()){
        String key =name;
        String value = mapFakeWordsShared.get(name).toString();  
        System.out.println(key + " " + value);
        fake.println(key + " " + value);
    }
    
    
    
    fakeBufferedReader.close();
    fakeFileReader.close();    
    realBufferedReader.close();
    realFileReader.close();
    fake.close();   
    real.close();
    
    }
}
