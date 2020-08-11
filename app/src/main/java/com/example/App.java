package com.example;

import android.app.Application;

import androidx.appcompat.widget.AppCompatSeekBar;

import com.example.booklist.data.GhibliService;

public class App extends Application {
    public static GhibliService ghibliService;
    @Override
    public void onCreate() {
        super.onCreate();
        ghibliService = new GhibliService();
    }
}
