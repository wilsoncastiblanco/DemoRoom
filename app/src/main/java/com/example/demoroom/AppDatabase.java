package com.example.demoroom;

import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by wilsoncastiblanco on 9/19/17.
 */
@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    abstract UserDao getUserDao();

}
