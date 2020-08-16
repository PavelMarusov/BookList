package com.example.booklist.data;

import android.util.Log;

import com.example.booklist.models.Films;

import java.io.File;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class GhibliService {
    private List <Films> filmsList;
    Retrofit retrofit = new Retrofit.Builder().
            addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://ghibliapi.herokuapp.com/")
            .build();

    GhibliApi service = retrofit.create(GhibliApi.class);

    public void getFilms(GhibliCallback callback){
        Call<List<Films>> call = service.getFilm();
        call.enqueue(new Callback<List<Films>>() {
            @Override
            public void onResponse(Call<List<Films>> call, Response<List<Films>> response) {
               if (response.isSuccessful() && response.body()!=null){
                   Log.d("pop",response.body().toString());
                   callback.onSuccess(response.body());
               }
            }

            @Override
            public void onFailure(Call<List<Films>> call, Throwable t) {
                Log.d("pop","Exception " + t.getMessage());
            }
        });
    }

    public interface  GhibliCallback{
        void onSuccess(List<Films> films);
        void onFailure(Exception ex);
    }


    public interface GhibliApi {
        @GET("films/")
        Call<List<Films>> getFilm();

        @GET("films/{id}")
        Call<List<Films>> getFilmByID(@Path("id") String id);
    }
}
