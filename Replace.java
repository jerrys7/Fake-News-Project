import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Replace {
    
    public static void main (String[] args) throws FileNotFoundException{
        
//        String currentDirectory = System.getProperty("user.dir");
//        System.out.println("Your directory is " + currentDirectory);
//        String fullFileName = currentDirectory + "/abc.txt";
//        System.out.println("The file path is " + fullFileName);
//        
//        FileReader fr = new FileReader(fullFileName);
//        try {
//    Scanner scan = new Scanner(new File("abc.txt"));
//    while(scan.hasNextLine()) {
//        words.add(scan.nextLine());
//    }
//} catch(Exception e).

        String s = UserInput.getString("Enter String");
        
        
        
        String[] arr = s.split(" ");
        for(int k =0; k < arr.length; k++){
            if(arr[k].contains("www.") || arr[k].contains("http://") || arr[k].contains("https")){
                arr[k] = "httpref";
            }
        }
        String hi = null;
        String lol = hi.join(" ", arr); 
        System.out.println(lol); 
//        System.out.println(Arrays.toString(arr));
        
    }
}
