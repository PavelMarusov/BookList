package com.example.booklist.presentation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.booklist.R;
import com.example.booklist.presentation.adapters.SlideFragmentAdapter;
import com.example.booklist.presentation.fragments.cats.CatsFragment;
import com.example.booklist.presentation.fragments.film.FilmsFragment;
import com.example.booklist.presentation.fragments.news.NewsFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private SlideFragmentAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.view_pager);
        List<Fragment> list = new ArrayList<>();
        list.add(new FilmsFragment());
        list.add(new CatsFragment());
        list.add(new NewsFragment());
        adapter =  new SlideFragmentAdapter(getSupportFragmentManager(),list);
        viewPager.setAdapter(adapter);


    }

}
