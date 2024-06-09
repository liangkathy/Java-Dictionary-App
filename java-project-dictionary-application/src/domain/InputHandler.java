package domain;

import utils.Utils;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import static domain.Word.*;

public class InputHandler {
    public static WordWriter wordWriter = new WordWriter();
    public static WordReader wordReader = new WordReader();

    //for choice menu
    public static void showMenu(Scanner scanner) {
        System.out.println("""
                WELCOME
                Select an option:
                1. Find a word
                2. Find words by definition
                3. Find words that start with -
                4. Find words that end with -
                5. Find all words containing -
                6. Add a word
                7. Delete a word
                8. History
                9. Creator
                10. Random Word Generator
                11. Exit""");

        try {
            int choice = scanner.nextInt();
            InputHandler.getChoiceSelection(scanner, choice);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Try again.");
        }

    }

    //for choice selection
    private static void getChoiceSelection(Scanner scanner, int choice) {
        if (choice == 1) {
            System.out.println("Enter word to search");
            String input = scanner.next();
            findAWord(scanner,input);
        } else if (choice == 2) {
            scanner.nextLine();
            System.out.println("Enter definition to search");
            String input = scanner.nextLine(); //scanner looks for next line to ensure entire line is used instead of a single word (this includes phrases with spaces)
            findWordsByDefinition(scanner, input);
        } else if (choice == 3) {
            System.out.println("Enter prefix to search");
            String input = scanner.next();
            findWordsByPrefix(scanner, input);
        } else if (choice == 4) {
            System.out.println("Enter suffix to search");
            String input = scanner.next();
            findWordsBySuffix(scanner, input);
        } else if (choice == 5) {
            System.out.println("Enter substring to search");
            String input = scanner.next();
            findWordsBySubstring(scanner, input);
        } else if (choice == 6) {
            System.out.println("Enter word to add");
            String input = scanner.next();
            addWordToDictionary(scanner, input);
        } else if (choice == 7) {
            System.out.println("Enter word to delete");
            String input = scanner.next();
            deleteWordFromDictionary(scanner, input);
        } else if (choice == 8) {
            System.out.println("Recently searched words:");
            showWordHistory(scanner, getWordSearchHistory());
            returnToMenu(scanner);
        } else if (choice == 9) {
            System.out.println("Created by Kathy Liang");
            scanner.nextLine();
            returnToMenu(scanner);
        } else if (choice == 10) {
            System.out.println("Random Word Generator");
            System.out.println("\nYOUR RANDOM WORD IS:");
            getRandomWord(scanner);
        } else if (choice == 11) {
            System.out.println("Exiting dictionary");
            scanner.close();
            System.exit(0);
        } else if (choice != 0-9) {

        } else {
            System.out.println("Invalid option selected. Returning to main menu");
            showMenu(scanner);
        }
    }


    //1. FIND A WORD
    private static void findAWord (Scanner scanner, String wordInput) {
        boolean validWord = Utils.isValidWord(wordInput);
        if(validWord) {
            boolean wordFound = false;
            storeWords(wordInput);
            List<Word> matchingWords = words2.stream().filter(word -> Utils.compareWords(word, wordInput)).toList();
            if(!matchingWords.isEmpty()) {
                System.out.println(STR."\nTotal Matches: \{matchingWords.size()}");
                Utils.printWords(matchingWords);
                wordFound = true;
                scanner.nextLine();
                returnToMenu(scanner); //hit enter to return to main menu
            }

            if (!wordFound) {
                System.out.println("Word not found\nSelect an option:\n1. Search for another word\n2. Add word to dictionary\n3. Back to main menu");
                int choice = scanner.nextInt();
                if (choice == 1) {
                    getChoiceSelection(scanner, 1); //back to new word search
                } else if (choice == 2) {
                    wordFormInput(scanner, wordInput);
                } else if (choice == 3) {
                    showMenu(scanner);
                } else {
                    System.out.println("Invalid option selected. Returning to main menu");
                    showMenu(scanner);
                }
            }
        }
        if(!validWord) {
            System.out.println("Not a valid word entry. Please enter a valid word");
            getChoiceSelection(scanner,1);
        }
    }


    //2. FIND A WORD BY DEFINITION
    private static void findWordsByDefinition (Scanner scanner, String textInput) {
        boolean matchFound = false;

        List<Word> matchingWords = words2.stream().filter(word -> Utils.compareDefinitionText(word, textInput)).toList();
        if(!matchingWords.isEmpty()) {
            System.out.println(STR."\nTotal Matches: \{matchingWords.size()}");
            Utils.printWords(matchingWords);
            matchFound = true;
            returnToMenu(scanner); //hit enter to return to main menu
        }

        if (!matchFound) {
            System.out.println("Definition match not found\nSelect an option:\n1. Search for another definition\n2. Back to main menu");
            int choice = scanner.nextInt();
            if (choice == 1) {
                getChoiceSelection(scanner, 2); //back to new definition search
            } else if (choice == 2) {
                showMenu(scanner);
            } else {
                System.out.println("Invalid option selected. Returning to main menu");
                showMenu(scanner);
            }
        }
    }


    //3. FIND WORDS BY PREFIX
    private static void findWordsByPrefix(Scanner scanner, String prefixInput) {
        boolean prefixFound = false;
        List<Word> wordsWithPrefix = words2.stream().filter(word -> Utils.searchByPrefix(word, prefixInput)).toList();

        if (!wordsWithPrefix.isEmpty()){
            System.out.println(STR."\nTotal Matches: \{wordsWithPrefix.size()}");
            Utils.printWords(wordsWithPrefix);
            prefixFound = true;
            scanner.nextLine();
            returnToMenu(scanner); //hit enter to return to main menu
        }

        if (!prefixFound) {
            System.out.println("Prefix match not found\nSelect an option:\n1. Search for another prefix\n2. Back to main menu");
            int choice = scanner.nextInt();
            if (choice == 1) {
                getChoiceSelection(scanner, 3); //back to new prefix search
            } else if (choice == 2) {
                showMenu(scanner);
            } else {
                System.out.println("Invalid option selected. Returning to main menu");
                showMenu(scanner);
            }
        }

    }


    //4. FIND WORDS BY SUFFIX
    private static void findWordsBySuffix(Scanner scanner, String suffixInput) {
        boolean suffixFound = false;
        List<Word> wordsWithSuffix = words2.stream().filter(word -> Utils.searchBySuffix(word, suffixInput)).toList();

        if (!wordsWithSuffix.isEmpty()) {
            System.out.println(STR."\nTotal Matches: \{wordsWithSuffix.size()}");
            Utils.printWords(wordsWithSuffix);
            suffixFound = true;
            scanner.nextLine();
            returnToMenu(scanner); //hit enter to return to main menu
        }

        if (!suffixFound) {
            System.out.println("Suffix match not found\nSelect an option:\n1. Search for another suffix\n2. Back to main menu");
            int choice = scanner.nextInt();
            if (choice == 1) {
                getChoiceSelection(scanner, 4); //back to new suffix search
            } else if (choice == 2) {
                showMenu(scanner);
            } else {
                System.out.println("Invalid option selected. Returning to main menu");
                showMenu(scanner);
            }
        }

    }


    //5. FIND WORDS THAT CONTAIN SUBSTRING
    private static void findWordsBySubstring(Scanner scanner, String substringInput) {
        boolean substringFound = false;
        List<Word> wordsWithSubstring = words2.stream().filter(word -> Utils.searchBySubstring(word, substringInput)).toList();

        if (!wordsWithSubstring.isEmpty()) {
            System.out.println(STR."\nTotal Matches: \{wordsWithSubstring.size()}");
            Utils.printWords(wordsWithSubstring);
            substringFound = true;
            scanner.nextLine();
            returnToMenu(scanner); //hit enter to return to menu
        }

        if (!substringFound) {
            System.out.println("String match not found\nSelect an option:\n1. Search for another string\n2. Back to main menu");
            int choice = scanner.nextInt();
            if (choice == 1) {
                getChoiceSelection(scanner, 5); //back to new substring search
            } else if (choice == 2) {
                showMenu(scanner);
            } else {
                System.out.println("Invalid option selected. Returning to main menu");
                showMenu(scanner);
            }
        }

    }


    //6. ADD WORD
    private static void addWordToDictionary(Scanner scanner, String wordInput) {
        boolean validWord = Utils.isValidWord(wordInput);
        if(validWord) {
            //confirm word does not exist in dictionary
            List<Word> matchingWords = words2.stream().filter(word -> Utils.compareWords(word, wordInput)).toList();
            if(!matchingWords.isEmpty()) {
                System.out.println(STR."\{matchingWords.size()} existing word(s) found in dictionary:"); //if word exists in dictionary, show existing word(s)
                Utils.printWords(matchingWords);
                System.out.println("\nSelect an option:\n1. Continue adding word\n2. Add a different word\n3. Return to main menu"); //allow user to continue adding any ways in case of a unique instance
                int choice = scanner.nextInt();
                if (choice == 1) {
                    wordFormInput(scanner, wordInput); //asks for word properties
                } else if (choice == 2) {
                    getChoiceSelection(scanner, 6); //return to start of add word
                } else if (choice == 3) {
                    showMenu(scanner);
                } else {
                    System.out.println("Invalid option selected. Returning to main menu");
                    showMenu(scanner);
                }
            } else {
                wordFormInput(scanner, wordInput); //if word not found already, goes directly to ask for word properties

            }
        }
        if(!validWord) {
            System.out.println("Not a valid word entry. Please enter a valid word");
            getChoiceSelection(scanner,6);
        }

    }

    //+ADD WORD form to add word properties
    private static void wordFormInput (Scanner scanner, String wordInput) {
        scanner.nextLine();
        System.out.println("Enter definition of word");
        String definitionInput = scanner.nextLine();

        System.out.println("Enter its part of speech (i.e. noun, adjective, verb, etc.)");
        String partOfSpeechInput = scanner.nextLine();

        System.out.println("Provide an example of the word used in a sentence");
        String exampleUsageInput = scanner.nextLine();

        wordWriter.writeNewWord(wordInput, definitionInput, partOfSpeechInput, exampleUsageInput);
        wordReader.formNewWordsArrayList("./lib/dictionary.txt"); //update words list array

        System.out.println(STR."The word \{wordInput} has been added to the dictionary.\nReturning to main menu");
        returnToMenu(scanner);
    }


    //7. DELETE A WORD
    private static void deleteWordFromDictionary(Scanner scanner, String wordInput) {
        List<Word> matchingWords = words2.stream().filter(word -> Utils.compareWords(word, wordInput)).toList();
        if(!matchingWords.isEmpty()) {
            System.out.println(STR."\{matchingWords.size()} existing word(s) found in dictionary:");
            Utils.printWords(matchingWords);
                if (matchingWords.size() == 1) {
                    System.out.println("\nDelete word permanently?\n1. Yes\n2. No (return to main menu)");
                    int choice = scanner.nextInt();
                    if (choice == 1) {
                        System.out.println(STR."\{wordInput} has been deleted from the dictionary");
                        finalizeDeleteWord(scanner, wordInput); //remove word from array
                    } else if (choice == 2) {
                        showMenu(scanner);
                    } else {
                        System.out.println("Invalid option selected. Returning to main menu");
                        showMenu(scanner);
                    }
                } else { //if there is more than 1 matching word to delete
                    int arraySize = matchingWords.size(); //
                    System.out.println("\nConfirm which version to delete permanently:");
                    int i;

                    List<String> definitionValue = new ArrayList<>(); //
                    for (i = 0; i< matchingWords.size(); i++) {
                        definitionValue.add(matchingWords.get(i).getDefinition());
                        System.out.println(STR."\{i + 1}. Word: \{matchingWords.get(i).getWord()} | Definition: \{matchingWords.get(i).getDefinition()}");
                    }
                    System.out.println(STR."\{i + 1}. Delete all instances of the word");
                    System.out.println(STR."\{i + 2}. Cancel and return to main menu");
                    int choice = scanner.nextInt();
                    if (choice == i + 1) {
                        System.out.println(STR."All instances of the word \{wordInput} have been deleted from the dictionary");
                        finalizeDeleteWord(scanner, wordInput); //chose to delete all instances
                    } else if (choice == i + 2) {
                        showMenu(scanner); //return to main menu
                    } else {
                        int objectToDelete; //
                        while (arraySize > 0) {
                            if (choice == arraySize) {
                                objectToDelete = arraySize - 1;
                                System.out.println(STR."\{wordInput} (with the definition: \{definitionValue.get(objectToDelete)}) has been deleted from the dictionary");
                                deleteInstanceOfWord(scanner, objectToDelete, definitionValue);
                            }
                            arraySize --;
                        }

                    }

                }
        } else {
            System.out.println("No existing word was found.\nSelect an option:\n1. Delete a different word\n2. Return to main menu");
            int choice = scanner.nextInt();
            if (choice == 1) {
                getChoiceSelection(scanner, 7); //back to delete word
            } else if (choice == 2) {
                showMenu(scanner);
            } else {
                System.out.println("Invalid option selected. Returning to main menu");
                showMenu(scanner);
            }
        }
    }

    //--DELETE WORD after confirmation
    private static void finalizeDeleteWord(Scanner scanner, String wordInput) {
        words2 = words2.stream().filter(word -> Utils.wordDoesNotMatch(word, wordInput)).toList();
        wordWriter.updateTxtFile("./lib/dictionary.txt",words2); //update txt file with deleted word
        scanner.nextLine();
        returnToMenu(scanner); //enter to return to menu
    }

    //method for more than 1 instance to delete
    private static void deleteInstanceOfWord(Scanner scanner, int objectToDelete, List<String> definitionValue) {
        words2 = words2.stream().filter(word -> Utils.oneWordToDelete(word, objectToDelete, definitionValue)).toList();
        wordWriter.updateTxtFile("./lib/dictionary.txt",words2); //update txt file with deleted word
        scanner.nextLine();
        returnToMenu(scanner); //enter to return to menu
    }


    //8 STORE WORD SEARCH HISTORY
    private static void storeWords(String wordInput) {
        getWordSearchHistory().add(wordInput); //add word to arrayList
    }

    // DISPLAY WORD HISTORY
    private static void showWordHistory(Scanner scanner, List<String> wordSearchHistory) {
        for (String word : wordSearchHistory) { //loop through arrayList and print each word on a line
            System.out.println(word);
        }
        scanner.nextLine();
        returnToMenu(scanner);
    }




    //---EXTRA FUNCTIONALITIES---

    //hit enter to return to main menu
    private static void returnToMenu (Scanner scanner) {
        System.out.println("\nHit enter to return to main menu");
        scanner.nextLine();
        showMenu(scanner);
    }

    //10 RANDOM WORD GENERATOR
    private static void getRandomWord (Scanner scanner) {
        int index = (int)(Math.random() * words2.size()); //get random number (int) between 0 (inclusive) to size of the arraylist (exclusive)
        Utils.printWords(words2.get(index));

        System.out.println("\nSelect an option:\n1. Get another random word\n2. Return to main menu");
        int choice = scanner.nextInt();
        if (choice == 1) {
            getChoiceSelection(scanner, 10); //restart random word generator
        } else if (choice == 2) {
            showMenu(scanner);
        } else {
            System.out.println("Invalid option selected. Returning to main menu");
            showMenu(scanner);
        }
    }


}
