package puachris.satstudybuddy;

import java.io.Serializable;

/*** OBJECT TO HOLD THE WORD ITSELF, AN EXAMPLE USAGE OF THE WORD, AND ITS DEFINITION ***/

public class SATWord implements Serializable {
    private String word;
    private String example;
    private String definition;

    public SATWord(String word, String example, String definition) {
        this.word = word;
        this.example = example;
        this.definition = definition;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }
}
