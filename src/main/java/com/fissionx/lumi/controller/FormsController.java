package com.fissionx.lumi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fissionx.lumi.model.rest.FormDto;
import com.fissionx.lumi.model.rest.request.FormCreateRequest;
import com.fissionx.lumi.model.rest.response.DeleteFormResponse;
import com.fissionx.lumi.model.rest.response.FormsResponse;
import com.fissionx.lumi.model.rest.response.GenericContollerResponse;
import com.fissionx.lumi.service.FormsService;
import com.fissionx.lumi.utils.APIResponseFactory;
import com.fissionx.lumi.utils.GlobelExceptionThrowable;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.headers.Header;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/forms")
@Tag(name = "Forms",description = "All the forms entity related apis")
@CrossOrigin(origins = "*")
public class FormsController {
    private final FormsService formsService;
    private final ObjectMapper objectMapper=new ObjectMapper();

    public FormsController(FormsService formsService) {
        this.formsService = formsService;
    }

    @Operation(summary = "Create form request")
    @PostMapping
    public ResponseEntity<GenericContollerResponse<FormsResponse>> createItem(@RequestBody FormCreateRequest request) {
        GenericContollerResponse<FormsResponse> finalResponse=null;
        try {
            FormDto inputDto=objectMapper.convertValue(request,FormDto.class);
            FormDto response=formsService.createOrUpdateForm(inputDto);
            FormsResponse formsResponse=new FormsResponse();
            List<FormDto> formDtos=new ArrayList<>();
            formDtos.add(response);
            formsResponse.setForms(formDtos);
            finalResponse=APIResponseFactory.createSuccessResponse(formsResponse, "form creation has been successful");
        }catch (Exception e){
            GlobelExceptionThrowable.throwException(e);
        }
        return new ResponseEntity<>(finalResponse, HttpStatus.CREATED);
    }

    @Operation(summary = "update form by formId")
    @PutMapping("/update")
    public ResponseEntity<GenericContollerResponse<FormsResponse>> updateItem(@RequestBody FormDto request) {
        GenericContollerResponse<FormsResponse> finalResponse=null;
        try {
            FormDto response=formsService.createOrUpdateForm(request);
            FormsResponse formsResponse=new FormsResponse();
            List<FormDto> formDtos=new ArrayList<>();
            formDtos.add(response);
            formsResponse.setForms(formDtos);
            finalResponse=APIResponseFactory.createSuccessResponse(formsResponse, "form update has been successful");
        }catch (Exception e){
            GlobelExceptionThrowable.throwException(e);
        }
        return new ResponseEntity<>(finalResponse, HttpStatus.CREATED);
    }

    @Operation(summary = "Get form by formId")
    @GetMapping("/{formId}")
    public ResponseEntity<GenericContollerResponse<FormsResponse>> getFromById(@PathVariable String formId ) {
        GenericContollerResponse<FormsResponse> finalResponse=null;
        try{
            FormDto response=formsService.getFormById(formId);
            FormsResponse formsResponse=new FormsResponse();
            List<FormDto> formDtos=new ArrayList<>();
            formDtos.add(response);
            formsResponse.setForms(formDtos);
            finalResponse=APIResponseFactory.createSuccessResponse(formsResponse, "request was successful");
        }catch (Exception e){
            GlobelExceptionThrowable.throwException(e);
        }
        return new ResponseEntity<>(finalResponse, HttpStatus.OK);
    }

    @Operation(summary = "Get forms by workspaceId")
    @GetMapping("/workspace")
    public ResponseEntity<GenericContollerResponse<FormsResponse>> getFromByWorkspace(@RequestParam("workspaceId") String workspaceId) {
        GenericContollerResponse<FormsResponse> finalResponse=null;
        try{
            List<FormDto> response=formsService.getFormByWorkspaceId(workspaceId);
            FormsResponse formsResponse=new FormsResponse();
            formsResponse.setForms(response);
            finalResponse=APIResponseFactory.createSuccessResponse(formsResponse, "request was successful");
        }catch (Exception e){
            GlobelExceptionThrowable.throwException(e);
        }
        return new ResponseEntity<>(finalResponse, HttpStatus.OK);
    }

    @Operation(summary = "Get forms by userId")
    @GetMapping("/user")
    public ResponseEntity<GenericContollerResponse<FormsResponse>> getFromByUser(@RequestParam("userId") String userId) {
        GenericContollerResponse<FormsResponse> finalResponse=null;
        try{
            List<FormDto> response=formsService.getFormByUserId(userId);
            FormsResponse formsResponse=new FormsResponse();
            formsResponse.setForms(response);
            finalResponse=APIResponseFactory.createSuccessResponse(formsResponse, "request was successful");
        }catch (Exception e){
            GlobelExceptionThrowable.throwException(e);
        }
        return new ResponseEntity<>(finalResponse, HttpStatus.OK);
    }

    @Operation(summary = "Get favorites forms by userId")
    @GetMapping("/favorites")
    public ResponseEntity<GenericContollerResponse<FormsResponse>> getFavs(@RequestParam("userId") String userId) {
        GenericContollerResponse<FormsResponse> finalResponse=null;
        try{
            List<FormDto> response=formsService.getFaviouresByUserId(userId);
            FormsResponse formsResponse=new FormsResponse();
            formsResponse.setForms(response);
            finalResponse=APIResponseFactory.createSuccessResponse(formsResponse, "request was successful");
        }catch (Exception e){
            GlobelExceptionThrowable.throwException(e);
        }
        return new ResponseEntity<>(finalResponse, HttpStatus.OK);
    }
    @Operation(summary = "Get recent forms by userId")
    @GetMapping("/recent")
    public ResponseEntity<GenericContollerResponse<FormsResponse>> getRecentForms(@RequestParam("userId") String userId) {
        GenericContollerResponse<FormsResponse> finalResponse=null;
        try{
            List<FormDto> response=formsService.getRecentFormsByUserId(userId);
            FormsResponse formsResponse=new FormsResponse();
            formsResponse.setForms(response);
            finalResponse=APIResponseFactory.createSuccessResponse(formsResponse, "request was successful");
        }catch (Exception e){
            GlobelExceptionThrowable.throwException(e);
        }
        return new ResponseEntity<>(finalResponse, HttpStatus.OK);
    }


    @Operation(summary = "Delete form by formId")
    @DeleteMapping("/{formId}")
    public ResponseEntity<GenericContollerResponse<DeleteFormResponse>> deleteByFromById(@PathVariable String formId ) {
        GenericContollerResponse<DeleteFormResponse> finalResponse=null;
        try{
            Boolean response=formsService.deleteFormById(formId);
            DeleteFormResponse formsResponse=new DeleteFormResponse();
            formsResponse.setFormId(formId);
            formsResponse.setIsDeleted(response);
            finalResponse=APIResponseFactory.createSuccessResponse(formsResponse, "form deleted successfully");
        }catch (Exception e){
            GlobelExceptionThrowable.throwException(e);
        }
        return new ResponseEntity<>(finalResponse, HttpStatus.OK);
    }

    @Operation(summary = "update form status by formId")
    @PutMapping("/status/{formId}")
    public ResponseEntity<GenericContollerResponse<Boolean>> updateFormStatus(@PathVariable String formId) {
        GenericContollerResponse<Boolean> finalResponse=null;

        try{
            Boolean response=formsService.updateFormStatus(formId);
            finalResponse=APIResponseFactory.createSuccessResponse(response, "request was successful");
        }catch (Exception e){
            GlobelExceptionThrowable.throwException(e);
        }
        return new ResponseEntity<>(finalResponse, HttpStatus.OK);
    }


}

