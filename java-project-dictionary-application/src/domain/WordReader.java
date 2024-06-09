package domain;

import interfaces.Reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

import static domain.Word.words2;


public class WordReader implements Reader {

    //turn text file content back into new ArrayList of words to use in program
    @Override
    public List<Word> formNewWordsArrayList (String file) {
        String[] updatedWords = new String[4]; //string will always be 4 items
        try {
            BufferedReader br = new BufferedReader(new FileReader(file)); //to read lines
            String line = br.readLine();
            words2.clear(); //clear words array to prevent duplicate when updating list during program run session

            while(line != null) {
                updatedWords = line.split(" \\| "); //create a string splitting at the | symbol (each element of the string becomes a word property component)

                Word oneWord = new Word(updatedWords[0], updatedWords[1], updatedWords[2], updatedWords[3]); //convert string elements to Word instance properties
                words2.add(oneWord); //add each Word instance to second words arraylist

                line = br.readLine(); //move to next line at each loop until line is null
            }
            br.close();
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
        return words2;
    }
}
