package com.example.orderService.Model;

public class Product {

    private final int productId;
    private final String prodName;
    private final String prodDesc;
    private final Double prodPrice;


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
