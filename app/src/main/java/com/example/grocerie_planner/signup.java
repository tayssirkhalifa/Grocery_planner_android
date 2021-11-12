package com.example.grocerie_planner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signup extends AppCompatActivity {

    EditText username,email,password;
    Button Register,login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        username=findViewById(R.id.username);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        Register=findViewById(R.id.register);
        login=findViewById(R.id.login);
login.setOnClickListener((view->{
    Intent intent =new Intent(this,login.class);
    startActivity(intent);

}));
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                users users= new users();
                users.setUsername(username.getText().toString());
                users.setEmail(email.getText().toString());
                users.setPassword(password.getText().toString());
                if(validateInput(users)){
                    //DO insert operation
                    AppDataBase appDataBase= AppDataBase.getInstance(getApplicationContext());
                    usersDAO usersdao=appDataBase.usersDAO();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            usersdao.registerUser(users);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(getApplicationContext(), "user registred", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    }).start();
            }else{
                    Toast.makeText(getApplicationContext(), "fill all fields !", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private Boolean validateInput(users users){
        if( users.getUsername().isEmpty()|| users.getEmail().isEmpty()|| users.getPassword().isEmpty()){
         return false;
        }
        return true;
    }
}