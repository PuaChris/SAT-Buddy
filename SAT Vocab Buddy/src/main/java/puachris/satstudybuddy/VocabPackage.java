package puachris.satstudybuddy;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class VocabPackage {
    private int level;
    private int wordCount;
    private int wordsTotal;
    private int progress;
    private ArrayList<String> wordList;

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

    public ArrayList<String> getWordList() {
        return wordList;
    }

    public void setWordList(ArrayList<String> wordList) {
        this.wordList = wordList;
    }

    public int getWordCount() {
        return wordCount;
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
