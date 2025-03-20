package com.fissionx.lumi.exceptions;

public class DeleteRequestFailedException extends RuntimeException {
    public DeleteRequestFailedException(String message) {
        super(message);
    }
}
