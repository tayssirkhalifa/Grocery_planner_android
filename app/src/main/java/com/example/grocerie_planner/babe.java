package com.example.grocerie_planner;

import androidx.fragment.app.Fragment;
import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;

public class babe  {
    //var
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "textlist")
    private String nom;
    @ColumnInfo(name = "imageslist")
    private int image;

    public babe() {
    }

    public babe(int id, String nom, int image) {
        this.id = id;
        this.nom = nom;
        this.image = image;
    }
    public babe(String nom, int image) {

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
        return "babe{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", image=" + image +
                '}';
    }

}
