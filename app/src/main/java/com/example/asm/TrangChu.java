package com.example.asm;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TrangChu extends AppCompatActivity {
    ListView lv;
    ArrayList<MotoModel> list;
    motoAdapter adapter;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_trang_chu);
        lv = findViewById(R.id.lv);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIService.DOMAIN)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        APIService apiService = retrofit.create(APIService.class);
        Call<List<MotoModel>> call = apiService.getCars();
        call.enqueue(new Callback<List<MotoModel>>() {
            @Override
            public void onResponse(Call<List<MotoModel>> call, Response<List<MotoModel>> response) {
                if (response.isSuccessful()) {
                    list = (ArrayList<MotoModel>) response.body();
                    adapter = new motoAdapter(list, getApplicationContext());
                    lv.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<MotoModel>> call, Throwable t) {
                Log.d("Main", t.getMessage());
            }
        });
        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MotoModel fitnessModel = new MotoModel("01", "PKL", "2000", "Ducati", "1000","R.drawable.img_7");
                Call<List<MotoModel>> call = apiService.addCar(fitnessModel);
                call.enqueue(new Callback<List<MotoModel>>() {
                    @Override
                    public void onResponse(Call<List<MotoModel>> call, Response<List<MotoModel>> response) {
                        if (response.isSuccessful()) {
                            list.clear();
                            list.addAll(response.body());
                            adapter.notifyDataSetChanged();
                        }
                    }

                    @Override
                    public void onFailure(Call<List<MotoModel>> call, Throwable t) {
                    Log.d("Main", t.getMessage());
                    }
                });
            }
        });
    }
}