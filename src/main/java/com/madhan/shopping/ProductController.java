package com.madhan.shopping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping("/product/search/{name}")
    public ResponseEntity getProduct(@PathVariable("name") String productName) {

        Optional<ProductResponse> optionalProductResponse = productService.getProductByName(productName);

        if(optionalProductResponse.isPresent()) {
            ProductResponse productResponse = optionalProductResponse.get();
            return new ResponseEntity(productResponse, HttpStatus.OK);
        } else {
            return new ResponseEntity("Sorry product is not found", HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping("/product/{category}")
    public List<ProductResponse> getProductsByCategory(@PathVariable("category") String category) {
        return productService.getProductsByCategory(category);
    }
}
