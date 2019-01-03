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

public class MainScreen extends AppCompatActivity {

    private static final String TAG = "MainScreen";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vocab_package_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ListView mListView = (ListView) findViewById(R.id.listView);

        // Create Vocab_Packages
        VocabPackage test = new VocabPackage(1, 0, 10);
        VocabPackage hello = new VocabPackage(2, 3, 7);
        VocabPackage hi = new VocabPackage(3, 17, 17);


        // Array to hold all the VocabPackage objects
        ArrayList<VocabPackage> vocabList = new ArrayList<VocabPackage>();
        vocabList.add(test);
        vocabList.add(hello);
        vocabList.add(hi);

        VocabListAdapter adapter = new VocabListAdapter(this, R.layout.vocab_package, vocabList);
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                if (position > -1)
                {
                    Log.i("test", "Item was clicked");
                    Intent myIntent = new Intent(view.getContext(), VocabPractice.class);
                    startActivityForResult(myIntent, position);
                }
            }
        });

    }

}
