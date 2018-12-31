package puachris.satstudybuddy;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainScreen extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        ListView mListView = (ListView) findViewById(R.id.listView);


        // Create Vocab_Packages
        Vocab_Package test = new Vocab_Package(1, 0, 10);
        Vocab_Package hello = new Vocab_Package(2, 3, 7);
        Vocab_Package hi = new Vocab_Package(3, 17, 17);


        // Array to hold all the Vocab_Package objects
        ArrayList<Vocab_Package> vocabList = new ArrayList<Vocab_Package>();
        vocabList.add(test);
        vocabList.add(hello);
        vocabList.add(hi);

        VocabListAdapter adapter = new VocabListAdapter(this, R.layout.adapter_view_layout, vocabList);
        mListView.setAdapter(adapter);

    }

}
