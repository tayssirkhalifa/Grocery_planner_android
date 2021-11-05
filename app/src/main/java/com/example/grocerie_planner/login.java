package com.example.grocerie_planner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {
static String USERNAME_KEY="username";
    //widgets
    EditText username;
    EditText password;
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
        username = findViewById(R.id.emailedittext);
        password = findViewById(R.id.passwordedittext);
        sbutton = findViewById(R.id.sbutton);
        sbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String usernameText=username.getText().toString();
               String passwordText=password.getText().toString();
                if(usernameText.isEmpty()||passwordText.isEmpty() ){
                    Toast.makeText(getApplicationContext(), "fill all field", Toast.LENGTH_SHORT).show();

                }else{
AppDataBase appDataBase=AppDataBase.getInstance(getApplicationContext());
usersDAO usersdao=appDataBase.usersDAO();

new Thread(new Runnable() {
    @Override
    public void run() {
    users users=usersdao.login(usernameText,passwordText);
    if(users==null){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getApplicationContext(), "Invalid ", Toast.LENGTH_SHORT).show();
            }
        });
    }else{
String name= users.getUsername();
startActivity(new Intent(login.this, allcategories.class).putExtra("name",name));
    }
    }
}).start();;
                }
            }
          
        });

    }
}