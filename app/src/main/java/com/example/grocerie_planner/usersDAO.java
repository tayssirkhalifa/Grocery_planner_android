package com.example.grocerie_planner;

import androidx.room.Dao;
import androidx.room.Insert;

@Dao
public interface usersDAO {
@Insert
    void registerUser(users users);
}
