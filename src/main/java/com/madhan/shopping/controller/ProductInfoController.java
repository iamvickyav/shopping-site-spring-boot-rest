package com.madhan.shopping.controller;

import com.madhan.shopping.dto.ProductResponse;
import com.madhan.shopping.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductInfoController {

    @Autowired
    ProductInfoService productInfoService;

    @RequestMapping("/product/info/{category}")
    public List<ProductResponse> getProductInfo(@PathVariable("category") String category) {
        return productInfoService.getProductByCategory(category);
    }

    @RequestMapping("/product/info/{category}/{price}")
    public List<ProductResponse> getProductInfo2(@PathVariable("category") String category,
                                                 @PathVariable("price") String price) {
        return productInfoService.getProductByCategory2(category, price);
    }

    @RequestMapping("/product/info")
    public List<ProductResponse> getProductInfo3(@RequestParam(value = "category", required = false) String category,
                                                 @RequestParam(value = "price", required=false, defaultValue = "10000") String price,
                                                 @RequestParam(value = "brand", required = false) String brand) {
        System.out.println(price);
        return productInfoService.getProductByCategory(category);
    }
}
