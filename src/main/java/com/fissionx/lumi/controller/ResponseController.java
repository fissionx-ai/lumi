package com.fissionx.lumi.controller;

import com.fissionx.lumi.exceptions.InternalServerException;
import com.fissionx.lumi.model.rest.FormDto;
import com.fissionx.lumi.model.rest.response.*;
import com.fissionx.lumi.service.FormsService;
import com.fissionx.lumi.service.ResponseService;
import com.fissionx.lumi.utils.APIResponseFactory;
import com.fissionx.lumi.utils.GlobelExceptionThrowable;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/forms/response")
@Tag(name = "Response submission APIS",description = "all the apis related to response collections ")
public class ResponseController {
    private final ResponseService responseService;

    public ResponseController(ResponseService responseService) {
        this.responseService = responseService;
    }

    @Operation(summary = "Delete workspace by workspaceId")
    @GetMapping("/{formId}")
    public ResponseEntity<GenericContollerResponse<FormWithSubmissionData>> getFromById(@PathVariable String formId, @RequestParam("userId") String userId) {
        GenericContollerResponse<FormWithSubmissionData> finalResponse=null;
        try{
            FormWithSubmissionData response=responseService.getForm(formId,userId);
            finalResponse= APIResponseFactory.createSuccessResponse(response, "form fetched successfully");
        }catch (Exception e){
            GlobelExceptionThrowable.throwException(e);
        }
        return new ResponseEntity<>(finalResponse, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<GenericContollerResponse<FormWithSubmissionData>> collectResponse(@RequestBody FormWithSubmissionData formWithSubmissionData ) {
        GenericContollerResponse<FormWithSubmissionData> finalResponse=null;
        try{
            FormWithSubmissionData response=responseService.formSubmission(formWithSubmissionData);
            finalResponse= APIResponseFactory.createdResponse(response, "response has been stored");
        }catch (Exception e){
            GlobelExceptionThrowable.throwException(e);
        }
        return new ResponseEntity<>(finalResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{formId}/{responseId}")
    public ResponseEntity<GenericContollerResponse<DeleteSubmissionResponse>> deleteResponse(@PathVariable String formId, @PathVariable String responseId ) {
        GenericContollerResponse<DeleteSubmissionResponse> finalResponse=null;
        try{
            Boolean response=responseService.deleteResponse(responseId,formId);
            DeleteSubmissionResponse deleteSubmissionResponse=new DeleteSubmissionResponse(formId,responseId,response);
            finalResponse= APIResponseFactory.createSuccessResponse(deleteSubmissionResponse, "response has been deleted");
        }catch (Exception e){
            GlobelExceptionThrowable.throwException(e);
        }
        return new ResponseEntity<>(finalResponse, HttpStatus.OK);
    }
}

