package com.example.customerService.Model;

public class Product {

    private int productId;
    private String prodName;
    private String prodDesc;
    private Double prodPrice;

    public Product(){

    }

    public Product(int productId, String prodName, String prodDesc, Double prodPrice) {
        this.productId = productId;
        this.prodName = prodName;
        this.prodDesc = prodDesc;
        this.prodPrice = prodPrice;
    }

    public int getProductId() {
        return productId;
    }

    public String getProdName() {
        return prodName;
    }

    public String getProdDesc() {
        return prodDesc;
    }

    public Double getProdPrice() {
        return prodPrice;
    }
}
