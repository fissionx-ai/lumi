package com.fissionx.lumi.utils;

import com.fissionx.lumi.exceptions.*;
import org.springframework.web.client.HttpServerErrorException;

public class GlobelExceptionThrowable {
    public static void throwException(Exception e){
        switch (e) {
            case BadRequestException badRequestException -> throw new BadRequestException(e.getMessage());
            case DBUpsertException dbUpsertException -> throw new DBUpsertException(e.getMessage());
            case ForbiddenException forbiddenException -> throw new ForbiddenException(e.getMessage());
            case HttpServerErrorException.InternalServerError internalServerException ->
                    throw new InternalServerException(e.getMessage());
            case NotFoundException notFoundException -> throw new NotFoundException(e.getMessage());
            case DeleteRequestFailedException deleteRequestFailedException -> throw new DeleteRequestFailedException(e.getMessage());
            default -> throw new RuntimeException(e.getMessage());
        }
    }
}
