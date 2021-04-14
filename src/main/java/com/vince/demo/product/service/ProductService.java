package com.vince.demo.product.service;

import com.vince.demo.product.entity.Product;

import java.util.List;
import java.util.Map;

public interface ProductService {
    int addProduct(Product product);

    List<Product> getProductList();

    List<Product> getProductByKey(String productName);

    List<Product> getProductByCondition(String productName,int productType);

    int updateProduct(Product product);

     int deleteProduct(int productId);

    Product getProductDetailById(int productId);

    List<Product> statisticProductNum();

    List<Product> getProductPageList();
}
