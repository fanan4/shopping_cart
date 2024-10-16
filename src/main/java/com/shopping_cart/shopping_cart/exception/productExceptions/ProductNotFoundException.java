package com.shopping_cart.shopping_cart.exception.productExceptions;


public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(String message) {
        super(message);
    }
}
