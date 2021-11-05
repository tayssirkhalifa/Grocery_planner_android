package com.example.grocerie_planner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class babyActivity extends AppCompatActivity {
    //var
    private java.util.List<Product> productList=new ArrayList<>();
    Button home,List;

    //widgets
    private RecyclerView mRecycleview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baby);
        home = findViewById(R.id.Home);
        List = findViewById(R.id.List);
        run();
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new baby()).commit();
            }
        });
        List.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new MyList()).commit();
            }
        });
    }
    public void run() {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new baby()).commit();
    }
}