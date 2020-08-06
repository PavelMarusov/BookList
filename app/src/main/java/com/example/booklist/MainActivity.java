package com.example.booklist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private  BookListAdapter adapter;
    private ArrayList <String> list;
    public static final String KYE = "key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler);
        list = new ArrayList<>();
        list.add("Анна Каренина");
        adapter = new BookListAdapter(list);
        recyclerView.addItemDecoration
                (new DividerItemDecoration(getApplicationContext(),DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(adapter);
        adapter.setListner(new IonItemClick() {
            @Override
            public void OnClick(int position) {
                Intent intent =  new Intent(MainActivity.this,InfoActivity.class);
                intent.putExtra(KYE,position);
                startActivity(intent);
            }
        });


    }
}
