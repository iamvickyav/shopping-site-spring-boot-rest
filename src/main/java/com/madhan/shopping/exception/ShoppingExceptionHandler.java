package com.madhan.shopping.exception;

import com.madhan.shopping.dto.ResponseCode;
import com.madhan.shopping.dto.ShoppingResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ShoppingExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ShoppingResponse> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exception) {

        ShoppingResponse shoppingResponse = new ShoppingResponse(ResponseCode.FAILURE, exception.getMessage());
        return new ResponseEntity<>(shoppingResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ShoppingException.class)
    public ResponseEntity<ShoppingResponse> handleShoppingException(
            ShoppingException shoppingException) {

        ShoppingResponse shoppingResponse = new ShoppingResponse(ResponseCode.FAILURE,
                shoppingException.getMessage());
        return new ResponseEntity<>(shoppingResponse, shoppingException.getHttpStatus());
    }

    @ExceptionHandler(MissingRequestHeaderException.class)
    public ResponseEntity<ShoppingResponse> handleMissingRequestHeaderException(
            MissingRequestHeaderException exception) {

        ShoppingResponse shoppingResponse = new ShoppingResponse(ResponseCode.FAILURE, exception.getMessage());
        return new ResponseEntity<>(shoppingResponse, HttpStatus.FORBIDDEN);
    }
}
