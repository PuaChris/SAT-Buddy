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
public class SATWordPackage implements Serializable {
    private int level;
    private int correctWordCount;
    private int wordsTotal;
    private int progress;
    private ArrayList<SATWord> satWordList;

    public SATWordPackage(int level, int correctWordCount, int wordsTotal) {
        this.level = level;
        this.correctWordCount = correctWordCount;
        this.wordsTotal = wordsTotal;
    }

    public SATWordPackage(int level, int correctWordCount, int wordsTotal, ArrayList<SATWord> satWordList) {
        this.level = level;
        this.correctWordCount = correctWordCount;
        this.wordsTotal = wordsTotal;
        this.satWordList = satWordList;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public ArrayList<SATWord> getSatWordList() {
        return satWordList;
    }

    public void setSatWordList(ArrayList<SATWord> satWordList) {

        // Perform a shallow copy of the passed in satWordList
        ArrayList<SATWord> temp = new ArrayList<SATWord>(satWordList);
        this.satWordList = temp;
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
