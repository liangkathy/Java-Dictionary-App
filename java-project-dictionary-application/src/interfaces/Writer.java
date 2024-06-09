package interfaces;

import domain.Word;

import java.util.List;

public interface Writer {
    void createFile(String target);
    void writeArrayListObjects(String file);
    void writeNewWord(String wordInput, String definitionInput, String partOfSpeechInput, String exampleUsageInput);
    void updateTxtFile(String file, List<Word> wordArrayList);
}
