package com.example.aula29_08_2019;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Callback;

import android.os.Bundle;
import android.view.Window;
import android.widget.Spinner;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    Spinner spinner;
    Callback<List<User>> callback = new Callback<List<User>>(){


    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinnerDeUsuarios);
        buscaDados();
    }

    private void buscaDados() {
        RetrofitService.getServico().obterUsuarios().enqueue(callback);
    }


}
