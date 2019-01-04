package puachris.satstudybuddy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

public class VocabPracticeScreen extends AppCompatActivity {
    int correctWordCount;
    int totalWordCount;
    ArrayList<WordDefinition> wordList;
    WordDefinition currentWord;
    int wordItr = 0;

    private static final String TAG = "VocabPracticeScreen";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vocab_practice);

        /********************* Initializing Toolbar and Views on screen *****************************/

        // Setting up toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        // Initializing all subviews
        final TextView wordProgress       = (TextView) findViewById(R.id.wordProgress);
        final TextView displayedWord      = (TextView) findViewById(R.id.displayedWord);
        final TextView exampleOrAnswer    = (TextView) findViewById(R.id.exampleOrAnswer);
        final TextView checkAnsText       = (TextView) findViewById(R.id.checkAnsText);

        final Button exampleBtn   = (Button) findViewById(R.id.exampleBtn);
        final Button ansBtn       = (Button) findViewById(R.id.ansBtn);
        final Button incorrectBtn = (Button) findViewById(R.id.incorrectBtn);
        final Button correctBtn   = (Button) findViewById(R.id.correctBtn);

        final ProgressBar progressBar     = (ProgressBar) findViewById(R.id.progressBar);

        // Setting buttons and text to hidden so they can be revealed later
        exampleOrAnswer.setVisibility(View.INVISIBLE);
        checkAnsText.setVisibility(View.INVISIBLE);
        incorrectBtn.setVisibility(View.INVISIBLE);
        correctBtn.setVisibility(View.INVISIBLE);


        /*********** Passing intent and VocabPackages from MainScreen to PracticeScreen ****************/

        Intent myIntent = getIntent();
        final VocabPackage vocabPackage = (VocabPackage) myIntent.getSerializableExtra("VocabPackage");

        correctWordCount = vocabPackage.getWordCount();
        totalWordCount   = vocabPackage.getWordsTotal();
        wordList         = vocabPackage.getWordList();

        currentWord = wordList.get(wordItr);

        // Display current word and progress
        displayedWord.setText(currentWord.getWord());

        wordProgress.setText(correctWordCount + "/" + totalWordCount);
        progressBar.setProgress((correctWordCount*100)/totalWordCount);


        /************************* Button functionality in PracticeScreen *******************************/

        // Display example using displayed word
        exampleBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                exampleOrAnswer.setVisibility(View.VISIBLE);
                exampleOrAnswer.setText(currentWord.getExample());
            }
        });

        // Display definition and correct/incorrect buttons
        ansBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                exampleOrAnswer.setVisibility(View.VISIBLE);
                exampleOrAnswer.setText(currentWord.getDefinition());

                checkAnsText.setVisibility(View.VISIBLE);
                incorrectBtn.setVisibility(View.VISIBLE);
                correctBtn.setVisibility(View.VISIBLE);
            }
        });

        // Move onto next word
        incorrectBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                exampleOrAnswer.setVisibility(View.INVISIBLE);
                checkAnsText.setVisibility(View.INVISIBLE);
                incorrectBtn.setVisibility(View.INVISIBLE);
                correctBtn.setVisibility(View.INVISIBLE);

                wordItr++;

                if (wordItr < totalWordCount)
                    currentWord = wordList.get(wordItr);

                // Exit activity after going through all words
                else
                {
                    wordItr = 0;
                    finish();
                }
            }
        });

        // Increment count for number of correct words and move onto next word
        correctBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                exampleOrAnswer.setVisibility(View.INVISIBLE);
                checkAnsText.setVisibility(View.INVISIBLE);
                incorrectBtn.setVisibility(View.INVISIBLE);
                correctBtn.setVisibility(View.INVISIBLE);

                vocabPackage.incrementWordCount();
                correctWordCount=vocabPackage.getWordCount();

                wordProgress.setText(correctWordCount + "/" + totalWordCount);
                progressBar.setProgress((correctWordCount*100)/totalWordCount);

                wordItr++;

                if (wordItr < totalWordCount)
                    currentWord = wordList.get(wordItr);

                // Exit activity after going through all words
                else
                {
                    wordItr = 0;
                    finish();
                }


            }
        });
    }

    // Back arrow to return to previous screen located on toolbar
    @Override
    public boolean onSupportNavigateUp()
    {
        onBackPressed();
        return true;
    }

}
