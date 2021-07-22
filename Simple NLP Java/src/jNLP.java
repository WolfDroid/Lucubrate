/**
 * Main Class for simple NLP using Java
 * @author Im Rafid
 * version 12.04.2020
 *
 */

//Library
import java.util.*;
import java.io.*;

public class jNLP {
    //Temporal Variable
    private static String line;
    //Main Class
    public static void main(String[] args) {
        int spamIndicator = 0;
        Scanner scan = new Scanner(System.in);
        //Reading File Name
        System.out.println("Enter a filename ");
        String filename = scan.nextLine();
        //Spam keywords
        System.out.println("Enter a keywords to indicate a spam : ");
        String spamK = scan.nextLine();
        //Opening message feedback
        System.out.println("Opening " + filename);
        try {
            //Reading File
            FileReader fileReader = new FileReader(filename);
            // Reading Every Line
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ( (line = bufferedReader.readLine() ) != null) {
                //New String Tokenizer Object
                StringTokenizer stringT = new StringTokenizer(line, " ");
                while (stringT.hasMoreTokens()) {
                    if(stringT.nextToken().equals(spamK)) {
                        spamIndicator += 1;
                    } else {
                        spamIndicator += 0;
                    }
                }
            }
            if ( spamIndicator >= 3 ){
                System.out.println("This is a Spam!");
            } else {
                System.out.println("It's safe not a Spam!");
            }
            bufferedReader.close();
        } catch(IOException e) {
            System.out.println("Error reading file '" + filename + "'");
        }
    }
}
