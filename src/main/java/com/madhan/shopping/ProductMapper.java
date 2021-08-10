package com.madhan.shopping;

import com.madhan.shopping.dto.ProductResponse;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductMapper implements RowMapper<ProductResponse> {

    @Override
    public ProductResponse mapRow(ResultSet resultSet, int i) throws SQLException {
        ProductResponse productResponse = new ProductResponse();
        productResponse.setId(resultSet.getInt("id"));
        productResponse.setName(resultSet.getString("name"));
        productResponse.setDesc(resultSet.getString("description"));
        productResponse.setPrice(resultSet.getDouble("price"));
        productResponse.setCategory(resultSet.getString("category"));
        return productResponse;
    }
}
