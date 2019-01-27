
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class contraction {
    
    static ArrayList<Integer> indexOfAll(Object obj, ArrayList list){
    ArrayList<Integer> indexList = new ArrayList<>();
    for (int i = 0; i < list.size(); i++)
        if(obj.equals(list.get(i)))
            indexList.add(i);
    return indexList;
    }
    
    public static void main(String[] args) throws Exception {
        System.setOut(new PrintStream("C:/Users/congs/Documents/NetBeansProjects/taggers/realWithContractions.txt"));
        String currentDirectory = System.getProperty("user.dir");
        //System.out.println("Your directory is " + currentDirectory);
        String fullFileName = currentDirectory + "/447 real 90 without nan.txt";
        //System.out.println("The file path is " + fullFileName);
            
        FileReader fr = new FileReader(fullFileName);
        BufferedReader br = new BufferedReader(fr);
        
        ArrayList<String> text = new ArrayList();
        String line = "";
        while ((line = br.readLine()) != null){
            //System.out.println("Just read: " + line);&
            text.add(line);
        }
        br.close();
        String[] contractions = {"t","s", "ve", "ll", "d", "m", "re"};
        for (int k = 0; k < text.size(); k++){
            line = text.get(k);
            String santilizedText = line;
            for(String contraction : contractions) {
                String token = " " + contraction + " ";
                String replacement = "'" + contraction + " ";
                santilizedText = santilizedText.replaceAll(token, replacement);
                token = " " + contraction + "\\b";
                replacement = "'" + contraction;
                santilizedText = santilizedText.replaceAll(token, replacement);
            }
            System.out.println(santilizedText);
        }
    }
}
