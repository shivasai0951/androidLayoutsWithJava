package com.shivasai.androidjava.recyclervie.first;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shivasai.androidjava.R;

import java.util.ArrayList;

public class productrvAdaptor extends RecyclerView.Adapter<productrvAdaptor.Myadaptor> {

    ArrayList<productrvfModel> products;

    public productrvAdaptor(ArrayList<productrvfModel> products){
        this.products=products;
    }

    public class Myadaptor extends RecyclerView.ViewHolder{

        TextView productname,Available,price;

        public Myadaptor(@NonNull View itemView) {
            super(itemView);
            productname=itemView.findViewById(R.id.productname);
            Available=itemView.findViewById(R.id.Available);
            price=itemView.findViewById(R.id.price);
        }
    }



    @NonNull
    @Override
    public productrvAdaptor.Myadaptor onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
       View itemView= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.productuirv,viewGroup,false);
       return new Myadaptor(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull productrvAdaptor.Myadaptor myadaptor, int i) {

        String pName=products.get(i).getProductName();
        String pIsAvlible=products.get(i).getProductIsAvailable();
        String pPrice=products.get(i).getProductprice();

        myadaptor.productname.setText(pName);


        if(pIsAvlible.toString()=="true"){
            myadaptor.Available.setText("Available");
            myadaptor.Available.setTextColor(Color.GREEN);
        }else{
            myadaptor.Available.setText("Not Available");
            myadaptor.Available.setTextColor(Color.RED);
        }
        myadaptor.price.setText(pPrice);


    }

    @Override
    public int getItemCount() {
    return  products.size();
    }
}
