package puachris.satstudybuddy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainScreen extends AppCompatActivity
{

    private static final String TAG = "MainScreen";

    int listItr;
    VocabListAdapter adapter;
    int correctWordCount;
    int numWordsPackaged;
    VocabPackage test = new VocabPackage(1, 0, numWordsPackaged);
    ArrayList<VocabPackage> vocabList;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vocab_package_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ListView mListView = (ListView) findViewById(R.id.listView);

        // Creating WordDefinition objects that consist of:
        // 1. Word itself
        // 2. Example usage of the word
        // 3. Definition of the word

        WordDefinition testingWordDefinition = new WordDefinition("TestWord",
                                                                "Testing example",
                                                                "Testing definition");
        WordDefinition randomWordDef = new WordDefinition("Carp",
                                                        "Dad didn't know what a carp was",
                                                        "It's a fish lmao");
        WordDefinition abate = new WordDefinition("Abate",
                                                "As I began my speech, my feelings of nervousness quickly abated.",
                                                "v. to become less active, less intense, or less in amount");

        ArrayList<WordDefinition> testWords= new ArrayList<>();

        testWords.add(testingWordDefinition);
        testWords.add(randomWordDef);
        testWords.add(abate);

        numWordsPackaged = testWords.size();

        // Packaging all of the WordDefinition Objects into a VocabPackage object
        final VocabPackage test = new VocabPackage(1, 0, numWordsPackaged);

        test.setWordList(testWords);


        // Array to hold all the VocabPackage objects
        vocabList = new ArrayList<>();
        vocabList.add(test);

        // Sending VocabPackage objects to MainScreen
        adapter = new VocabListAdapter(this, R.layout.vocab_package, vocabList);
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                if (position > -1)
                {
                    listItr = position;
                    Log.e(TAG, "Item was clicked");
                    Intent myIntent = new Intent(view.getContext(), VocabPracticeScreen.class);
                    myIntent.putExtra("VocabPackage", test);
                    startActivityForResult(myIntent, 1);


                }

            }

        });




    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if(resultCode == RESULT_OK) {

                correctWordCount = data.getIntExtra("CorrectWordCount", 0);
                Log.e(TAG, "Intent received! Number of correct words is: " + correctWordCount);


                // Update information in ListView Adapter
                vocabList.get(listItr).setCorrectWordCount(correctWordCount);
                adapter.notifyDataSetChanged();
            }
        }
    }


}
