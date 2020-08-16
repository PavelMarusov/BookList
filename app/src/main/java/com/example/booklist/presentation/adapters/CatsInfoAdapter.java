package com.example.booklist.presentation.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.booklist.R;

import java.util.List;

public class CatsInfoAdapter extends RecyclerView.Adapter<CatsInfoAdapter.CatsInfoHolder> {
    private List<Integer> list;

    public CatsInfoAdapter(List<Integer> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public CatsInfoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_cats, parent, false);
        return new CatsInfoHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CatsInfoHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class CatsInfoHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;

        public CatsInfoHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.cats_image);
        }

        public void onBind(int res) {
            imageView.setImageResource(res);
        }
    }
}
