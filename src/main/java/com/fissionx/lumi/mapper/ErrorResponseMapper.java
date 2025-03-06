package com.fissionx.lumi.mapper;

import com.fissionx.lumi.model.rest.response.ErrorResponse;
import com.fissionx.lumi.utils.Status;
import org.springframework.http.HttpStatus;

public class ErrorResponseMapper {
    public static ErrorResponse getErrorResponse(Status status,HttpStatus httpStatus, Exception e){
        ErrorResponse errorResponse = new ErrorResponse(
                status.getValue(),
                httpStatus.value(),
                e.getMessage(),
                System.currentTimeMillis(),
                e.toString()
        );
        return errorResponse;
    }

    public static ErrorResponse getErrorResponse(Status status,HttpStatus httpStatus, String message){
        ErrorResponse errorResponse = new ErrorResponse(
                status.getValue(),
                httpStatus.value(),
                message,
                System.currentTimeMillis(),message
        );
        return errorResponse;
    }
}
