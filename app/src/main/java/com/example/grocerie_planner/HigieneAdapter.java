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

public class HigieneAdapter extends RecyclerView.Adapter<HigieneAdapter.ViewHolder>{
    private LayoutInflater layoutInflater;
    private AppDataBaseProduct database;
    private List<Product> Recap;
    private Context mContext;
    ImageView imageView;

    public HigieneAdapter(List<Product> contacts) {

        Recap = contacts;
        this.Recap = Recap;

    }

    @NonNull
    @Override
    public HigieneAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        database = AppDataBaseProduct.getAppDatabase(context);
        View contactView = inflater.inflate(R.layout.items, parent, false);

        // Return a new holder instance
        HigieneAdapter.ViewHolder viewHolder = new HigieneAdapter.ViewHolder(contactView);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull HigieneAdapter.ViewHolder holder, int position) {

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
                    System.out.println(textView.getText().toString());
                    System.out.println("hh");
                    int img = 10;
                    if (textView.getText().toString().equals("toiletpaper")) {
                        img = 40;
                    } else if (textView.getText().toString().equals("handwash")) {
                        img = 41;
                        System.out.println("hh");
                    } else if (textView.getText().toString().equals("cotton")) {
                        img = 42;
                    } else if (textView.getText().toString().equals("spray")){
                        img = 43;
                    }else if (textView.getText().toString().equals("toiletpaper")) {
                        img = 44;
                    }else{
                        img = 40;
                    }
                    System.out.println("text "+img);
                    System.out.println(textView.getText().toString());
                    System.out.println("ggg");


                    Product tmpUser = new Product(textView.getText().toString(), img);

                    database.productDAO().insertOne(tmpUser);
                    Toast.makeText(itemView.getContext(),"Product added",Toast.LENGTH_SHORT).show();

                }
            });

        }
    }
}
