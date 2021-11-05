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
    com.example.grocerie_planner.Adapter adapter;
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

        items.add(new Product(1,"nail Polish",R.drawable.nailpolish));
        items.add(new Product(2,"nail Polish",R.drawable.nailpolish));
        items.add(new Product(3,"nail Polish",R.drawable.nailpolish));
        items.add(new Product(4,"nail Polish",R.drawable.nailpolish));
        items.add(new Product(5,"nail Polish",R.drawable.nailpolish));
        items.add(new Product(6,"nail Polish",R.drawable.nailpolish));
        items.add(new Product(7,"nail Polish",R.drawable.nailpolish));
        items.add(new Product(8,"nail Polish",R.drawable.nailpolish));
        items.add(new Product(9,"nail Polish",R.drawable.nailpolish));
        items.add(new Product(10,"nail Polish",R.drawable.nailpolish));


        recyclerView = view.findViewById(R.id.RV);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        adapter = new Adapter(items);
        recyclerView.setAdapter(adapter);

        return view;
    }

}
