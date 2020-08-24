package com.example.booklist.presentation.fragments.film;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.App;
import com.example.booklist.R;
import com.example.booklist.models.Films;
import com.example.booklist.utils.Config;

public class InfoActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView textInfo;
    private TextView textName;
    private Button likeBtn;
    private Films films;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        textInfo = findViewById(R.id.book_info_textview);
        textName = findViewById(R.id.book);
        Intent intent = getIntent();
       films = (Films) intent.getSerializableExtra(Config.POSITION);
       Log.d("pop",films.getDescription());
        textInfo.setText(films.getDescription());
        textName.setText(films.getTitle());
        likeBtn= findViewById(R.id.like_btn);
        likeBtn.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        App.appDataBase.appDao().insert(films);
        Toast.makeText(this, "Запись успешно добавлена!", Toast.LENGTH_SHORT).show();
    }
}
