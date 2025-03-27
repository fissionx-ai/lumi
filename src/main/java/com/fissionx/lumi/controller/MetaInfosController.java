package com.fissionx.lumi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fissionx.lumi.entity.DataTypes;
import com.fissionx.lumi.entity.SettingsMeta;
import com.fissionx.lumi.model.rest.WorkspaceDto;
import com.fissionx.lumi.model.rest.request.MetaDataTypesRequest;
import com.fissionx.lumi.model.rest.request.MetaSettingRequest;
import com.fissionx.lumi.model.rest.request.WorkspaceCreateRequest;
import com.fissionx.lumi.model.rest.response.*;
import com.fissionx.lumi.service.MetaInfoService;
import com.fissionx.lumi.service.WorkspaceService;
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
@RequestMapping("/api/v1/forms/meta")
@Tag(name = "MetaInfos",description = "All forms configurations")
@CrossOrigin(origins = "*")
public class MetaInfosController {
    private final MetaInfoService metaInfoService;
    private final ObjectMapper objectMapper=new ObjectMapper();

    public MetaInfosController( MetaInfoService metaInfoService) {
        this.metaInfoService = metaInfoService;
    }
    @Operation(summary = "Create new settings applies for forms application")
    @PostMapping("/settings")
    public ResponseEntity<GenericContollerResponse<SettingsInfoResponse>> createDataTypes(@RequestBody List<MetaSettingRequest> request) {
        GenericContollerResponse<SettingsInfoResponse> finalResponse=null;
        try {
            List<SettingsMeta> list =request.stream().map(item-> objectMapper.convertValue(item,SettingsMeta.class)).toList();
            List<SettingsMeta> response=metaInfoService.addSettingsInfo(list);
            SettingsInfoResponse settingsInfoResponse=new SettingsInfoResponse();
            settingsInfoResponse.setSettingsMetaList(response);
            finalResponse=APIResponseFactory.createdResponse(settingsInfoResponse, "settings creation has been successful");
        }catch (Exception e){
            GlobelExceptionThrowable.throwException(e);
        }
        return new ResponseEntity<>(finalResponse, HttpStatus.CREATED);
    }

    @Operation(summary = "Create new data types applies for forms application")
    @PostMapping("/datatypes")
    public ResponseEntity<GenericContollerResponse<DataTypesResponse>> createSetting(@RequestBody List<MetaDataTypesRequest> request) {
        GenericContollerResponse<DataTypesResponse> finalResponse=null;
        try {
            List<DataTypes> list =request.stream().map(item-> objectMapper.convertValue(item,DataTypes.class)).toList();
            List<DataTypes> response=metaInfoService.addDataTypes(list);
            DataTypesResponse dataTypesResponse=new DataTypesResponse();
            dataTypesResponse.setDataTypes(response);
            finalResponse=APIResponseFactory.createdResponse(dataTypesResponse, "data types creation has been successful");
        }catch (Exception e){
            GlobelExceptionThrowable.throwException(e);
        }
        return new ResponseEntity<>(finalResponse, HttpStatus.CREATED);
    }

    @Operation(summary = "Get settings details for forms")
    @GetMapping("/settings")
    public ResponseEntity<GenericContollerResponse<SettingsInfoResponse>> getAllSettings( ) {
        GenericContollerResponse<SettingsInfoResponse> finalResponse=null;
        try{
            List<SettingsMeta> response=metaInfoService.getSettingsMetaInfo();
            SettingsInfoResponse settingsInfoResponse=new SettingsInfoResponse();
            settingsInfoResponse.setSettingsMetaList(response);
            finalResponse=APIResponseFactory.createSuccessResponse(settingsInfoResponse, "request was successful");
        }catch (Exception e){
            GlobelExceptionThrowable.throwException(e);
        }
        return new ResponseEntity<>(finalResponse, HttpStatus.OK);
    }

    @Operation(summary = "Get data types details for forms")
    @GetMapping("/datatypes")
    public ResponseEntity<GenericContollerResponse<DataTypesResponse>> getDatatypes( ) {
        GenericContollerResponse<DataTypesResponse> finalResponse=null;
        try{
            List<DataTypes> response=metaInfoService.getDataTypes();
            DataTypesResponse dataTypesResponse=new DataTypesResponse();
            dataTypesResponse.setDataTypes(response);
            finalResponse=APIResponseFactory.createSuccessResponse(dataTypesResponse, "request was successful");
        }catch (Exception e){
            GlobelExceptionThrowable.throwException(e);
        }
        return new ResponseEntity<>(finalResponse, HttpStatus.OK);
    }


}

