package com.madhan.shopping.service;

import com.madhan.shopping.ProductMapper;
import com.madhan.shopping.reference.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductInfoService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<ProductResponse> getProductByCategory(String category) {

        String query = "SELECT * FROM product where category = \"Laptop\"";
        List<ProductResponse> productResponses = jdbcTemplate.query(query, new ProductMapper());
        return productResponses;
    }

    public List<ProductResponse> getProductByCategory2(String category, String price) {

        String query = "SELECT * FROM product where category = ? and price < ?";
        List<ProductResponse> productResponses = jdbcTemplate.query(query,
                new Object[]{category, price}, new ProductMapper());
        return productResponses;
    }
}
