package com.example.booklist.presentation.fragments.cats;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.booklist.R;
import com.example.booklist.models.cats.Cats;
import com.example.booklist.presentation.adapters.CatsInfoAdapter;
import com.example.booklist.utils.Config;

import java.util.ArrayList;
import java.util.List;

public class CatsInfoActivity extends AppCompatActivity {
private TextView infoCats;
private RecyclerView recyclerView;
private CatsInfoAdapter adapter;
private List<Integer>list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cats_info);
        infoCats = findViewById(R.id.cats_info_tv);
        Intent intent = getIntent();
       Cats cats = (Cats) intent.getSerializableExtra(Config.CAT_POSITION);
       infoCats.setText(cats.getText());
       list = new ArrayList<>();
       list.add(R.drawable.cat1);
       list.add(R.drawable.cat2);
       list.add(R.drawable.cat3);
       list.add(R.drawable.cat4);
       list.add(R.drawable.cat5);
       list.add(R.drawable.cat6);
       list.add(R.drawable.cat7);
       list.add(R.drawable.cat8);
       list.add(R.drawable.cat9);
       recyclerView = findViewById(R.id.cats_recycler);
       adapter = new CatsInfoAdapter(list);
       recyclerView.setAdapter(adapter);

    }
}
