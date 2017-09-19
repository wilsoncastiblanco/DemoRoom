package com.example.demoroom;

import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * Created by wilsoncastiblanco on 9/19/17.
 */

public class DatabaseManager {

    private static DatabaseManager INSTANCE;
    private AppDatabase database;

    public static void init(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new DatabaseManager(context);
        }
    }

    public static DatabaseManager getInstance(){
        return INSTANCE;
    }

    public AppDatabase getDatabase(){
        return database;
    }

    private DatabaseManager(Context context) {
        database = Room.databaseBuilder(context.getApplicationContext(),
                AppDatabase.class,
                "demo-room"
        ).build();
    }
}
