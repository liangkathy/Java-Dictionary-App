package utils;

import domain.Word;
import java.util.List;

import static java.lang.StringTemplate.STR;


public class Utils {

    //FILTER METHODS
    //for word search - compares user input to words in arraylist
    public static boolean compareWords(Word word, String wordInput) {
        return word.getWord().equalsIgnoreCase(wordInput);
    }
    //for definition search - compares user substring input to definitions in arraylist
    public static boolean compareDefinitionText(Word word, String textInput) {
        return word.getDefinition().contains(textInput);
    }

    //for prefix search - checks if word starts with prefix string
    public static boolean searchByPrefix(Word word, String prefixInput) {
        return word.getWord().startsWith(prefixInput.toLowerCase());
    }

    //for suffix search - checks if word ends with suffix string
    public static boolean searchBySuffix(Word word, String suffixInput) {
        return word.getWord().endsWith(suffixInput.toLowerCase());
    }

    //for substring search - checks if substring is in word
    public static boolean searchBySubstring(Word word, String substringInput) {
        return word.getWord().contains(substringInput.toLowerCase());
    }

    //for delete
    public static boolean wordDoesNotMatch (Word word, String wordInput) {
        return !word.getWord().equalsIgnoreCase(wordInput); //keep words that do not match the word to delete
    }

    //for delete one instance of multiple
    public static boolean oneWordToDelete (Word word, int objectToDelete, List<String> definitionValue) {
        return !word.getDefinition().equalsIgnoreCase(definitionValue.get(objectToDelete)); //keep words that do not match the definition of the word to delete
    }

    //print format for words
    public static void printWords(List<Word> listName) {
        for (Word word : listName) {
            System.out.println(STR."\nWord: \{word.getWord()}\nDefinition: \{word.getDefinition()}\nPart of Speech: \{word.getPartOfSpeech()}\nExample sentence: \{word.getExampleUsage()}");
        }
    }

    //overloading print
    public static void printWords(Word word) {
        System.out.println(STR."Word: \{word.getWord()}\nDefinition: \{word.getDefinition()}\nPart of Speech: \{word.getPartOfSpeech()}\nExample sentence: \{word.getExampleUsage()}");
    }

    //check if valid word
    public static boolean isValidWord (String input) {
        int len = input.length();
        int i = 0;
        boolean validWord = true;
        String inputToCheck = input.toLowerCase();

        while (i < len) {
            if (inputToCheck.charAt(i) < 97 || inputToCheck.charAt(i) > 122) {
                validWord = false;
                break;
            }
            i++;
        }
        return validWord;
    }

}