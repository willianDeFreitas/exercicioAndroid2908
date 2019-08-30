package com.example.aula29_08_2019;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinnerDeUsuarios);
        buscaDados();
    }

    private void buscaDados() {
        RetrofitService.getServico().obterUsuarios().enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                List<User> userList = response.body();
                List<String> userNamesList = new ArrayList<>();
                for (User user : userList) {
                    userNamesList.add(user.getName());
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<>(
                        MainActivity.this, android.R.layout.simple_spinner_item, userNamesList);
                spinner.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Log.e("aula", t.getMessage());
            }
        });
    }

}
