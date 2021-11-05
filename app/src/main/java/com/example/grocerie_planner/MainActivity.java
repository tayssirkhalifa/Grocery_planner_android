package com.example.grocerie_planner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    //widgets
     Button signup;
     Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //init widgets
        login = findViewById(R.id.login);
        signup =findViewById(R.id.signup);

        login.setOnClickListener(view->{
            Intent intent =new Intent(this, com.example.grocerie_planner.login.class);
            startActivity(intent);
            finish();
        });

        signup.setOnClickListener(view->{
            Intent intent =new Intent(this,signup.class);
            startActivity(intent);
            finish();
        });
    }
}