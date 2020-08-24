package com.example.booklist.data.local;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.booklist.models.Films;

import java.util.List;
@Dao
public interface AppDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Films films);

    @Query("SELECT * FROM Films")
    List<Films> getAll();
}
