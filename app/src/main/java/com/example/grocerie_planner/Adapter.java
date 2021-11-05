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

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private LayoutInflater layoutInflater;
    private AppDataBaseProduct database;
    private List<Product> Recap;
    private Context mContext;
    ImageView imageView;

    public Adapter(List<Product> contacts) {

        Recap = contacts;
        this.Recap = Recap;

    }

    @NonNull
    @Override
    public com.example.grocerie_planner.Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        database = AppDataBaseProduct.getAppDatabase(context);
        View contactView = inflater.inflate(R.layout.items, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull com.example.grocerie_planner.Adapter.ViewHolder holder, int position) {

        Product recap = Recap.get(position);
        TextView textView = holder.textView;
        textView.setText(recap.getNom());
        holder.imageView.setImageResource(recap.getImage());


    }

    @Override
    public int getItemCount() {
        return Recap.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;
        Button Add;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // Context context = parent.getContext();
            textView = itemView.findViewById(R.id.mtextview);
            imageView = itemView.findViewById(R.id.mImageView);

            Add = itemView.findViewById(R.id.valider);


            Add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int img = 0;
                    if (textView.getText().toString().equals("Burger")) {
                        img = 1;
                    } else if (textView.getText().toString().equals("Pizza")) {
                        img = 2;
                    } else if (textView.getText().toString().equals("ccc")) {
                        img = 3;
                    } else {
                        img = 4;
                    }

                    Product tmpUser = new Product(textView.getText().toString(), img);

                    database.productDAO().insertOne(tmpUser);
                    Toast.makeText(itemView.getContext(),"Product added",Toast.LENGTH_SHORT).show();

                }
            });

        }
    }
}
