package com.fissionx.lumi.controller;

import com.fissionx.lumi.exceptions.InternalServerException;
import com.fissionx.lumi.model.rest.FormDto;
import com.fissionx.lumi.model.rest.response.FormWithSubmissionData;
import com.fissionx.lumi.model.rest.response.FormsResponse;
import com.fissionx.lumi.model.rest.response.GenericContollerResponse;
import com.fissionx.lumi.service.FormsService;
import com.fissionx.lumi.service.ResponseService;
import com.fissionx.lumi.utils.APIResponseFactory;
import com.fissionx.lumi.utils.GlobelExceptionThrowable;
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
public class ResponseController {
    private final ResponseService responseService;

    public ResponseController(ResponseService responseService) {
        this.responseService = responseService;
    }

//    @Operation(summary = "create form", description = "Post request for creating form")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Successfully retrieved all responses"),
//            @ApiResponse(responseCode = "500", description = "Internal server error")
//    })
//    @PostMapping
//    public ResponseEntity<FormsControllerBaseResponse<FormsResponse>> createItem(@RequestBody FormDto formDto) {
//        try {
//            FormDto response=formsService.createOrUpdateForm(formDto);
//            FormsResponse formsResponse=new FormsResponse();
//            List<FormDto> formDtos=new ArrayList<>();
//            formDtos.add(response);
//            formsResponse.setForms(formDtos);
//            FormsControllerBaseResponse<FormsResponse> finalResponse=new FormsControllerBaseResponse<FormsResponse>() {};
//            finalResponse.setCode(201);
//            finalResponse.setStatus( HttpStatus.CREATED.getReasonPhrase());
//            finalResponse.setData( formsResponse);
//            finalResponse.setTimestamp(System.currentTimeMillis());
//            finalResponse.setMessage("forms successfully created");
//            return new ResponseEntity<>(finalResponse, HttpStatus.CREATED);
//        }catch (Exception e){
//            throw new InternalServerException("Something is wrong"+e.getCause());
//        }
//
//    }

    @GetMapping("/response/{formId}")
    public ResponseEntity<GenericContollerResponse<FormWithSubmissionData>> getFromById(@PathVariable String formId) {
        GenericContollerResponse<FormWithSubmissionData> finalResponse=null;
        try{
            FormWithSubmissionData response=responseService.getForm(formId,"");
            finalResponse= APIResponseFactory.createSuccessResponse(response, null);
        }catch (Exception e){
            GlobelExceptionThrowable.throwException(e);
        }
        return new ResponseEntity<>(finalResponse, HttpStatus.OK);
    }
}

