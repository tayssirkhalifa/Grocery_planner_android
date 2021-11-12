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
        else if (singleItem.getImage()==4) {
            holder.imageView.setImageResource(R.drawable.noodle);
        }
        else if (singleItem.getImage()==5) {
            holder.imageView.setImageResource(R.drawable.salad);
        }
        else if (singleItem.getImage()==6) {
            holder.imageView.setImageResource(R.drawable.rice);
        }
        else if (singleItem.getImage()==7) {
            holder.imageView.setImageResource(R.drawable.fries);
        }
        else if (singleItem.getImage()==8) {
            holder.imageView.setImageResource(R.drawable.drink);
        }
        else if (singleItem.getImage()==10) {
            holder.imageView.setImageResource(R.drawable.bibron);
        }
        else if (singleItem.getImage()==11) {
            holder.imageView.setImageResource(R.drawable.pacifier);
        }

        else if (singleItem.getImage()==12) {
            holder.imageView.setImageResource(R.drawable.storagebox);
        }
        else if (singleItem.getImage()==13) {
            holder.imageView.setImageResource(R.drawable.construction);
        } else if (singleItem.getImage()==14) {
            holder.imageView.setImageResource(R.drawable.piano);
        }
        else if (singleItem.getImage()==20) {
            holder.imageView.setImageResource(R.drawable.nailpolish);
        }
        else if (singleItem.getImage()==21) {
            holder.imageView.setImageResource(R.drawable.cosmetics);
        }
        else if (singleItem.getImage()==22) {
            holder.imageView.setImageResource(R.drawable.salon);
        }
        else if (singleItem.getImage()==23) {
            holder.imageView.setImageResource(R.drawable.parfum);
        }
        else if (singleItem.getImage()==24) {
            holder.imageView.setImageResource(R.drawable.mirror);
        }
        else if (singleItem.getImage()==30) {
            holder.imageView.setImageResource(R.drawable.diary);
        }
        else if (singleItem.getImage()==31) {
            holder.imageView.setImageResource(R.drawable.agendas);
        }
        else if (singleItem.getImage()==32) {
            holder.imageView.setImageResource(R.drawable.book);
        }
        else if (singleItem.getImage()==33) {
            holder.imageView.setImageResource(R.drawable.post);
        }

        else if (singleItem.getImage()==40) {
            holder.imageView.setImageResource(R.drawable.toiletpaper);
        }
        else if (singleItem.getImage()==41) {
            holder.imageView.setImageResource(R.drawable.toiletpaper);
        }
        else if (singleItem.getImage()==42) {
            holder.imageView.setImageResource(R.drawable.handwash);
        }
        else if (singleItem.getImage()==43) {
            holder.imageView.setImageResource(R.drawable.cotton);
        }
        else if (singleItem.getImage()==44) {
            holder.imageView.setImageResource(R.drawable.spray);
        }

        else if (singleItem.getImage()==45) {
            holder.imageView.setImageResource(R.drawable.toiletpaper);
        }
        else if (singleItem.getImage()==50) {
            holder.imageView.setImageResource(R.drawable.ginger);
        }
        else if (singleItem.getImage()==60) {
            holder.imageView.setImageResource(R.drawable.curcum);
        }
        else if (singleItem.getImage()==70) {
            holder.imageView.setImageResource(R.drawable.yan);
        }
        else if (singleItem.getImage()==80) {
            holder.imageView.setImageResource(R.drawable.pepper);
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
