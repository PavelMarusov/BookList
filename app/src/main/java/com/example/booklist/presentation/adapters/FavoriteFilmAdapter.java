package com.example.booklist.presentation.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.booklist.R;
import com.example.booklist.models.Films;

import java.util.List;

public class FavoriteFilmAdapter extends RecyclerView.Adapter<FavoriteFilmAdapter.FavoriteFilmHolder> {
    private List<Films> favList;

    public FavoriteFilmAdapter(List<Films> favList) {
        this.favList = favList;
    }

    @NonNull
    @Override
    public FavoriteFilmHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_favorite, parent, false);
        return new FavoriteFilmHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoriteFilmHolder holder, int position) {
        holder.onBind(favList.get(position));
    }

    @Override
    public int getItemCount() {
        return favList.size();
    }

    class FavoriteFilmHolder extends RecyclerView.ViewHolder {
        private TextView favTitle, favDesc;

        public FavoriteFilmHolder(@NonNull View itemView) {
            super(itemView);
            favTitle = itemView.findViewById(R.id.favor_title_tv);
            favDesc = itemView.findViewById(R.id.favor_desc_tv);
        }

        public void onBind(Films films) {
            favTitle.setText(films.getTitle());
            favDesc.setText(films.getDescription());
        }
    }

}
