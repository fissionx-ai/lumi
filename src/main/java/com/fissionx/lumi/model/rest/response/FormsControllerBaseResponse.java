package com.fissionx.lumi.model.rest.response;

import lombok.Data;

@Data
public abstract class FormsControllerBaseResponse<T> {
    private String status;
    private int code;
    private long timestamp;
    private String message;
    private T data;
}
