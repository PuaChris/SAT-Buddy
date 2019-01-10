package puachris.satstudybuddy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;


public class SATDictionaryMainScreen extends AppCompatActivity
{

    private static final String TAG = "SATDictionaryMainScreen";
    private static final int WORDSPERPACKAGE = 16;

    int listItr;
    SATDictionaryAdapter adapter;
    SATWordPackage satWordPackage;
    ArrayList<SATWordPackage> SATDictionary;


    /*********** Retrieve data from local JSON file in 'assets' folder ***************/
    public String loadJSONFromAsset()
    {
        String json = null;
        try
        {
            InputStream is = getAssets().open("sat_vocab_list.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        }

        catch (IOException ex)
        {
            ex.printStackTrace();
            return null;
        }
        return json;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sat_dictionary);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ListView mListView = (ListView) findViewById(R.id.listView);

        ArrayList<SATWord> wordList = new ArrayList<>();


        // Array to hold all the SATWordPackage objects
        SATDictionary = new ArrayList<>();


        try
        {
            JSONObject obj = new JSONObject(loadJSONFromAsset());
            JSONArray jsonArray = obj.getJSONArray("Words");

            // To differentiate vocabulary packages
            int level = 0;

            for (int i = 0; i < jsonArray.length(); i++)
            {
                // Retrieving JSON array from JSON file
                JSONObject jWord = jsonArray.optJSONObject(i);

                String word         = jWord.getString("Word");
                String example      = jWord.getString("Example Sentence");
                String definition   = jWord.getString("Definition");

                if (i % WORDSPERPACKAGE == 0 && i > 0)
                {

                    level++;
                    int numWords = wordList.size();

                    satWordPackage = new SATWordPackage(level, 0, numWords);
                    satWordPackage.setSatWordList(wordList);

                    SATDictionary.add(satWordPackage);

                    wordList.clear();
                }

                // Creating SATWord Object and adding it to master WordList
                wordList.add(new SATWord(word, example, definition));
            }
        }

        catch (JSONException e)
        {
            e.printStackTrace();
        }



        // Sending SATWordPackage objects to SATDictionaryMainScreen
        adapter = new SATDictionaryAdapter(this, R.layout.sat_word_package, SATDictionary);
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                if (position > -1)
                {
                    // Keep track of which vocab package was selected
                    listItr = position;
                    satWordPackage = SATDictionary.get(position);

                    Intent myIntent = new Intent(view.getContext(), SATWordPracticeScreen.class);

                    // Passing selected vocab package to activity with serializable method
                    myIntent.putExtra("SATWordPackage", satWordPackage);
                    startActivityForResult(myIntent, 1);
                }
            }
        });
    }

    /*********************** Retrieve data from practice screen ********************/
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if(resultCode == RESULT_OK) {

                // Get number of correct words from user. Default value is 0
                int correctWordCount = data.getIntExtra("CorrectWordCount", 0);

                // Update information in ListView Adapter
                SATDictionary.get(listItr).setCorrectWordCount(correctWordCount);
                adapter.notifyDataSetChanged();
            }
        }
    }
}
