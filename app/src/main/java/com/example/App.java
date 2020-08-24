package com.example;

import android.app.Application;

import androidx.room.Room;

import com.example.booklist.data.local.AppDataBase;
import com.example.booklist.data.network.CatsFactService;
import com.example.booklist.data.network.GhibliService;

public class App extends Application {
    public static GhibliService ghibliService;
    public static CatsFactService catsFactService;
    public static AppDataBase appDataBase;
    @Override
    public void onCreate() {
        super.onCreate();
        ghibliService = new GhibliService();
        catsFactService = new CatsFactService();
        appDataBase = Room.databaseBuilder(this,
                AppDataBase.class ,
                "data_base").allowMainThreadQueries()
                .build();
    }
}
