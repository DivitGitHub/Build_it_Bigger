package com.udacity.gradle.builditbigger.free;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.divitngoc.android.myandroidlib.JokeActivity;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.udacity.gradle.builditbigger.EndpointsAsyncTask;
import com.udacity.gradle.builditbigger.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainActivityFragment extends Fragment {

    InterstitialAd mInterstitialAd;
    ProgressBar mProgressBar;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        mProgressBar = root.findViewById(R.id.pb_loading_indicator);

        setupAdBanner(root);
        setupInterstitialAd();

        Button button = root.findViewById(R.id.button_tell_joke);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("free", "The interstitial wasn't loaded yet.");
                }
            }
        });

        return root;
    }

    public void setupInterstitialAd() {
        mInterstitialAd = new InterstitialAd(getActivity());
        mInterstitialAd.setAdUnitId(getString(R.string.test_ad_unit_id));
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                // Code to be executed when an ad request fails.
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when the ad is displayed.
            }

            @Override
            public void onAdLeftApplication() {
                // Code to be executed when the user has left the app.
            }

            @Override
            public void onAdClosed() {
                new EndpointsAsyncTask(getActivity()) {
                    @Override
                    protected void onPreExecute() {
                        super.onPreExecute();
                        mProgressBar.setVisibility(View.VISIBLE);
                    }

                    @Override
                    protected void onPostExecute(String[] result) {
                        mProgressBar.setVisibility(View.INVISIBLE);
                        startJokeActivity(result);
                    }
                }.execute();
            }
        });
        mInterstitialAd.loadAd(new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build());
    }

    private void startJokeActivity(String[] jokes) {
        Intent intent = new Intent(getContext(), JokeActivity.class );
        intent.putExtra(JokeActivity.INTENT_JOKE, jokes);
        getContext().startActivity(intent);
    }

    public void setupAdBanner(View root) {
        AdView mAdView = root.findViewById(R.id.adView);

        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);
    }

}
