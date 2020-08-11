package com.example.booklist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.App;
import com.example.booklist.data.GhibliService;
import com.example.booklist.intefaces.IonItemClick;
import com.example.booklist.models.BooksModel;
import com.example.booklist.models.Films;
import com.example.booklist.presentation.FilmListAdapter;
import com.example.booklist.presentation.InfoActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity implements IonItemClick, GhibliService.GhibliCallback {
    private RecyclerView recyclerView;
    private FilmListAdapter adapter;
    private  List<Films> filmsList;
    public static final String KYE = "key";
    public static final String ID = "key";
   ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        App.ghibliService.getFilms(this);
        recyclerView = findViewById(R.id.recycler);

    }

    @Override
    public void OnClick(int position) {
        Films film = filmsList.get(position);
        Log.d("pop",film.getTitle());
                Intent intent =  new Intent(MainActivity.this, InfoActivity.class);
                intent.putExtra(ID,film);
                startActivity(intent);
    }

    @Override
    public void onSuccess(List<Films> films) {
        filmsList = films;
        adapter = new FilmListAdapter(filmsList,this);
        recyclerView.addItemDecoration
                (new DividerItemDecoration(getApplicationContext(),DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onFailure(Exception ex) {
        Toast.makeText(this, "Ошибка :"+ ex.getMessage(), Toast.LENGTH_SHORT).show();
    }
}
