package com.anuradha.demo.exception;

public class JerseyException extends RuntimeException {
    private static final long serialVersionUID = 12414251345315131L;

    public JerseyException(String message) {
        super(message);
    }
}
