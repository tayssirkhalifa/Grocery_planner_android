package com.example.grocerie_planner;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class spices extends Fragment {
    RecyclerView recyclerView;
    com.example.grocerie_planner.Adapter adapter;
    ArrayList<Product> items;

    public spices(){

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_products, container, false);


        items = new ArrayList<>();

        items.add(new Product(1,"Ginger",R.drawable.ginger));
        items.add(new Product(2,"Ginger",R.drawable.ginger));
        items.add(new Product(3,"Ginger",R.drawable.ginger));
        items.add(new Product(4,"Ginger",R.drawable.ginger));
        items.add(new Product(5,"Ginger",R.drawable.ginger));
        items.add(new Product(6,"Ginger",R.drawable.ginger));
        items.add(new Product(7,"Ginger",R.drawable.ginger));
        items.add(new Product(8,"Ginger",R.drawable.ginger));
        items.add(new Product(9,"Ginger",R.drawable.ginger));
        items.add(new Product(10,"Ginger",R.drawable.ginger));


        recyclerView = view.findViewById(R.id.RV);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        adapter = new Adapter(items);
        recyclerView.setAdapter(adapter);

        return view;
    }

}



