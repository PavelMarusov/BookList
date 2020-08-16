package com.example.booklist.presentation.fragments.cats;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.App;
import com.example.booklist.R;
import com.example.booklist.data.CatsFactService;
import com.example.booklist.models.cats.Cats;
import com.example.booklist.utils.Config;

/**
 * A simple {@link Fragment} subclass.
 */
public class CatsFragment extends Fragment implements CatsFactService.CatsFactCallback {
 private TextView catText;
 private Cats mCats;

    public CatsFragment( ) {

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_cats, container, false);
       catText = view.findViewById(R.id.cats_title_tv);
        App.catsFactService.getFacts(this);
        return view;
    }


    @Override
    public void onSuccess(Cats cats) {
        mCats =cats;
        catText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), CatsInfoActivity.class);
                intent.putExtra(Config.CAT_POSITION, mCats);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onFailure(Exception e) {
        Toast.makeText(getContext(), "Коты не пашут", Toast.LENGTH_SHORT).show();
        Log.d("pop","Error + "+e.getMessage());
    }

}
