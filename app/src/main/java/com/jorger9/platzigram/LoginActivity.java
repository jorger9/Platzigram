package com.jorger9.platzigram;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.jorger9.platzigram.view.ContainerActivity;
import com.jorger9.platzigram.view.CreateAccountActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void goCreateAccount(View view){

        Intent intent = new Intent(this, CreateAccountActivity.class);
        startActivity(intent);
    }


    public void goContainerActivity(View view){

        Intent intent = new Intent(this, ContainerActivity.class);
        startActivity(intent);
    }

    public void openURL(View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW);
        browserIntent.setData(Uri.parse("http://www.platzigram.com"));
        startActivity(browserIntent);
    }

}
