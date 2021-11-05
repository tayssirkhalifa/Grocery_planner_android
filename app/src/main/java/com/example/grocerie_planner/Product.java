package com.example.grocerie_planner;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "product")
public class Product {

    //var
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "textlist")
    private String nom;
    @ColumnInfo(name = "imageslist")
    private int image;

    public Product() {
    }

    public Product(int id, String nom, int image) {
        this.id = id;
        this.nom = nom;
        this.image = image;
    }
    public Product(String nom, int image) {

        this.nom = nom;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", image=" + image +
                '}';
    }
}
