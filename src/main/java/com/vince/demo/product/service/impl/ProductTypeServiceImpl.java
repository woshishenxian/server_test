package com.vince.demo.product.service.impl;

import com.vince.demo.product.entity.ProductType;
import com.vince.demo.product.mapper.ProductTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class ProductTypeServiceImpl implements com.vince.demo.product.service.ProductTypeService {

    @Autowired
    ProductTypeMapper mapper;

    @Override
    public List<ProductType> selectValidList() {
        int validState = 1;
        // 使用mybatis通用查询插件
        Example example = new Example(ProductType.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("state", validState);
        // productTypeMapper 继承通用tk.mybatis.mapper.common.Mapper类之后，可以调用其通用查询方法
        return mapper.selectByExample(example);
    }
}
