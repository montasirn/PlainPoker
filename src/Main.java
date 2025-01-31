import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        File f = new File("src/input");


        String fileData = "";
        try {
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String currentLine = s.nextLine();
                fileData += currentLine + "\n";
            }


            // a String array where every item in the array is a line from the file
            String[] fileArray = fileData.split("\n");




            for (String line : fileArray){
                line = line.replace(line.substring(line.indexOf("|")),"");
                String[] cards = line.split(",");
                hand h = new hand(cards);
                System.out.println(h);
                h.numCards();
                System.out.println(h.getTwoPair());
            }






        }
        catch (FileNotFoundException fe) {
            System.out.println("File was not found");
            System.exit(1);
        }


    }
}