import java.util.*;
import java.io.*;
import javax.xml.bind.DatatypeConverter;
public class AgoiloBase64Input {
    
    public static void main(String[] args)throws Exception {
    	
    	Scanner scan = new Scanner(System.in); //create new scanner
    	ArrayList<String> words = new ArrayList<String>();
		String wor = "";
	
    	System.out.println("Array List");
    	System.out.println("Enter ':q' to stop the program");
    	while(!wor.equals(":q")){ //ends loop when ":q" is entered
    	System.out.print("Enter a string to add in the array: ");
    	wor = scan.next(); //scans the input of user
    	words.add(wor); //adds the input to array
    	System.out.println("Array list: " + words);
    		}
    	System.out.println("Program Succesfully stopped, do you want to save the file or not?   Y=1 N=0"); //ask if wants to save
    	int option;
    	option = scan.nextInt();
    	if(option>2 && option<0){ //when wrote a number more than 2 it will receive an error 
    		System.out.print("Invalid value, please try again");
    		}
    	switch(option){
    		case 1: //save file
    			System.out.print("Enter the desired name of your file: ");
    			String filename = scan.next();
    			
   				filename = filename + ".txt";
   				File input = new File(filename);
   				input.createNewFile();
   				FileWriter write = new FileWriter(filename);
   				String[] string = GetStringArray(words); 
   				String message1 = Arrays.toString(string);
				byte[] message = message1.getBytes("UTF-8");
				String encoded = DatatypeConverter.printBase64Binary(message);
   				write.write(encoded);
   				write.flush();
    			break;
    		case 0: //not save
    			System.out.print("File did not save, please exit program");
    			break;	
    		}
    		
    }
    
	public static String[] GetStringArray(ArrayList<String> arr) //cinvert array to string
    { 
        String str[] = new String[arr.size()]; 
        for (int j = 0; j < arr.size(); j++) { 
            str[j] = arr.get(j); 
        } 
        return str; 
    } 
}
