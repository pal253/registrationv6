package com.api6.exception;

public class ResourceNotFoundException extends  RuntimeException{
    public ResourceNotFoundException(String msg) {
        super(msg);
    }
}
