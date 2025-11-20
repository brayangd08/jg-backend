package com.jg.backend.exception;

public class JgBadRequestException extends RuntimeException {

    public JgBadRequestException(String msg) {
        super(msg);
    }
}
