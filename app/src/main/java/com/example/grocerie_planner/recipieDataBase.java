package com.example.grocerie_planner;

import android.content.Context;

import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
@Database(entities ={recipie.class},version=2,exportSchema = false)
public abstract class recipieDataBase extends RoomDatabase {

    //var
    private static recipieDataBase instance;
    private static String DATABASE_NAME ="database";
    public abstract recipieDAO recipieDAO();
    public static recipieDataBase getInstance(Context context ){
        if(instance==null){
            instance= Room.databaseBuilder(context.getApplicationContext(),recipieDataBase.class,DATABASE_NAME).fallbackToDestructiveMigration().allowMainThreadQueries().build();

        }
        return instance;
    }



}
