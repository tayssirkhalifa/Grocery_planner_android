package com.example.grocerie_planner;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class baby extends Fragment {
    RecyclerView recyclerView;
    com.example.grocerie_planner.BabyAdapter adapter;
    ArrayList<Product> items;


    public baby(){}
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_products, container, false);


        items = new ArrayList<>();

        items.add(new Product(10,"bottle",R.drawable.bibron));
        items.add(new Product(11,"pacifier",R.drawable.pacifier));
        items.add(new Product(12,"storagebox",R.drawable.storagebox));
        items.add(new Product(13,"construction",R.drawable.construction));
        items.add(new Product(14,"piano",R.drawable.piano));



        recyclerView = view.findViewById(R.id.RV);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        adapter = new BabyAdapter(items);
        recyclerView.setAdapter(adapter);

        return view;
    }
}
