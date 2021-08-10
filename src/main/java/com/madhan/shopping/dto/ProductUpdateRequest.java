package com.madhan.shopping.dto;

import javax.validation.constraints.NotNull;

public class ProductUpdateRequest {
    @NotNull
    private Integer id;
    @NotNull
    private Double price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
