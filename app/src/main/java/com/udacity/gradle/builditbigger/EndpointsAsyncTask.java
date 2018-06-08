package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.divitngoc.android.myandroidlib.JokeActivity;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;
import java.util.List;

public class EndpointsAsyncTask extends AsyncTask<Context, String[], String[]> {
    private static MyApi myApiService = null;
    private Context context;

    public EndpointsAsyncTask(Context context) {
        this.context = context;
    }

    @Override
    protected String[] doInBackground(Context... params) {
        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl(context.getString(R.string.android_emu_root_url))
                    .setApplicationName(context.getString(R.string.app_name));
            myApiService = builder.build();
        }

        try {
            List<String> list = myApiService.gceJokes().execute().getJokes();
            String[] jokes = new String[list.size()];
            jokes = list.toArray(jokes);
            return jokes;
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] noData = {context.getString(R.string.error_api_data_fetch)};
        return noData;
    }

    @Override
    protected void onPostExecute(String[] result) {
    }

}