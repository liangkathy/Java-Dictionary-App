package domain;

import interfaces.Writer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import static domain.Word.words;
import static domain.Word.words2;

public class WordWriter implements Writer {

    //create dictionary txt file to store words
    @Override
    public void createFile(String target){
        File file = new File(target);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println(e.getLocalizedMessage());
            }
        }
    }

    //loop through ArrayList and add objects to txt file with String template, each Word instance on a new line
    @Override
    public void writeArrayListObjects(String file) {
        File dictionaryFile = new File(file);
        if (!dictionaryFile.exists()){ //not likely to happen since the createFile method exists but just in case
            System.out.println("File not found");
        } else {
            if (dictionaryFile.length() == 0) { //only adds to txt file if it's blank to avoid replacing existing text
                updateTxtFile("./lib/dictionary.txt", words); //updates txt file with words array list
            }
        }
    }

    //file writer to add new words to txt file, grabs properties from the add method
    @Override
    public void writeNewWord(String wordInput, String definitionInput, String partOfSpeechInput, String exampleUsageInput) {
        try {
            FileWriter fileWriter = new FileWriter("./lib/dictionary.txt", true);
            fileWriter.write(STR."\n\{wordInput.toLowerCase()} | \{definitionInput.toLowerCase()} | \{partOfSpeechInput.toLowerCase()} | \{exampleUsageInput}"); //new word added to txt file in required format
            fileWriter.close();
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    //updates text file
    //called after word is deleted to update txt file with new words2 arraylist
    //also called if initial text file is blank
    @Override
    public void updateTxtFile(String file, List<Word> wordArrayList) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            //loop through ArrayList to add each Word instance on a new line of the txt file
            //write first line first so that newLine() can occur before line item and prevent text file from ending with an empty line
            bufferedWriter.write(STR."\{wordArrayList.getFirst().getWord()} | \{wordArrayList.getFirst().getDefinition()} | \{wordArrayList.getFirst().getPartOfSpeech()} | \{wordArrayList.getFirst().getExampleUsage()}");

            int i = 1;
            while (i < wordArrayList.size()) {
                if (wordArrayList.get(i) != null) {
                    bufferedWriter.newLine();
                    bufferedWriter.write(STR."\{wordArrayList.get(i).getWord()} | \{wordArrayList.get(i).getDefinition()} | \{wordArrayList.get(i).getPartOfSpeech()} | \{wordArrayList.get(i).getExampleUsage()}");
                }
                i++;
            }
            bufferedWriter.close();
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

}
