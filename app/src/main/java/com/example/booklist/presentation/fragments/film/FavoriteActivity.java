package com.example.booklist.presentation.fragments.film;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.App;
import com.example.booklist.R;
import com.example.booklist.models.Films;
import com.example.booklist.presentation.adapters.FavoriteFilmAdapter;

import java.util.List;

public class FavoriteActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private FavoriteFilmAdapter adapter;
    private List<Films> favList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);
        recyclerView = findViewById(R.id.favorite_rv);
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.HORIZONTAL));
        favList = App.appDataBase.appDao().getAll();
        adapter = new FavoriteFilmAdapter(favList);
        recyclerView.setAdapter(adapter);
    }
}
