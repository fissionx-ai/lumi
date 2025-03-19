package com.fissionx.lumi.utils;


import com.fissionx.lumi.model.rest.response.GenericContollerResponse;
import org.springframework.http.HttpStatus;

public class APIResponseFactory {

    public static <T> GenericContollerResponse<T> createSuccessResponse(T data, String message) {
        return new GenericContollerResponse.Builder<T>()
                .code(200)
                .status(HttpStatus.OK.getReasonPhrase())
                .timestamp()
                .setMessage(message != null ? message : "Request was successful.")
                .setData(data)
                .build();
    }
}
