package com.fissionx.lumi.controller;

import com.fissionx.lumi.exceptions.InternalServerException;
import com.fissionx.lumi.model.rest.FormDto;
import com.fissionx.lumi.model.rest.response.FormsControllerBaseResponse;
import com.fissionx.lumi.model.rest.response.FormsResponse;
import com.fissionx.lumi.service.FormsService;
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

    @Operation(summary = "create form", description = "Post request for creating form")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved all responses"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping
    public ResponseEntity<FormsControllerBaseResponse<FormsResponse>> createItem(@RequestBody FormDto formDto) {
        try {
            FormDto response=formsService.createOrUpdateForm(formDto);
            FormsResponse formsResponse=new FormsResponse();
            List<FormDto> formDtos=new ArrayList<>();
            formDtos.add(response);
            formsResponse.setForms(formDtos);
            FormsControllerBaseResponse<FormsResponse> finalResponse=new FormsControllerBaseResponse<FormsResponse>() {};
            finalResponse.setCode(201);
            finalResponse.setStatus( HttpStatus.CREATED.getReasonPhrase());
            finalResponse.setData( formsResponse);
            finalResponse.setTimestamp(System.currentTimeMillis());
            finalResponse.setMessage("forms successfully created");
            return new ResponseEntity<>(finalResponse, HttpStatus.CREATED);
        }catch (Exception e){
            throw new InternalServerException("Something is wrong"+e.getCause());
        }

    }

    @GetMapping("/{formId}")
    public ResponseEntity<FormsControllerBaseResponse<FormsResponse>> getFromById(@PathVariable String formId) {
        try{
            FormDto response=formsService.getFormById(formId);
            FormsResponse formsResponse=new FormsResponse();
            List<FormDto> formDtos=new ArrayList<>();
            formDtos.add(response);
            formsResponse.setForms(formDtos);
            FormsControllerBaseResponse<FormsResponse> finalResponse=new FormsControllerBaseResponse<FormsResponse>() {};
            finalResponse.setCode(201);
            finalResponse.setStatus( HttpStatus.OK.getReasonPhrase());
            finalResponse.setData( formsResponse);
            finalResponse.setTimestamp(System.currentTimeMillis());
            finalResponse.setMessage("forms successfully created");
            return new ResponseEntity<>(finalResponse, HttpStatus.OK);
        }catch (Exception e){
            throw new InternalServerException("Something is wrong"+e.getCause());
        }

    }
}

