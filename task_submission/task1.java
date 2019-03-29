//This part assumes that all documents are in txt format. My algorithm is also assumes "a" is a different character from "A"

//If the file entered doesn't contain a, nothing will be returtned on the console

//To run code, javac task1.java then java task1

import java.io.*; 
import java.util.*; 

public class task1 {

	public static void main(String [] args) {

		//Scanner to read filenames
		Scanner scanner = new Scanner(System.in);
		// The name of the file to open.
		System.out.println("Enter the file you want to open in required .txt format eg: doc1.txt");
        String fileName = scanner.nextLine();


        //Arraylist that stores files with letter a in it
        ArrayList<String> containsa=new ArrayList<String>();



        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding
            FileReader fileReader = 
                new FileReader(fileName);

            // Always wrap FileReader in BufferedReader
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
            	//check if a exists
            	int isExists = line.indexOf("a");
                
                if(isExists==0){
                	containsa.add(fileName);
                }

            }   

            // Remember to close the file!
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
            
        }

        // Print files with a
        for(String files : containsa) {
            System.out.println(files + " " + "contains a");
        }
	}

}