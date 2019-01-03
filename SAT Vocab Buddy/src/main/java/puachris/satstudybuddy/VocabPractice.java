package puachris.satstudybuddy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class VocabPractice extends AppCompatActivity {

    private static final String TAG = "VocabPractice";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vocab_practice);

        int correctWordCount = 5;
        int totalWordCount   = 23;

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

        ProgressBar progressBar     = (ProgressBar) findViewById(R.id.progressBar);

        // Setting buttons and text to hidden so they can be revealed later
        exampleOrAnswer.setVisibility(View.INVISIBLE);
        checkAnsText.setVisibility(View.INVISIBLE);
        incorrectBtn.setVisibility(View.INVISIBLE);
        correctBtn.setVisibility(View.INVISIBLE);

        // Display current word and progress
        wordProgress.setText(correctWordCount + "/" + totalWordCount);
        displayedWord.setText("Carp");
        progressBar.setProgress((correctWordCount*100)/totalWordCount);

        exampleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exampleOrAnswer.setVisibility(View.VISIBLE);

            }
        });

        ansBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exampleOrAnswer.setVisibility(View.VISIBLE);
                checkAnsText.setVisibility(View.VISIBLE);
                incorrectBtn.setVisibility(View.VISIBLE);
                correctBtn.setVisibility(View.VISIBLE);
            }
        });

        incorrectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exampleOrAnswer.setVisibility(View.INVISIBLE);
                checkAnsText.setVisibility(View.INVISIBLE);
                incorrectBtn.setVisibility(View.INVISIBLE);
                correctBtn.setVisibility(View.INVISIBLE);
            }
        });

        correctBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exampleOrAnswer.setVisibility(View.INVISIBLE);
                checkAnsText.setVisibility(View.INVISIBLE);
                incorrectBtn.setVisibility(View.INVISIBLE);
                correctBtn.setVisibility(View.INVISIBLE);
            }
        });



    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}
