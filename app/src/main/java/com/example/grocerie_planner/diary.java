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
    com.example.grocerie_planner.dairyAdapter adapter;
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

        items.add(new Product(30,"diary",R.drawable.diary));
        items.add(new Product(31,"agendas",R.drawable.agendas));
        items.add(new Product(32,"book",R.drawable.book));
        items.add(new Product(33," post",R.drawable.post));


        recyclerView = view.findViewById(R.id.RV);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        adapter = new dairyAdapter(items);
        recyclerView.setAdapter(adapter);

        return view;
    }
}
