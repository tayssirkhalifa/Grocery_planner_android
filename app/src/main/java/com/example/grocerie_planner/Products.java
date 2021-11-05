package com.example.grocerie_planner;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Products extends Fragment {
    RecyclerView recyclerView;
    com.example.grocerie_planner.Adapter adapter;
    ArrayList<Product> items;

    public Products() {

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

        items.add(new Product(1,"Burger",R.drawable.hamburger));
        items.add(new Product(2,"Pizza",R.drawable.pizza));
        items.add(new Product(3,"HotDog",R.drawable.hotdog));
        items.add(new Product(4,"Noodels",R.drawable.noodle));
        items.add(new Product(5,"Noodels",R.drawable.salad));
        items.add(new Product(6,"Noodels",R.drawable.salad));
        items.add(new Product(7,"Noodels",R.drawable.salad));
        items.add(new Product(8,"Noodels",R.drawable.rice));
        items.add(new Product(9,"Fries",R.drawable.fries));
        items.add(new Product(10,"Drinks",R.drawable.drink));


        recyclerView = view.findViewById(R.id.RV);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        adapter = new Adapter(items);
        recyclerView.setAdapter(adapter);

        return view;
    }
}
