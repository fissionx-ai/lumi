package com.fissionx.lumi.handler;

import com.fissionx.lumi.exceptions.*;
import com.fissionx.lumi.mapper.ErrorResponseMapper;
import com.fissionx.lumi.model.rest.response.ErrorResponse;
import com.fissionx.lumi.utils.HTTPStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Handle all exceptions
    @ExceptionHandler(InternalServerException.class)
    public ResponseEntity<ErrorResponse> handleException(Exception e) {
        return new ResponseEntity<>(ErrorResponseMapper.getErrorResponse(HTTPStatus.ERROR, HttpStatus.INTERNAL_SERVER_ERROR, e), HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @ExceptionHandler(DeleteRequestFailedException.class)
    public ResponseEntity<ErrorResponse> handleDeleteRequestException(Exception e) {
        return new ResponseEntity<>(ErrorResponseMapper.getErrorResponse(HTTPStatus.ERROR, HttpStatus.INTERNAL_SERVER_ERROR, e), HttpStatus.INTERNAL_SERVER_ERROR);

    }
    @ExceptionHandler(DBUpsertException.class)
    public ResponseEntity<ErrorResponse> handleDbUpsertionException(Exception e) {
        return new ResponseEntity<>(ErrorResponseMapper.getErrorResponse(HTTPStatus.ERROR, HttpStatus.INTERNAL_SERVER_ERROR, e), HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorResponse> handleBadRequestException(BadRequestException e) {
        return new ResponseEntity<>(ErrorResponseMapper.getErrorResponse(HTTPStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST, e), HttpStatus.BAD_REQUEST);

    }
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFoundException(NotFoundException e) {
        return new ResponseEntity<>(ErrorResponseMapper.getErrorResponse(HTTPStatus.NOT_FOUND, HttpStatus.BAD_REQUEST, e), HttpStatus.BAD_REQUEST);

    }
    @ExceptionHandler(ForbiddenException.class)
    public ResponseEntity<ErrorResponse> handleUnAuthRequestException(ForbiddenException e) {
        return new ResponseEntity<>(ErrorResponseMapper.getErrorResponse(HTTPStatus.UNAUTHORIZED, HttpStatus.UNAUTHORIZED, e), HttpStatus.UNAUTHORIZED);
    }
}
