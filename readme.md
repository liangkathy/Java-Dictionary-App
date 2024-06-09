# ABOUT MY JAVA PROJECT - Dictionary App

## Initialization:  
1. Creates dictionary.txt file if one does not exist already  
2. Writes existing List of words to txt file with specific format  
    - Initial words only load if text file is empty to avoid overriding previous words added/deleted
3. Reads txt file words and creates a new List of the words to be used in the program  

## Dictionary Menu Options:
### 1. Find a word  
    a. If instance of word is found - displays all instances of the word, definition, part of speech and example sentence.  
        - User can then hit enter to return to the main menu  
    b. If instance of word is not found - the following options are given:  
        1. Search for another word - brings user back to start of word search  
        2. Add word to dictionary - user is able to input definition, part of speech, and example sentence to add  
        3. Back to main menu  
### 2. Find words by definition  
    a. Scanner reads next line in case user is searching for multiple words or a phrase instead of single word  
    b. If a definition match is found - displays all instances of the word, definition, part of speech and example sentence.  
        - User can then hit enter to return to the main menu  
    c. If definition match is not found - the following options are given:  
        1. Search for another definition - brings user back to the start of the definition search  
        2. Back to main menu  
### 3. Find words that start with -  
    a. If a prefix match is found - displays all instances of the word, definition, part of speech and example sentence.  
        - User can then hit enter to return to the main menu  
    b. If prefix match is not found - the following options are given:  
        1. Search for another prefix - brings user back to the start of the prefix search  
        2. Back to main menu  
### 4. Find words that end with -  
    a. If a suffix match is found - displays all instances of the word, definition, part of speech and example sentence.  
        - User can then hit enter to return to the main menu  
    b. If suffix match is not found - the following options are given:  
        1. Search for another suffix - brings user back to the start of the suffix search  
        2. Back to main menu  
### 5. Find all words containing -  
    a. If a substring match is found in a word - displays all instances of the word, definition, part of speech and example sentence.  
        - User can then hit enter to return to the main menu  
    b. If substring match is not found - the following options are given:  
        1. Search for another string - brings user back to the start of the substring search  
        2. Back to main menu  
### 6. Add a word  
    a. Program validates that the word being added is a valid word using alphabet characters. System will prompt user that to enter a valid word if their initial input uses numbers or characters (anything other than letters).
    b. After word is validated, if word does not exist in the dictionary yet, the system prompt the user to input definition, followed by part of speech, followed by an example sentence using the word.  
    c. If an instance of the word already exists in the dictionary, all instances of the word are displayed and the following options are given:  
        1. Continue adding word - allows user to add word anyways in case of a unique variation of the word  
        2. Add a different word - goes back to the start of the add word process and asks user for new word  
        3. Return to main menu  
    d. Once a word is added, it is put into the dictionary txt file in the correct format and the wordReader is called again to update the program's List of words  
### 7. Delete a word  
    a. If one matching instance of the word is found - the details of the matching word are displayed and the user will be asked to confirm if they want to delete the word permanently or cancel and return to the main menu  
    b. If multiple instances of the word are found - the details of all matching words are displayed and the user is given the option to choose a specific instance to delete or delete all instances of the word. The user can also cancel and return to the main menu.  
    c. If no word matches are found - the following options are given:  
        1. Delete a different word - goes back to start of delete process and asks for the new word to delete  
        2. Return to main menu  
    d. Each time a word is deleted, the wordwriter is called to update the dictionary txt file with the new List of words  
### 8. History  
    a. Displays the current session's search history  
    b. Clears when user exits the program  
### 9. Creator  
    a. Displays that this program was created by Kathy Liang  
### 10. Exit  
    a. Exits program with exit code 0  


