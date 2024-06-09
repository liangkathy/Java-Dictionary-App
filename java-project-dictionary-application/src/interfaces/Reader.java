package interfaces;

import domain.Word;

import java.util.List;

public interface Reader {
    List<Word> formNewWordsArrayList (String file);
}
