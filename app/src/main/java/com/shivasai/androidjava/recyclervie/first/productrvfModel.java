package com.shivasai.androidjava.recyclervie.first;

public class productrvfModel {

    String productName;
    String productIsAvailable;
    String productprice;

    public productrvfModel(String productName, String productIsAvailable, String productprice) {
        this.productName = productName;
        this.productIsAvailable = productIsAvailable;
        this.productprice = productprice;
    }



    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductIsAvailable() {
        return productIsAvailable;
    }

    public void setProductIsAvailable(String productIsAvailable) {
        this.productIsAvailable = productIsAvailable;
    }

    public String getProductprice() {
        return productprice;
    }

    public void setProductprice(String productprice) {
        this.productprice = productprice;
    }








}
