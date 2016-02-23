package com.paytimereminder.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.paytimereminder.R;
import com.paytimereminder.Service.LoginService;

public class LoginActivity extends AppCompatActivity {

    private Context context;
    LoginService loginService;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginService = new LoginService(this);
        setContentView(R.layout.activity_login);
        context = this;
//        usernameEditText.addTextChangedListener(textWatch);
        //TODO: Enable button only when both edit text has value in them
        findViewById(R.id.loginButton).setOnClickListener(HandleLoginButtonClick(savedInstanceState));
    }

    private View.OnClickListener HandleLoginButtonClick(final Bundle savedInstanceState) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText usernameEditText = (EditText) findViewById(R.id.username);
                final EditText passwordEditText = (EditText) findViewById(R.id.password);
                if(loginService.login(usernameEditText.getText().toString(), passwordEditText.getText().toString()))
                {
                    Intent intent = new Intent(context, HomeActivity.class);
                    startActivity(intent, savedInstanceState);
                }
            }
        };
    }
}