package com.example.booklist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity {
    private TextView textInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        textInfo = findViewById(R.id.book_info_textview);
        Intent intent = getIntent();
        int pos = intent.getIntExtra(MainActivity.KYE, 0);
        switch (pos) {
            case 0:
                textInfo.setText("Автор : Л.Н.Толстой");
                break;
            case 1:
                textInfo.setText("Автор : Л.Н.Толстой ");
                break;
            case 2:
                textInfo.setText("Автор : Дж.Оруелл");
                break;
            case 3:
                textInfo.setText("Автор : А.К.Доил");
                break;
        }
    }
}
