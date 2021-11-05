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
    com.example.grocerie_planner.Adapter adapter;
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

        items.add(new Product(1,"baby bottle",R.drawable.bibron));
        items.add(new Product(2,"baby bottle",R.drawable.bibron));
        items.add(new Product(3,"baby bottle",R.drawable.bibron));
        items.add(new Product(4,"baby bottleh",R.drawable.bibron));
        items.add(new Product(5,"baby bottleh",R.drawable.bibron));
        items.add(new Product(6,"baby bottle",R.drawable.bibron));
        items.add(new Product(7,"baby bottle",R.drawable.bibron));
        items.add(new Product(8,"baby bottle",R.drawable.bibron));
        items.add(new Product(9,"baby bottle",R.drawable.bibron));
        items.add(new Product(10,"baby bottle",R.drawable.bibron));


        recyclerView = view.findViewById(R.id.RV);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        adapter = new Adapter(items);
        recyclerView.setAdapter(adapter);

        return view;
    }
}
