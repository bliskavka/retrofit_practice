package com.example.retrofit_practice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    TextView text;

    final String key = "987e209efeebdaa19301965078db0760";
    String lat = "42.3601";
    String lng = "-71.0589";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.text);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(JsonPlaceholderApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceholderApi jsonPlaceholderApi = retrofit.create(JsonPlaceholderApi.class);

        Call<WeatherEntity> call = jsonPlaceholderApi.getPosts(key, lat, lng);
        call.enqueue(new Callback<WeatherEntity>() {
            @Override
            public void onResponse(Call<WeatherEntity> call, Response<WeatherEntity> response) {
                if (!response.isSuccessful()) {
                    Log.d("", "" + response.code());
                    return;
                }

                WeatherEntity weatherEntity = response.body();

            }

            @Override
            public void onFailure(Call<WeatherEntity> call, Throwable t) {
                Log.d("server error", "error", t);
            }
        });
    }
}
