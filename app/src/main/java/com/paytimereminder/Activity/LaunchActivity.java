package com.paytimereminder.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.paytimereminder.R;
import com.paytimereminder.Service.StartupService;

public class LaunchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        final Context context = this;
        final boolean startupActivityDone = new StartupService(context).StartupActivity();

        //Will get rid of it once startup activity is taking more than that
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (startupActivityDone) {
                    Intent intent = new Intent(context, LoginActivity.class);
                    startActivity(intent, savedInstanceState);
                }
            }
        }, 5000);
    }
}