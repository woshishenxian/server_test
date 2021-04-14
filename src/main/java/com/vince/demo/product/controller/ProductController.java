package com.vince.demo.product.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.vince.demo.product.entity.Product;
import com.vince.demo.product.entity.Response;
import com.vince.demo.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    public Response<Product> addProduct(@RequestBody Product product) {
        if (product.getProductName() != null && product.getProductPrice() != 0 && product.getProductType() != 0 && product.getProductImg() != null && product.getProductDes() != null) {
            int count = productService.addProduct(product);
            if (count > 0) {
                return new Response<>(true, "添加成功", 1);
            } else {
                return new Response<>(false, "添加失败", -1);
            }
        } else {
            return new Response<>(false, "有参数为空", -1);
        }
    }

    @RequestMapping(value = "/getProductList", method = RequestMethod.GET)
    public Response<List<Product>> getProductList() {
        Response<List<Product>> response = new Response<>();
        List<Product> productList = productService.getProductList();
        response.setResponse(true, "查询成功", 1, productList);
        return response;
    }

    @RequestMapping(value = "/getProductByKey", method = RequestMethod.POST)
    public Response getProductByKey(@RequestBody Map<String, String> product) {
        String productName = product.get("productName");
        Response response = new Response();
        List<Product> productList = productService.getProductByKey(productName);
        response.setResponse(true, "查询成功", 1, productList);
        return response;
    }

    @RequestMapping(value = "/getProductByCondition", method = RequestMethod.POST)
    public Response getProductByCondition(@RequestBody Product product) {
        String productName = product.getProductName();
        int productType = product.getProductType();
        Response response = new Response();
        List<Product> productList = productService.getProductByCondition(productName, productType);
        response.setResponse(true, "查询成功", 1, productList);
        return response;
    }

    @RequestMapping(value = "/updateProduct", method = RequestMethod.POST)
    public Response updateProduct(@RequestBody Product product) {
        int productId = product.getProductId();
        int count = productService.updateProduct(product);
        if (productId != 0) {
            if (count > 0) {
                Response response = new Response(true, "更新成功", 1);
                return response;
            } else {
                Response response = new Response(false, "更新失败", -1);
                return response;
            }
        } else {
            Response response = new Response(false, "请传入商品id", -1);
            return response;
        }
    }

    @RequestMapping(value = "/deleteProduct", method = RequestMethod.POST)
    public Response deleteProduct(@RequestBody Product product) {
        int productId = product.getProductId();
        if (productId != 0) {
            int count = productService.deleteProduct(productId);
            if (count > 0) {
                Response response = new Response(true, "删除成功", 1);
                return response;
            } else {
                Response response = new Response(false, "删除失败，请检查原因", -1);
                return response;
            }
        } else {
            Response response = new Response(false, "删除失败，请传入商品id", -1);
            return response;
        }
    }

    @RequestMapping(value = "/getProductDetailById", method = RequestMethod.GET)
    public Response getProductDetailById(@RequestParam("productId") Integer productId) {
        Response response = new Response();
        Product product = productService.getProductDetailById(productId);
        response.setResponse(true, "查询成功", 1, product);
        return response;
    }

    @RequestMapping(value = "/statisticProductNum", method = RequestMethod.GET)
    public Response statisticProductNum() {
        Response response = new Response();
        List<Product> resList = productService.statisticProductNum();
        response.setResponse(true, "查询成功", 1, resList);
        return response;
    }
    @RequestMapping(value = "/getProductPageList", method = RequestMethod.GET)
    public Response<Map<String, Object>> getProductPageList(@RequestParam("pageNum") Integer pageNum,
                                                @RequestParam("pageSize") Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Product> list = productService.getProductPageList();
        // 组装分页数据，主要包含分页列表数据及总记录数
        Map<String, Object> map = new HashMap<>();
        map.put("list", list);
        map.put("total", new PageInfo<>(list).getTotal());
        Response<Map<String, Object>> response = new Response<>();
        response.setResponse(true, "查询成功", 1, map);
        return response;
    }
}
