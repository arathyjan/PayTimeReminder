package com.paytimereminder.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.paytimereminder.Fragment.PayTimeListFragment;
import com.paytimereminder.R;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.MainContainer, PayTimeListFragment.newInstance())
                .commit();
    }
}