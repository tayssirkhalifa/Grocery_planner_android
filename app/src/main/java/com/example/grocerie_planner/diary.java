package com.example.grocerie_planner;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class diary extends Fragment {
    RecyclerView recyclerView;
    com.example.grocerie_planner.Adapter adapter;
    ArrayList<Product> items;


    public diary(){}
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_products, container, false);


        items = new ArrayList<>();

        items.add(new Product(1,"diary",R.drawable.diary));
        items.add(new Product(2,"diary",R.drawable.diary));
        items.add(new Product(3,"diary",R.drawable.diary));
        items.add(new Product(4," diary",R.drawable.diary));
        items.add(new Product(5,"diary",R.drawable.diary));


        recyclerView = view.findViewById(R.id.RV);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        adapter = new Adapter(items);
        recyclerView.setAdapter(adapter);

        return view;
    }
}
