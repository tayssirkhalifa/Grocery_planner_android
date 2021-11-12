package com.example.grocerie_planner.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.grocerie_planner.Product;
import com.example.grocerie_planner.R;
import com.example.grocerie_planner.recipesActivity;
import com.example.grocerie_planner.recipie;

import java.util.List;

public class recipieListAdapter extends RecyclerView.Adapter<recipieListAdapter.ViewHolder> {
    Context context;
    List<recipie> list;
    DeleteItemClicklistner deleteItemClicklistner;

    public recipieListAdapter(Context context, List<recipie> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.receipt_adapter, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        System.out.println(list.get(position));
        if(list != null){
            System.out.println("Adding an element to recyclerView");
            holder.category.setText(list.get(position).getCategory());
        }else
            Log.e(getClass().getSimpleName(),"model object is Null...");
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView category;
        ImageView receiptImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            category = itemView.findViewById(R.id.receiptCategoryText);
            receiptImage = itemView.findViewById(R.id.receiptImage);
        }
    }

    public interface DeleteItemClicklistner {
        void onItemDelete(int position, int id);
    }


}