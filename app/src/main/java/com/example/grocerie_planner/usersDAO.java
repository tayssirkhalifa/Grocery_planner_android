package com.example.grocerie_planner;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface usersDAO {

@Insert
    void registerUser(users users);
@Query("select * from users where username=(:username) and password=(:password)")
    users login(String username, String password);

}
