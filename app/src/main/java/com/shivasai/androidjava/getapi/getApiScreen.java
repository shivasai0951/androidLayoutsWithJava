package com.shivasai.androidjava.getapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.shivasai.androidjava.R;
import com.shivasai.androidjava.retrofit.retrofit;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class getApiScreen extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_api_screen);
        textView=findViewById(R.id.textView);
        Toast.makeText(getApiScreen.this,"coming here",Toast.LENGTH_SHORT);
        getusers();
    }

    private void getusers() {
        ArrayList<String> emails = new ArrayList<String>();
        getinterface getinterface=retrofit.getClient().create(com.shivasai.androidjava.getapi.getinterface.class);
        Call<List<getuserModel>> call=getinterface.doGetListResources();


        call.enqueue(new Callback<List<getuserModel>>() {
            @Override
            public void onResponse(Call<List<getuserModel>> call, Response<List<getuserModel>> response) {
                Log.d("the length of the api->",String.valueOf(response.body().size()));
                for(int i=0;i<response.body().size();i++){

                    emails.add(response.body().get(i).email);
                  //  textView.setText(response.body().addAll().email);
                }
                textView.setText(emails.toString());

          /*      Log.e("this is call ",call.toString());
                Log.e("this is response ",response.body().toString());
                textView.setText(response.body().toString());
                Toast.makeText(getApiScreen.this,response.body().toString(),Toast.LENGTH_SHORT);*/
            }

            @Override
            public void onFailure(Call<List<getuserModel>> call, Throwable t) {

            }
        });


 /*       getinterface apiService = retrofit.getClient().create(getinterface.class);

        Call<List<getuserModel>> call = apiService.doGetListResources();
        call.enqueue(new Callback<List<getuserModel>>() {
            @Override
            public void onResponse(Call<List<getuserModel>> call, Response<List<getuserModel>> response) {
                Log.e("this is call ",call.toString());
                Log.e("this is response ",response.body().toString());
                textView.setText(response.body().toString());
                Toast.makeText(getApplicationContext(),response.body().toString(),Toast.LENGTH_SHORT);
            }

            @Override
            public void onFailure(Call<List<getuserModel>> call, Throwable t) {
                Log.e("this is call ",call.toString());
                Log.e("this is response ",t.toString());
            }

        });*/



    }
}