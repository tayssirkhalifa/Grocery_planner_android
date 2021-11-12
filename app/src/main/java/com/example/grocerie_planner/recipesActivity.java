package com.example.grocerie_planner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.grocerie_planner.adapter.recipieListAdapter;

import java.util.List;

public class recipesActivity extends AppCompatActivity {
    Button sp, add, paellatv, saladetv;
    ImageView mimaget;
    TextView mtextt, paellatx, saladetx;
    recipie recipie;
    RecyclerView recyclerView;
    private recipieListAdapter recipielistAdapter;
    public recipieDataBase database;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);
        recyclerView = findViewById(R.id.recycleview);

        sp = findViewById(R.id.sp);
        add = findViewById(R.id.add);
        paellatv = findViewById(R.id.paella);
        paellatx = findViewById(R.id.paellatx);
        saladetv = findViewById(R.id.saladetv);
        saladetx = findViewById(R.id.saladetx);

        getData();

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AddrecipeActivity.class);
                startActivity(intent);

            }
        });
        sp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), souperecipeActivity.class);
                startActivity(intent);

            }
        });
        paellatv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), paellarecipeActivity.class);
                startActivity(intent);


            }
        });

        saladetv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), saladerecipeActivity.class);
                startActivity(intent);


            }
        });


    }


    private void getData() {

        recyclerView.setAdapter(new recipieListAdapter(getApplicationContext(), recipieDataBase.getInstance(getApplicationContext()).recipieDAO().getAllrecipes()));
        System.out.println(recipieDataBase.getInstance(getApplicationContext()).recipieDAO().getAllrecipes().toArray().length);

    }
}