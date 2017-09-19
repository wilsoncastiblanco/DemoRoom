package com.example.demoroom;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by wilsoncastiblanco on 9/19/17.
 */
@Entity(indices = @Index(value = {"user_name"}, unique = true))
public class User  {

    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "user_name")
    private String userName;

    private String password;

    @Ignore
    private boolean isLogged;

    public Phones getPhones() {
        return phones;
    }

    public void setPhones(Phones phones) {
        this.phones = phones;
    }

    @Embedded
    private Phones phones;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLogged() {
        return isLogged;
    }

    public void setLogged(boolean logged) {
        isLogged = logged;
    }




}
