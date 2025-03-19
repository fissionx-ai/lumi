package com.fissionx.lumi.model.rest.response;

public class GenericContollerResponse<T> {
    private int code;
    private String message;
    private T data;
    private String status;
    private Long timestamp;
    private String error;

    private GenericContollerResponse(Builder<T> builder) {
        this.code = builder.code;
        this.message = builder.message;
        this.data = builder.data;
        this.error = builder.error;
        this.status=builder.status;
        this.timestamp=builder.timestamp;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
    public String getStatus() {
        return status;
    }
    public Long getTimestamp() {
        return timestamp;
    }
    public T getData() {
        return data;
    }

    public String getError() {
        return error;
    }

    // Builder class for ApiResponse
    public static class Builder<T> {
        private int code;
        private String message;
        private T data;
        private String error;
        private String status;
        private Long timestamp;

        public Builder<T> code(int statusCode) {
            this.code = statusCode;
            return this;
        }
        public Builder<T> timestamp() {
            this.timestamp = System.currentTimeMillis();
            return this;
        }
        public Builder<T> status(String status) {
            this.status = status;
            return this;
        }
        public Builder<T> setMessage(String message) {
            this.message = message;
            return this;
        }

        public Builder<T> setData(T data) {
            this.data = data;
            return this;
        }

        public Builder<T> setError(String error) {
            this.error = error;
            return this;
        }

        public GenericContollerResponse<T> build() {
            return new GenericContollerResponse<>(this);
        }
    }
}
