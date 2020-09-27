package com.spr.util;

public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = -5081112079473177187L;

    private BusinessException() {
    }

    public BusinessException(String message) {
        super(message);
    }
}
