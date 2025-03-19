package com.fissionx.lumi.controller;

import com.fissionx.lumi.exceptions.*;
import com.fissionx.lumi.model.rest.FormDto;
import com.fissionx.lumi.model.rest.response.FormsResponse;
import com.fissionx.lumi.model.rest.response.GenericContollerResponse;
import com.fissionx.lumi.service.FormsService;
import com.fissionx.lumi.utils.APIResponseFactory;
import com.fissionx.lumi.utils.GlobelExceptionThrowable;
import com.fissionx.lumi.utils.HTTPStatus;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/forms")
public class FormsController {
    private final FormsService formsService;

    public FormsController(FormsService formsService) {
        this.formsService = formsService;
    }

//    @Operation(summary = "create form", description = "Post request for creating form")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Successfully retrieved all responses"),
//            @ApiResponse(responseCode = "500", description = "Internal server error")
//    })
    @PostMapping
    public ResponseEntity<GenericContollerResponse<FormsResponse>> createItem(@RequestBody FormDto formDto) {
        GenericContollerResponse<FormsResponse> finalResponse=null;
        try {
            FormDto response=formsService.createOrUpdateForm(formDto);
            FormsResponse formsResponse=new FormsResponse();
            List<FormDto> formDtos=new ArrayList<>();
            formDtos.add(response);
            formsResponse.setForms(formDtos);
            finalResponse=APIResponseFactory.createSuccessResponse(formsResponse, null);
        }catch (Exception e){
            GlobelExceptionThrowable.throwException(e);
        }
        return new ResponseEntity<>(finalResponse, HttpStatus.CREATED);
    }

    @GetMapping("/{formId}")
    public ResponseEntity<GenericContollerResponse<FormsResponse>> getFromById(@PathVariable String formId) {
        GenericContollerResponse<FormsResponse> finalResponse=null;

        try{
            FormDto response=formsService.getFormById(formId);
            FormsResponse formsResponse=new FormsResponse();
            List<FormDto> formDtos=new ArrayList<>();
            formDtos.add(response);
            formsResponse.setForms(formDtos);
            finalResponse=APIResponseFactory.createSuccessResponse(formsResponse, null);
        }catch (Exception e){
            GlobelExceptionThrowable.throwException(e);
        }
        return new ResponseEntity<>(finalResponse, HttpStatus.OK);
    }
}

