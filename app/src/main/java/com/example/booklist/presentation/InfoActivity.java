package com.example.booklist.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.booklist.MainActivity;
import com.example.booklist.R;
import com.example.booklist.data.TestRepozitory;
import com.example.booklist.models.BooksModel;
import com.example.booklist.models.Films;

import java.util.ArrayList;
import java.util.List;

public class InfoActivity extends AppCompatActivity {
    private TextView textInfo;
    private TextView textName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        textInfo = findViewById(R.id.book_info_textview);
        textName = findViewById(R.id.book);
        Intent intent = getIntent();
       Films films = (Films) intent.getSerializableExtra(MainActivity.ID);
       Log.d("pop",films.getDescription());
        textInfo.setText(films.getDescription());
        textName.setText(films.getTitle());


    }
}
