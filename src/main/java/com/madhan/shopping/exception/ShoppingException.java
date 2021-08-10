package com.madhan.shopping.exception;

import org.springframework.http.HttpStatus;

public class ShoppingException extends RuntimeException {

    private HttpStatus httpStatus;

    public ShoppingException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}
