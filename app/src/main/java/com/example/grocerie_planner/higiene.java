package com.example.grocerie_planner;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class higiene  extends Fragment {
    RecyclerView recyclerView;
    com.example.grocerie_planner.HigieneAdapter adapter;
    ArrayList<Product> items;


    public higiene(){}
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_products, container, false);


        items = new ArrayList<>();

        items.add(new Product(40,"toiletpaper",R.drawable.toiletpaper));
        items.add(new Product(41,"handwash",R.drawable.handwash));
        items.add(new Product(42,"cotton",R.drawable.cotton));
        items.add(new Product(43,"spray",R.drawable.spray));



        recyclerView = view.findViewById(R.id.RV);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        adapter = new HigieneAdapter(items);
        recyclerView.setAdapter(adapter);

        return view;
    }
}
