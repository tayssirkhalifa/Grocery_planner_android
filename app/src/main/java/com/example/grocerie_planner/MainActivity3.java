package com.example.grocerie_planner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
//var
    String username;
    //widgets
    TextView usernametv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent =getIntent();
        username=intent.getStringExtra(login.USERNAME_KEY);

        setContentView(R.layout.activity_main3);
        //init widgets
        usernametv =findViewById(R.id.emailedittext);

    }
}