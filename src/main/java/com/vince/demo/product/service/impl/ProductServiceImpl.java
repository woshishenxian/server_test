package com.vince.demo.product.service.impl;

import com.vince.demo.product.entity.Product;
import com.vince.demo.product.mapper.ProductMapper;
import com.vince.demo.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductMapper productMapper;


    @Override
    public int addProduct(Product product) {
        return productMapper.addProduct(product);
    }

    @Override
    public List<Product> getProductList() {
        return productMapper.getProductList();
    }

    public List<Product> getProductByKey(String productName) {
        List<Product> proList1 = productMapper.getProductByKey(productName);
        return proList1;
    }

    public List<Product> getProductByCondition(String productName, int productType) {
        List<Product> proList2 = productMapper.getProductByCondition(productName, productType);
        return proList2;
    }

    public int updateProduct(Product product) {
        int count = 0;
        try {
            count = productMapper.updateProduct(product);
        } catch (Exception err) {
            System.out.println(err);
        }
        return count;
    }

    @Override
    public int deleteProduct(int productId) {
        int count = 0;
        try {
            count = productMapper.deleteProduct(productId);
        } catch (Exception err) {
            System.out.println(err);
        }
        return count;
    }

    @Override
    public Product getProductDetailById(int productId) {
        return productMapper.getProductDetailById(productId);
    }

    @Override
    public List<Product> statisticProductNum() {
        return productMapper.statisticProductNum();
    }

    @Override
    public List<Product> getProductPageList() {
        return productMapper.getProductPageList();
    }
}
