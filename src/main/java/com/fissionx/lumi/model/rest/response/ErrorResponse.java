package com.fissionx.lumi.model.rest.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponse {
    private String status;
    private int code;
    private String message;
    private long timestamp;
    private String details;
}
