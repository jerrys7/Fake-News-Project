import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList; 
public class ReadAndWrite {
    static ArrayList<String> stuff = new ArrayList();
    
    public static void main(String[] args) throws Exception{
        //get the thing
        String currentDirectory = System.getProperty("user.dir");
        System.out.println("Your directory is " + currentDirectory);
        String fullFileName = currentDirectory + "/helloworld.txt";
        System.out.println("The file path is " + fullFileName);
        
        FileReader fr = new FileReader(fullFileName);
        BufferedReader br = new BufferedReader(fr);
        
        ArrayList<String> stuff = new ArrayList();
        String line = "";
        while ((line = br.readLine()) != null){
            System.out.println("Just read: " + line);
            stuff.add(line);
        }
        br.close();
        
        for (int k = 0; k < stuff.size(); k++){
            System.out.println("Stuff index " + k  + " is " + stuff.get(k));
        }
        //url thingy
//        try{  
//        //first thing
//        URL url=new URL(stuff.get(0));  
//  
//        System.out.println("Protocol: "+url.getProtocol());  
//        System.out.println("Host Name: "+url.getHost());  
//        System.out.println("Port Number: "+url.getPort());  
//        System.out.println("File Name: "+url.getFile());  
//  
//        }
//        catch(Exception e){System.out.println(e);}  

    


    
    }
    
}
//        String username = UserInput.getString("Enter your username");
//        String password = UserInput.getString("Enter your password");
//        
////        boolean found = false;
//        int m = 0;
//        int k = 0;
//        do {
//            String s1 = stuff.get(k);
//            String p1 = stuff.get(k+1);         
//            if (username.equals(s1) && password.equals(p1)){
//                m = 1;
//            }else {
//                m = 2;
//            }
//            k = k + 2; 
//        }while((m == 2) && (k < stuff.size()-1));
//        if (m == 1){
//            System.out.println("You May Pass!");
//        }else{
//            System.out.println("Bad username or password.");
//        }