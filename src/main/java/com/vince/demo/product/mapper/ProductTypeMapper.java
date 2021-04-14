package com.vince.demo.product.mapper;

import com.vince.demo.product.entity.ProductType;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface ProductTypeMapper extends Mapper<ProductType> {
}
