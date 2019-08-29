package com.example.aula29_08_2019;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EndPoint {
    @GET("users")
    Call<List<User>> obterUsuarios();

}
