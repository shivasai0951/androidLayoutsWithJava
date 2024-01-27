package com.shivasai.androidjava.recyclervie.first;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.shivasai.androidjava.R;

import java.util.ArrayList;

public class recyclerviewfirst extends AppCompatActivity {

    private ArrayList<productrvfModel> Products;
    private RecyclerView ReCyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerviewfirst);

        ReCyclerView = findViewById(R.id.ReCyclerViewOne);
        setDataToArray();
        settTheAdaptor();
        
    }

    private void setDataToArray() {
        Products=new ArrayList<>();

        Products.add(new productrvfModel("iphone","false","1000"));
        Products.add(new productrvfModel("MI-1","true","100"));
        Products.add(new productrvfModel("MI2 pro","false","4985"));
        Products.add(new productrvfModel("redmi 8","true","800"));
        Products.add(new productrvfModel("samsung1","true","3597"));
        Products.add(new productrvfModel("iphone","true","999"));
        Products.add(new productrvfModel("MI-1","false","1000"));
        Products.add(new productrvfModel("samsung2","false","4050"));
        Products.add(new productrvfModel("iphone 2","true","8756"));
        Products.add(new productrvfModel("vivo","true","1685"));


    }

    private void settTheAdaptor() {

        productrvAdaptor productrvAdaptor=new productrvAdaptor(Products);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getApplicationContext());
        ReCyclerView.setLayoutManager(layoutManager);
        ReCyclerView.setItemAnimator(new DefaultItemAnimator());
        ReCyclerView.setAdapter(productrvAdaptor);


    }


}