package com.example.grocerie_planner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class allcategories extends AppCompatActivity {
Button food,spices,higiene,beauty,baby,diary;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        food=findViewById(R.id.fooddrinks);
        spices=findViewById(R.id.spices);
        higiene=findViewById(R.id.higiene);
        beauty=findViewById(R.id.beauty);
        baby=findViewById(R.id.baby);
        diary=findViewById(R.id.Diary);
        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getApplicationContext(),food.class);
                startActivity(intent);

            }
        });

        spices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getApplicationContext(),SpiceActivity.class);
                startActivity(intent);

            }
        });

        higiene.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getApplicationContext(),higieneActivity.class);
                startActivity(intent);

            }
        });

        beauty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getApplicationContext(),beautyActivity.class);
                startActivity(intent);

            }
        });

        baby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getApplicationContext(),babyActivity.class);
                startActivity(intent);

            }
        });

        diary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getApplicationContext(),diaryActivity.class);
                startActivity(intent);

            }
        });



    }
}