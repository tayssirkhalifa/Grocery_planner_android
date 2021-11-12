package com.example.grocerie_planner;

import android.content.Context;

import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
@Database(entities ={users.class},version=1,exportSchema = false)
public abstract class AppDataBase extends RoomDatabase {

    //var
    private static AppDataBase instance;
    private static String DATABASE_NAME ="database";
    public static AppDataBase getInstance(Context context ){
        if(instance==null){
            instance= Room.databaseBuilder(context.getApplicationContext(),AppDataBase.class,DATABASE_NAME).fallbackToDestructiveMigration().allowMainThreadQueries().build();

        }
        return instance;
    }

    public abstract usersDAO usersDAO();

}
