package com.madhan.shopping.service;

import com.madhan.shopping.ProductMapper;
import com.madhan.shopping.dto.ProductCreationRequest;
import com.madhan.shopping.dto.ProductInfo;
import com.madhan.shopping.dto.ProductResponse;
import com.madhan.shopping.dto.ProductUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@PropertySource("classpath:vicky.properties")
public class ProductInfoService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Value("${warranty.price.percentage}")
    Integer warrantyService;

    @Value("${warranty.coverage.years}")
    Integer warrantyCoveragePeriod;

    public List<ProductResponse> getProductByCategory(String category) {
        System.out.println(warrantyService);
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

    public int createProduct(ProductCreationRequest productCreationRequest) {

        String query = "INSERT INTO product (name, description, category, price) VALUES (?,?,?,?)";

        // DDL Statements -> Table structure change
        // jdbcTemplate.execute();

        // DML Statements -> Data inside table change
        // jdbcTemplate.update();

        // DQL Statements -> Data query
        // jdbcTemplate.query();

        int affectedRows = jdbcTemplate.update(query, productCreationRequest.getName(),
                productCreationRequest.getDesc(), productCreationRequest.getCategory(), productCreationRequest.getPrice());

        return affectedRows;
    }

    public int updateProduct(ProductUpdateRequest productUpdateRequest) {
        String query = "UPDATE product SET price = ? WHERE id = ?";

        return jdbcTemplate.update(query, productUpdateRequest.getPrice(), productUpdateRequest.getId());
    }

    public void deleteProduct(Integer id) {
        String query = "DELETE FROM product WHERE id = ?";

        jdbcTemplate.update(query, id);
    }
}
