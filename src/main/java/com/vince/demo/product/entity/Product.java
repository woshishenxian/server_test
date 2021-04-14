package com.vince.demo.product.entity;

public class Product {
    int productId;
    String productName;
    double productPrice;
    int productType;
    String productImg;
    String productDes;
    String productNum;

    public Product() {
    }

    public Product( String productName, double productPrice, int productType, String productImg, String productDes) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productType = productType;
        this.productImg = productImg;
        this.productDes = productDes;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductType() {
        return productType;
    }

    public void setProductType(int productType) {
        this.productType = productType;
    }

    public String getProductImg() {
        return productImg;
    }

    public void setProductImg(String productImg) {
        this.productImg = productImg;
    }

    public String getProductDes() {
        return productDes;
    }

    public void setProductDes(String productDes) {
        this.productDes = productDes;
    }

    public String getProductNum() {
        return productNum;
    }

    public void setProductNum(String productNum) {
        this.productNum = productNum;
    }
}
