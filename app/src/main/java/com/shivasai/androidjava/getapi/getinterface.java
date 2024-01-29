package com.shivasai.androidjava.getapi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface getinterface {


    @GET("users")
    Call<List<getuserModel>> doGetListResources();

}
