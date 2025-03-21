package com.fissionx.lumi.controller;

import com.fissionx.lumi.model.rest.FormDto;
import com.fissionx.lumi.model.rest.response.DeleteFormResponse;
import com.fissionx.lumi.model.rest.response.FormsResponse;
import com.fissionx.lumi.model.rest.response.GenericContollerResponse;
import com.fissionx.lumi.service.FormsService;
import com.fissionx.lumi.utils.APIResponseFactory;
import com.fissionx.lumi.utils.GlobelExceptionThrowable;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/forms")
@Tag(name = "",description = "")
public class MetaDatasController {
//    private final FormsService formsService;
//
//    public MetaDatasController(FormsService formsService) {
//        this.formsService = formsService;
//    }
//
//    @Operation(summary = "this is about that")
//    @PostMapping
//    public ResponseEntity<GenericContollerResponse<FormsResponse>> createItem(@RequestBody FormDto formDto) {
//        GenericContollerResponse<FormsResponse> finalResponse=null;
//        try {
//            FormDto response=formsService.createOrUpdateForm(formDto);
//            FormsResponse formsResponse=new FormsResponse();
//            List<FormDto> formDtos=new ArrayList<>();
//            formDtos.add(response);
//            formsResponse.setForms(formDtos);
//            finalResponse=APIResponseFactory.createSuccessResponse(formsResponse, "form creation has been successful");
//        }catch (Exception e){
//            GlobelExceptionThrowable.throwException(e);
//        }
//        return new ResponseEntity<>(finalResponse, HttpStatus.CREATED);
//    }
//
//    @GetMapping("/{formId}")
//    public ResponseEntity<GenericContollerResponse<FormsResponse>> getFromById(@PathVariable String formId ) {
//        GenericContollerResponse<FormsResponse> finalResponse=null;
//        try{
//            FormDto response=formsService.getFormById(formId);
//            FormsResponse formsResponse=new FormsResponse();
//            List<FormDto> formDtos=new ArrayList<>();
//            formDtos.add(response);
//            formsResponse.setForms(formDtos);
//            finalResponse=APIResponseFactory.createSuccessResponse(formsResponse, "request was successful");
//        }catch (Exception e){
//            GlobelExceptionThrowable.throwException(e);
//        }
//        return new ResponseEntity<>(finalResponse, HttpStatus.OK);
//    }
//
//    @DeleteMapping("/{formId}")
//    public ResponseEntity<GenericContollerResponse<DeleteFormResponse>> deleteByFromById(@PathVariable String formId ) {
//        GenericContollerResponse<DeleteFormResponse> finalResponse=null;
//        try{
//            Boolean response=formsService.deleteFormById(formId);
//            DeleteFormResponse formsResponse=new DeleteFormResponse();
//            formsResponse.setFormId(formId);
//            formsResponse.setIsDeleted(response);
//            finalResponse=APIResponseFactory.createSuccessResponse(formsResponse, "form deleted successfully");
//        }catch (Exception e){
//            GlobelExceptionThrowable.throwException(e);
//        }
//        return new ResponseEntity<>(finalResponse, HttpStatus.OK);
//    }

}

