package com.madhan.shopping.controller;

import com.madhan.shopping.dto.*;
import com.madhan.shopping.exception.ShoppingException;
import com.madhan.shopping.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ProductController {

    @Autowired
    ProductInfoService productInfoService;

    @PostMapping("/product")
    public ResponseEntity<ShoppingResponse> createProduct(
            @RequestHeader("Authorization") String authorization,
            @Valid @RequestBody ProductCreationRequest productCreationRequest) {

        if(!authorization.equalsIgnoreCase("Bearer 12345")) {
           throw new ShoppingException("Invalid User", HttpStatus.UNAUTHORIZED);
        }

        int affectedRows = productInfoService.createProduct(productCreationRequest);

        ShoppingResponse shoppingResponse = new ShoppingResponse(ResponseCode.SUCCESS,
                affectedRows + " created successfully");

        return new ResponseEntity<>(shoppingResponse, HttpStatus.CREATED);
    }

    @PutMapping("/product")
    public ResponseEntity<ShoppingResponse> updateProduct(@Valid @RequestBody ProductUpdateRequest productUpdateRequest) {

        int affectedRows = productInfoService.updateProduct(productUpdateRequest);

        ShoppingResponse shoppingResponse = new ShoppingResponse(ResponseCode.SUCCESS,
                affectedRows + " updated successfully");

        return new ResponseEntity<>(shoppingResponse, HttpStatus.OK);
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<ShoppingResponse> deleteProduct(@PathVariable("id") Integer id) {
        productInfoService.deleteProduct(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
