package com.example.grocerie_planner;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class MyList extends Fragment {
    private AppDataBaseProduct database ;
    private List<Product> A = new ArrayList<Product>();
    private RecyclerView mRecyclerView;
    private ListAdapter adapterList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_my_list,container,false);

        database = AppDataBaseProduct.getAppDatabase(getActivity().getApplicationContext());

        mRecyclerView = rootView.findViewById(R.id.RV);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        A = database.productDAO().getAll();

        adapterList = new ListAdapter(getActivity(),A);

        mRecyclerView.setAdapter(adapterList);


        return rootView;
    }
}
