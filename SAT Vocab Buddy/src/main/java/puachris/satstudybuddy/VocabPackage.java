package puachris.satstudybuddy;

/**
 * OBJECT TO:
 * HOLD A LIST OF WORD-DEFINITIONS
 * KEEP TRACK OF NUMBER OF CORRECT WORDS USER
 * KEEP TRACK OF TOTAL NUMBER OF WORDS IN PACKAGE
 * DISPLAY PROGRESS OF NUMBER OF CORRECT WORDS
 *  **/

import java.util.ArrayList;
import java.io.Serializable;

@SuppressWarnings("serial")
public class VocabPackage implements Serializable {
    private int level;
    private int wordCount;
    private int wordsTotal;
    private int progress;
    private ArrayList<WordDefinition> wordList;

    public VocabPackage(int level, int wordCount, int wordsTotal) {
        this.level = level;
        this.wordCount = wordCount;
        this.wordsTotal = wordsTotal;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public ArrayList<WordDefinition> getWordList() {
        return wordList;
    }

    public void setWordList(ArrayList<WordDefinition> wordList) {
        this.wordList = wordList;
    }

    public int getWordCount() {
        return wordCount;
    }

    public void incrementWordCount() {
        wordCount++;
    }

    public void setWordCount(int wordCount) {
        this.wordCount = wordCount;
    }

    public int getWordsTotal() {
        return wordsTotal;
    }

    public void setWordsTotal(int wordsTotal) {
        this.wordsTotal = wordsTotal;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

}
