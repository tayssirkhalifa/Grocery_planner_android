package com.example.grocerie_planner;

import android.content.Context;

import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


@Database(entities = {Product.class}, version = 1, exportSchema = false)
public abstract class AppDataBaseProduct extends RoomDatabase {

    private static AppDataBaseProduct instance;

    public abstract productDAO productDAO();

    public static AppDataBaseProduct getAppDatabase(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), AppDataBaseProduct.class, "joueur_db")
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }

}