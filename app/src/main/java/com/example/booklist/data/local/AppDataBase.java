package com.example.booklist.data.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.booklist.models.Films;

@Database(entities = Films.class, version = 1)
public abstract class AppDataBase extends RoomDatabase {
    public abstract AppDao appDao();
}
