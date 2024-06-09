import domain.InputHandler;
import java.util.Scanner;

import static domain.InputHandler.wordReader;
import static domain.InputHandler.wordWriter;


public class DictionaryApp {
    private static String myFile = "./lib/dictionary.txt";

    public static void main(String[] args) {


        //create file if it does not exist yet
        wordWriter.createFile(myFile);

        //add ArrayList objects to dictionary.txt - will only run if txt file is empty
        wordWriter.writeArrayListObjects(myFile);

        //convert text file lines into a new arraylist to reference in program
        wordReader.formNewWordsArrayList(myFile);


        //SCANNER
        Scanner scanner = new Scanner(System.in);
        InputHandler.showMenu(scanner); //calls method to display menu

    }


}
