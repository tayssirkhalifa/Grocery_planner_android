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

import java.util.List;

public class BabyAdapter extends RecyclerView.Adapter<BabyAdapter.ViewHolder>{
    private LayoutInflater layoutInflater;
    private AppDataBaseProduct database;
    private List<Product> Recap;
    private Context mContext;
    ImageView imageView;

    public BabyAdapter(List<Product> contacts) {

        Recap = contacts;
        this.Recap = Recap;

    }

    @NonNull
    @Override
    public com.example.grocerie_planner.BabyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        database = AppDataBaseProduct.getAppDatabase(context);
        View contactView = inflater.inflate(R.layout.items, parent, false);

        // Return a new holder instance
        BabyAdapter.ViewHolder viewHolder = new BabyAdapter.ViewHolder(contactView);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull com.example.grocerie_planner.BabyAdapter.ViewHolder holder, int position) {

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
                    int img = 10;
                    if (textView.getText().toString().equals("bottle")) {
                        img = 10;

                    } else if (textView.getText().toString().equals("pacifier")) {
                        img = 11;
                        System.out.println("hh");
                    } else if (textView.getText().toString().equals("storagebox")) {
                        img = 12;
                    } else if (textView.getText().toString().equals("construction")){
                        img = 13;
                    }else if (textView.getText().toString().equals("piano")) {
                        img = 14;
                    }else{
                        img = 0;

                    }
                    System.out.println(img);
                    System.out.println(textView.getText().toString());


                    Product tmpUser = new Product(textView.getText().toString(), img);

                    database.productDAO().insertOne(tmpUser);
                    Toast.makeText(itemView.getContext(),"Product added",Toast.LENGTH_SHORT).show();

                }
            });

        }
    }
}
