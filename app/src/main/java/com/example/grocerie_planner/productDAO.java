package com.example.grocerie_planner;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface productDAO {


    @Query("select * from product")
    List<Product> getAll();
    @Delete
    void delete(Product p);
    @Insert
    void insertOne(Product p);
}
