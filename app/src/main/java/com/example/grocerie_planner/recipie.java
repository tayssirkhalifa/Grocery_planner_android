package com.example.grocerie_planner;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity(tableName = "recipie")
public class recipie {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "Category")
    String Category;
    @ColumnInfo(name = "instructions")
    String instructions;
    @ColumnInfo(name = "country")
    String country;
    @ColumnInfo(name = "ingredients")
    String ingredients;
    //@ColumnInfo(typeAffinity = ColumnInfo.BLOB)
    //byte[] image;

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public recipie() {
    }



    public recipie(String category, String instructions, String country, String ingredients) {

        this.Category = category;
        this.instructions = instructions;
        this.country = country;
        this.ingredients = ingredients;

    }


}
