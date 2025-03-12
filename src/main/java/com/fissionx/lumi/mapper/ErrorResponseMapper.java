package com.fissionx.lumi.mapper;

import com.fissionx.lumi.model.rest.response.ErrorResponse;
import com.fissionx.lumi.utils.HTTPStatus;
import org.springframework.http.HttpStatus;

public class ErrorResponseMapper {
    public static ErrorResponse getErrorResponse(HTTPStatus HTTPStatus, HttpStatus httpStatus, Exception e){
        ErrorResponse errorResponse = new ErrorResponse(
                HTTPStatus.getValue(),
                httpStatus.value(),
                e.getMessage(),
                System.currentTimeMillis(),
                e.toString()
        );
        return errorResponse;
    }

    public static ErrorResponse getErrorResponse(HTTPStatus HTTPStatus, HttpStatus httpStatus, String message){
        ErrorResponse errorResponse = new ErrorResponse(
                HTTPStatus.getValue(),
                httpStatus.value(),
                message,
                System.currentTimeMillis(),message
        );
        return errorResponse;
    }
}
