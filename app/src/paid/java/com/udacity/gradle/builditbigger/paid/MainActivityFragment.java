package com.udacity.gradle.builditbigger.paid;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.divitngoc.android.myandroidlib.JokeActivity;
import com.udacity.gradle.builditbigger.EndpointsAsyncTask;
import com.udacity.gradle.builditbigger.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainActivityFragment extends Fragment {


    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        final ProgressBar progressBar = root.findViewById(R.id.pb_loading_indicator);
        Button button = root.findViewById(R.id.button_tell_joke);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new EndpointsAsyncTask(getContext()) {
                    @Override
                    protected void onPreExecute() {
                        super.onPreExecute();
                        progressBar.setVisibility(View.VISIBLE);
                    }

                    @Override
                    protected void onPostExecute(String[] result) {
                        progressBar.setVisibility(View.INVISIBLE);
                        startJokeActivity(result);
                    }
                }.execute();
            }
        });

        return root;
    }

    private void startJokeActivity(String[] jokes) {
        Intent intent = new Intent(getContext(), JokeActivity.class );
        intent.putExtra(JokeActivity.INTENT_JOKE, jokes);
        getContext().startActivity(intent);
    }

}
