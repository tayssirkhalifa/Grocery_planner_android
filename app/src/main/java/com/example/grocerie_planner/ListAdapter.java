package com.example.grocerie_planner;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.grocerie_planner.AppDataBaseProduct;
import com.example.grocerie_planner.Product;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder>{

    private Context mContext;
    private List<Product> products;

    public ListAdapter(Context mContext, List<Product> products) {
        this.mContext = mContext;
        this.products = products;
    }

    public void notifyChange(List<Product> users){
        this.products = users;
        this.notifyDataSetChanged();
    }
    @NonNull
    @Override
    public com.example.grocerie_planner.ListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.activity_itemlist, parent, false);
        return new com.example.grocerie_planner.ListAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull com.example.grocerie_planner.ListAdapter.ViewHolder holder, int position) {

        final Product singleItem = products.get(position);

        holder.textView.setText(singleItem.getNom());
        if(singleItem.getImage()==1){
            holder.imageView.setImageResource(R.drawable.hamburger);
        }
        else if (singleItem.getImage()==2){
            holder.imageView.setImageResource(R.drawable.pizza);
        }
        else if (singleItem.getImage()==3) {
            holder.imageView.setImageResource(R.drawable.hotdog);
        }
        else {
            holder.imageView.setImageResource(R.drawable.noodle);
        }

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppDataBaseProduct.getAppDatabase(mContext).productDAO().delete(singleItem);
                com.example.grocerie_planner.ListAdapter.this.notifyChange(
                        AppDataBaseProduct.getAppDatabase(mContext).productDAO().getAll());
                Toast.makeText(mContext,"product deleted",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return products != null ? products.size() : 0;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        ImageView imageView;
        Button delete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.mtextviewlist);
            imageView = itemView.findViewById(R.id.mImageViewlist);
            delete = itemView.findViewById(R.id.delete);
        }
    }
}
