package puachris.satstudybuddy;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

public class VocabListAdapter extends ArrayAdapter<VocabPackage> {

    private static final String TAG = "VocabListAdapter";
    private Context mContext;
    int mResource;

    public VocabListAdapter(@NonNull Context context, int resource, @NonNull ArrayList<VocabPackage> objects)
    {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        // Get vocab information
        int level = getItem(position).getLevel();
        int wordCount = getItem(position).getWordCount();
        int wordsTotal = getItem(position).getWordsTotal();

        // Create VocabPackage object with new information
        VocabPackage vocab = new VocabPackage(level, wordCount, wordsTotal);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView levelText = (TextView) convertView.findViewById(R.id.levelText);
        TextView wordProgress = (TextView) convertView.findViewById(R.id.wordProgress);
        ProgressBar progressBar = (ProgressBar) convertView.findViewById(R.id.progressBar);
        View divider = (View) convertView.findViewById(R.id.divider);

        // Inputting information into the appropriate views
        levelText.setText("Level " + level);
        wordProgress.setText(wordCount + "/" + wordsTotal);
        progressBar.setProgress( (wordCount*100)/wordsTotal);
        divider.setVisibility(View.INVISIBLE);


        return convertView;
    }
}
