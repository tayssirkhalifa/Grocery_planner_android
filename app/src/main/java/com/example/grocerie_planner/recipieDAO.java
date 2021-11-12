package com.example.grocerie_planner;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface recipieDAO {

    @Query("Select * from recipie")
    List<recipie> getAllrecipes();
    @Insert
    void insertrecipe(recipie R);
    @Update
    void updaterecipie(recipie recipie);
    @Delete
    void deleterecipi(recipie recipie);

}
