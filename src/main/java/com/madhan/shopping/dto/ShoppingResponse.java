package com.madhan.shopping.dto;

public class ShoppingResponse {
    private ResponseCode code;
    private String message;

    public ShoppingResponse(ResponseCode code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResponseCode getCode() {
        return code;
    }

    public void setCode(ResponseCode code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
