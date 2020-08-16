package com.example.booklist.presentation.fragments.film;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.App;
import com.example.booklist.R;
import com.example.booklist.data.GhibliService;
import com.example.booklist.intefaces.IonItemClick;
import com.example.booklist.models.Films;
import com.example.booklist.presentation.adapters.FilmListAdapter;
import com.example.booklist.utils.Config;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FilmsFragment extends Fragment implements GhibliService.GhibliCallback,IonItemClick {
    private RecyclerView recyclerView;
    private FilmListAdapter adapter;
    private List<Films> filmsList;

    public FilmsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_films, container, false);
        App.ghibliService.getFilms(this);
        recyclerView = view.findViewById(R.id.recycler);

        return view;
    }

    @Override
    public void onSuccess(List<Films> films) {
        filmsList = films;
        adapter = new FilmListAdapter(filmsList, this::OnClick);
        recyclerView.setAdapter(adapter);

    }
    @Override
    public void onFailure(Exception ex) {
        Toast.makeText(getContext(), "Ошибка :"+ ex.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void OnClick(int position) {
        Films film = filmsList.get(position);
        Log.d("pop",film.getTitle());
        Intent intent =  new Intent(getActivity(), InfoActivity.class);
        intent.putExtra(Config.POSITION,film);
        startActivity(intent);
    }
}
