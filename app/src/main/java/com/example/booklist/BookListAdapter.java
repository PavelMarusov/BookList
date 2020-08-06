package com.example.booklist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BookListAdapter extends RecyclerView.Adapter<BookListAdapter.ListBookHolder> {
    private ArrayList<String> list;
    private IonItemClick listner;

    public BookListAdapter(ArrayList<String> list) {
        this.list = list;
        list.add("Война и Мир");
        list.add("1984");
        list.add("Записки о Шерлоке Холмсе");

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

    public void setListner (IonItemClick ionItemClick){
        this.listner = ionItemClick;
    }

    public class ListBookHolder extends RecyclerView.ViewHolder {
        private TextView booksName;

        public ListBookHolder(@NonNull View itemView) {
            super(itemView);
            booksName = itemView.findViewById(R.id.book_name_textview);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listner.OnClick(getAdapterPosition());
                }
            });
        }

        public void onBind(String text) {
            booksName.setText(text);
        }
    }
}
