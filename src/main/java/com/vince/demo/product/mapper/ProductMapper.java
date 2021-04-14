package com.vince.demo.product.mapper;


import com.vince.demo.product.entity.Product;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ProductMapper {
    int addProduct(Product product);

    List<Product> getProductList();

    List<Product> getProductByKey(String productName);

    List<Product> getProductByCondition(@Param("productName") String productName, @Param("productType") int productType);

    int updateProduct(@Param("pro") Product product);

    int deleteProduct(int productId);

    Product getProductDetailById(int productId);

    List<Product> statisticProductNum();

     List<Product> getProductPageList();
}

