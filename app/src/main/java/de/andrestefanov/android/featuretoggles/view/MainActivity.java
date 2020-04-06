package de.andrestefanov.android.featuretoggles.view;

import android.os.Bundle;

import de.andrestefanov.android.featuretoggles.R;
import de.andrestefanov.android.featuretoggles.di.DaggerFragmentActivity;

public class MainActivity extends DaggerFragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

}
