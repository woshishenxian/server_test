package com.vince.demo.product.controller;


import com.vince.demo.product.entity.ProductType;
import com.vince.demo.product.entity.Response;
import com.vince.demo.product.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by xpwu on 2020/12/27.
 */
@RestController
public class ProductTypeController {

    @Autowired
    private ProductTypeService productTypeService;

    @RequestMapping(value = "/getProductTypeList",method = RequestMethod.GET)
    public Response getProductTypeList(){
        Response response = new Response();
        List<ProductType> list = productTypeService.selectValidList();
        response.setResponse(true,"查询成功",1, list);
        return response;
    }
}
