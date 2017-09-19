package com.example.demoroom;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

/**
 * Created by wilsoncastiblanco on 9/19/17.
 */
@Dao
public interface UserDao {

    @Query("SELECT * FROM user " +
            "WHERE password = :password " +
            " AND user_name = :userName " +
            " LIMIT 1")
    User login(String userName, String password);

    @Insert
    Long insert(User user);
}
