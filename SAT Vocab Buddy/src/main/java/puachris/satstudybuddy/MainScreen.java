package puachris.satstudybuddy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class MainScreen extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vocab_package_list);

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

    }

}
