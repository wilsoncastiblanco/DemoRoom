package com.example.demoroom;

import android.app.Application;

/**
 * Created by wilsoncastiblanco on 9/19/17.
 */

public class GlobantApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        DatabaseManager.init(getApplicationContext());
    }
}
