package com.divitngoc.android.myandroidlib;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;


public class JokeActivity extends AppCompatActivity {

    public static final String INTENT_JOKE = "intentJoke";
    public RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_joke);

        Intent intent = getIntent();
        String[] jokes = {};
        if (intent != null) {
            if (intent.hasExtra(INTENT_JOKE)) {
                jokes = intent.getStringArrayExtra(INTENT_JOKE);
            }
            Log.v("JokeActivity", "jokes size: " + jokes.length);
        }

        JokeAdapter adapter = new JokeAdapter(jokes);

        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(adapter);
    }

}
