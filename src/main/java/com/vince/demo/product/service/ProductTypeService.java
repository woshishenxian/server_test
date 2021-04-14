package com.vince.demo.product.service;

import com.vince.demo.product.entity.ProductType;

import java.util.List;

public interface ProductTypeService {
    List<ProductType> selectValidList();
}
