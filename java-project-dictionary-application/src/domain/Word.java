package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Word{

    private String word;
    private String definition;
    private String partOfSpeech;
    private String exampleUsage;

    //CONSTRUCTOR

    public Word() {
    }

    public Word(String word, String definition, String partOfSpeech, String exampleUsage) {
        this.word = word;
        this.definition = definition;
        this.partOfSpeech = partOfSpeech;
        this.exampleUsage = exampleUsage;
    }

    //GETTERS AND SETTERS

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getPartOfSpeech() {
        return partOfSpeech;
    }

    public void setPartOfSpeech(String partOfSpeech) {
        this.partOfSpeech = partOfSpeech;
    }

    public String getExampleUsage() {
        return exampleUsage;
    }

    public void setExampleUsage(String exampleUsage) {
        this.exampleUsage = exampleUsage;
    }

    //allow object to be printed with string text in an arraylist
    @Override
    public String toString() {
        return String.format("[%s, %s, %s, %s]", word, definition, partOfSpeech, exampleUsage);
    }

    public static List<Word> words = Arrays.asList(
            new Word("radio", "wireless telegraphy or telephony", "noun", "The news was sent by radio."),
            new Word("cytotoxic", "poisonous to living cells", "adjective", "Chemotherapy uses cytotoxic drugs to kill cancer cells."),
            new Word("gravitate", "to move or tend to move under the influence of gravitational force", "verb", "We gravitate towards kind people."),
            new Word("quick", "done, proceeding, or occurring with promptness or rapidity, as an action, process, etc.", "adjective", "They walked in quick steps."),
            new Word("landlord", "a person or organization that owns and leases apartments to others", "noun", "The landlord increased rent this year."),
            new Word("course", "a direction or route taken or to be taken", "noun", "They were on course to succeed."),
            new Word("hefty", "of considerable weight and size", "adjective", "The hefty couch was hard to move."),
            new Word("minimal", "the least possible", "adjective", "The small kitchen had minimal counter space."),
            new Word("aftermath", "the consequences of an event", "noun", "Many homes were destroyed in the aftermath of the hurricane."),
            new Word("friend", "a person attached to another by feelings of affection or personal regard", "noun", "They got along and became friends quickly."),
            new Word("preventable", "able to be avoided", "adjective", "Many ailments are preventable."),
            new Word("capable", "able to achieve efficiently whatever one has to do; competent", "adjective", "The capable lawyer has won many trials."),
            new Word("preserve", "to maintain something in its original or existing state", "verb", "They wanted to preserve the original state of the artifact."),
            new Word("preserve", "a sweet food made with fruit preserved in sugar, such as jam or marmalade", "noun", "She ate a homemade preserve made from raspberries."),
            new Word("flourish", "to grow luxuriantly","verb","The warm weather and sun caused the wildflowers to flourish."),
            new Word("sun", "the star around which the earth orbits","noun", "The sun is almost 93 million miles away from Earth."),
            new Word("moon", "the natural satellite of the earth, visible (chiefly at night) by reflected light from the sun", "noun", "The moon's gravity is the main cause of tides on Earth."),
            new Word("traction", "the action of drawing or pulling something over a surface, especially a road or track", "noun", "These tires get good traction on wet roads."),
            new Word("portion", "part of  whole", "noun", "A portion of the pie was eaten."),
            new Word("row","a straight line going across horizontally", "noun","That row shows different values for each column."),
            new Word("row","a line of seats in a theater", "noun", "My tickets show that I am in Row C."),
            new Word("random","made, done, happening, or chosen without method or conscious decision","noun","They surveyed 100 random people.")
    );

    public static List<Word> words2 = new ArrayList<>();

    private static final List<String> wordSearchHistory = new ArrayList<>();

    public static List<String> getWordSearchHistory() {
        return wordSearchHistory;
    }
}

