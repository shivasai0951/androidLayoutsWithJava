package com.shivasai.androidjava.getApiSearch;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface InterfaceSearch {

@GET("/users/{id}")
Call<userModel> getUserData(@Path("id") int id);

}
