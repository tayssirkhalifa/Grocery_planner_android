package com.example.grocerie_planner;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class beauty  extends Fragment {

    RecyclerView recyclerView;
    com.example.grocerie_planner.beaytyAdapter adapter;
    ArrayList<Product> items;


    public beauty(){}
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_products, container, false);


        items = new ArrayList<>();

        items.add(new Product(20,"Polish",R.drawable.nailpolish));
        items.add(new Product(21,"cosmetics",R.drawable.cosmetics));
        items.add(new Product(22,"salon",R.drawable.salon));
        items.add(new Product(23,"parfum",R.drawable.parfum));
        items.add(new Product(24,"mirror",R.drawable.mirror));



        recyclerView = view.findViewById(R.id.RV);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        adapter = new beaytyAdapter(items);
        recyclerView.setAdapter(adapter);

        return view;
    }

}
