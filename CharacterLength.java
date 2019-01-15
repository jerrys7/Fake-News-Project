import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class CharacterLength{
    
    public static ArrayList wordLengths(ArrayList<String> stuff){
        ArrayList<Integer> lengths = new ArrayList();
        for (int k = 0; k < stuff.size(); k++){
        StringTokenizer st = new StringTokenizer(stuff.get(k));
            for(int i = 0; i < 120 && st.hasMoreTokens(); i++){
                lengths.add(st.nextToken().length());
            }
        }
        
        return lengths;
    }
    public static double mean(ArrayList<Integer> lengths){
        double sum = 0;
        for (int k = 0; k < lengths.size(); k++){
            sum = sum + lengths.get(k);
        }
        double mean = sum/lengths.size();
        return mean;
    }
    
    public static double standardDeviation(ArrayList<Integer> lengths, double mean){
        double SD;
        double top = 0;
        for(Integer hi: lengths){
            top = top + Math.pow((hi - mean), 2);
        }
        SD = Math.sqrt(top/lengths.size());
        return SD;
    }
    
    public static void main(String[] args) throws IOException{
        ScienceFair2018 sf = new ScienceFair2018();
        ArrayList<String> stuff = sf.readFile("/437fake90withoutnan.txt");
        ArrayList<Integer> lengths = wordLengths(stuff);
        double mean = mean(lengths);
        double SD = standardDeviation(lengths, mean);      
        System.out.println(mean);
        System.out.println(SD);
    }
}
