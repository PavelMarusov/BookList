package com.example.booklist.data;

import com.example.booklist.models.Films;
import com.example.booklist.models.cats.Cats;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class CatsFactService {

    Retrofit retrofit = new Retrofit.Builder().
            addConverterFactory(GsonConverterFactory.create()).
            baseUrl("https://cat-fact.herokuapp.com").
            build();

    public void getFacts(CatsFactCallback callback) {
        Call<Cats> call = service.getFacts();
        call.enqueue(new Callback<Cats>() {
            @Override
            public void onResponse(Call<Cats> call, Response<Cats> response) {
                if (response.isSuccessful() && response.body() != null) {
                    callback.onSuccess(response.body());
                    getFacts(callback);
                }
            }

            @Override
            public void onFailure(Call<Cats> call, Throwable t) {
                callback.onFailure(new Exception());
            }
        });
    }


    CatsFactApi service = retrofit.create(CatsFactApi.class);

    public interface CatsFactCallback {
        void onSuccess(Cats cats);

        void onFailure(Exception e);
    }

    public interface CatsFactApi {
        @GET("/facts/random")
        Call<Cats> getFacts();
    }
}
