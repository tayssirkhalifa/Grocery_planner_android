package com.example.grocerie_planner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.grocerie_planner.adapter.recipieListAdapter;

public class recycleview extends AppCompatActivity {

    //widget
    RecyclerView recyclerView;
    //var
    private recipieDataBase recipieDataBase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycleview);
        //binding
        recyclerView=findViewById(R.id.mrecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(new recipieListAdapter(getApplicationContext(),recipieDataBase.getInstance(getApplicationContext()).recipieDAO().getAllrecipes()));
    }
}