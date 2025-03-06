package com.fissionx.lumi.utils;


public enum Status {
    SUCCESS("success"),
    ERROR("internal_server_error"),
    PENDING("pending"),
    FAILED("failed"),
    BAD_REQUEST("bad_request"),
    UNAUTHORIZED("unauthorized"),
    NOT_FOUND("not_found");

    private final String value;

    // Constructor to initialize the enum with a value
    Status(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}

