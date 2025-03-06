package com.fissionx.lumi.controller;

import com.fissionx.lumi.model.rest.FormDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/forms")
public class BaseController {

    @Operation(summary = "Get all responses", description = "Fetches all survey responses")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved all responses"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping
    public ResponseEntity<FormDto> createItem(@RequestBody FormDto formDto) {
        return new ResponseEntity<>(formDto, HttpStatus.CREATED);
    }
}

