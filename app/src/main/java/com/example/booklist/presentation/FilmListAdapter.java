package com.example.booklist.presentation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.booklist.R;
import com.example.booklist.intefaces.IonItemClick;
import com.example.booklist.models.Films;

import java.util.List;

public class FilmListAdapter extends RecyclerView.Adapter<FilmListAdapter.ListBookHolder> {
    private List<Films> list;
    private IonItemClick ionItemClick;

    public FilmListAdapter(List<Films> list,IonItemClick ionItemClick) {
        this.list = list;
        this.ionItemClick = ionItemClick;
    }

    @NonNull
    @Override
    public ListBookHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_book, parent, false);
        return new ListBookHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListBookHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    public class ListBookHolder extends RecyclerView.ViewHolder {
        private TextView booksName;

        public ListBookHolder(@NonNull View itemView) {
            super(itemView);
            booksName = itemView.findViewById(R.id.book_name_textview);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ionItemClick.OnClick(getAdapterPosition());
                }
            });

        }

        public void onBind(Films films) {
            booksName.setText(films.getTitle());
        }
    }
}
