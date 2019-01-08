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
    private int correctWordCount;
    private int wordsTotal;
    private int progress;
    private ArrayList<WordDefinition> wordList;

    public VocabPackage(int level, int correctWordCount, int wordsTotal) {
        this.level = level;
        this.correctWordCount = correctWordCount;
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

    public int getCorrectWordCount() {
        return correctWordCount;
    }

    public void incrementCorrectWordCount() {
        correctWordCount++;
    }

    public void setCorrectWordCount(int correctWordCount) {
        this.correctWordCount = correctWordCount;
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
