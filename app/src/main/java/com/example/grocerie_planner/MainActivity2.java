package com.example.grocerie_planner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
static String USERNAME_KEY="username";
    //widgets
    EditText usernameEt;
    EditText passwordET;
    Button sbutton;
    public SharedPreferences sp;
    public final static String LOGIN ="mlogin";
    public static String PASSWD="mpassword";
    public static String SHARED_PASSWORD="mainshared";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //init widgets
        usernameEt =findViewById(R.id.emailedittext);
        passwordET=findViewById(R.id.passwordedittext);
        sbutton=findViewById(R.id.sbutton);
        //..
        String username=usernameEt.getText().toString();
        String password =passwordET.getText().toString();
         sbutton.setOnClickListener( view ->{
             if (username=="tayssir" && password=="pass")
             {
                 Intent intent=new Intent(this,MainActivity3.class);
                 intent.putExtra(USERNAME_KEY,username);
             }
                 else{
                 Toast.makeText(this, "verifier vos donnée", Toast.LENGTH_SHORT).show();

             }


           });

    }
}