package com.fissionx.lumi.utils;


public enum HTTPStatus {
    SUCCESS("success"),
    ERROR("internal_server_error"),
    PENDING("pending"),
    FAILED("failed"),
    BAD_REQUEST("bad_request"),
    UNAUTHORIZED("unauthorized"),
    NOT_FOUND("not_found");

    private final String value;

    // Constructor to initialize the enum with a value
    HTTPStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }

    public enum FormStatus {
        SAVED("saved"),
        SAVED_FOR_DRAFT("saved_for_draft"),
        PUBLISHED("published"),
        DELETED("deleted"),
        UPDATED("updated");

        private final String value;

        // Constructor to initialize the enum with a value
        FormStatus(String value) {
            this.value = value;
        }
    }
}

