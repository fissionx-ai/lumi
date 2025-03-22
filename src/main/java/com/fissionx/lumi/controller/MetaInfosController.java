//package com.fissionx.lumi.controller;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fissionx.lumi.entity.SettingsMeta;
//import com.fissionx.lumi.model.rest.WorkspaceDto;
//import com.fissionx.lumi.model.rest.request.WorkspaceCreateRequest;
//import com.fissionx.lumi.model.rest.response.DeleteWorkspaceResponse;
//import com.fissionx.lumi.model.rest.response.GenericContollerResponse;
//import com.fissionx.lumi.model.rest.response.SettingsInfoResponse;
//import com.fissionx.lumi.model.rest.response.WorkspaceResponse;
//import com.fissionx.lumi.service.MetaInfoService;
//import com.fissionx.lumi.service.WorkspaceService;
//import com.fissionx.lumi.utils.APIResponseFactory;
//import com.fissionx.lumi.utils.GlobelExceptionThrowable;
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.tags.Tag;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/v1/forms/workspace")
//@Tag(name = "MetaInfos",description = "All forms configurations")
//public class MetaInfosController {
//    private final MetaInfoService metaInfoService;
//
//    public MetaInfosController( MetaInfoService metaInfoService) {
//        this.metaInfoService = metaInfoService;
//    }
//
//    @Operation(summary = "Create new settings")
//    @PostMapping
//    public ResponseEntity<GenericContollerResponse<SettingsInfoResponse>> createSetting(@RequestBody SettingsMeta request) {
//        GenericContollerResponse<WorkspaceResponse> finalResponse=null;
//        try {
//            WorkspaceDto inputDto=objectMapper.convertValue(request,WorkspaceDto.class);
//            WorkspaceDto response=workspaceService.createOrUpdateWorkspace(inputDto);
//            WorkspaceResponse workspaceResponse=new WorkspaceResponse();
//            List<WorkspaceDto> workspaceDtos=new ArrayList<>();
//            workspaceDtos.add(response);
//            workspaceResponse.setWorkspaces(workspaceDtos);
//            finalResponse=APIResponseFactory.createdResponse(workspaceResponse, "workspace creation has been successful");
//        }catch (Exception e){
//            GlobelExceptionThrowable.throwException(e);
//        }
//        return new ResponseEntity<>(finalResponse, HttpStatus.CREATED);
//    }
//
//    @Operation(summary = "Create new workspace for given userId")
//    @PutMapping("/update")
//    public ResponseEntity<GenericContollerResponse<WorkspaceResponse>> updateItem(@RequestBody WorkspaceDto request) {
//        GenericContollerResponse<WorkspaceResponse> finalResponse=null;
//        try {
//            WorkspaceDto response=workspaceService.createOrUpdateWorkspace(request);
//            WorkspaceResponse workspaceResponse=new WorkspaceResponse();
//            List<WorkspaceDto> workspaceDtos=new ArrayList<>();
//            workspaceDtos.add(response);
//            workspaceResponse.setWorkspaces(workspaceDtos);
//            finalResponse=APIResponseFactory.createdResponse(workspaceResponse, "workspace creation has been successful");
//        }catch (Exception e){
//            GlobelExceptionThrowable.throwException(e);
//        }
//        return new ResponseEntity<>(finalResponse, HttpStatus.CREATED);
//    }
//
//    @Operation(summary = "Get workspace details by userId")
//    @GetMapping
//    public ResponseEntity<GenericContollerResponse<WorkspaceResponse>> getworkspaceByUserId(@RequestParam("userId") String userId ) {
//        GenericContollerResponse<WorkspaceResponse> finalResponse=null;
//        try{
//            List<WorkspaceDto> response=workspaceService.getWorkspaceByUserId(userId);
//            WorkspaceResponse workspaceResponse=new WorkspaceResponse();
//            workspaceResponse.setWorkspaces(response);
//            finalResponse=APIResponseFactory.createSuccessResponse(workspaceResponse, "request was successful");
//        }catch (Exception e){
//            GlobelExceptionThrowable.throwException(e);
//        }
//        return new ResponseEntity<>(finalResponse, HttpStatus.OK);
//    }
//
//    @Operation(summary = "Get workspace details by workspaceId")
//    @GetMapping("/{workspaceId}")
//    public ResponseEntity<GenericContollerResponse<WorkspaceResponse>> getFromById(@PathVariable String workspaceId ) {
//        GenericContollerResponse<WorkspaceResponse> finalResponse=null;
//        try{
//            WorkspaceDto response=workspaceService.getWorkspaceById(workspaceId);
//            WorkspaceResponse workspaceResponse=new WorkspaceResponse();
//            List<WorkspaceDto> workspaceDtos=new ArrayList<>();
//            workspaceDtos.add(response);
//            workspaceResponse.setWorkspaces(workspaceDtos);
//            finalResponse=APIResponseFactory.createSuccessResponse(workspaceResponse, "request was successful");
//        }catch (Exception e){
//            GlobelExceptionThrowable.throwException(e);
//        }
//        return new ResponseEntity<>(finalResponse, HttpStatus.OK);
//    }
//
//    @Operation(summary = "Delete workspace by workspaceId")
//    @DeleteMapping("/{workspaceId}")
//    public ResponseEntity<GenericContollerResponse<DeleteWorkspaceResponse>> deleteByFromById(@PathVariable String workspaceId ) {
//        GenericContollerResponse<DeleteWorkspaceResponse> finalResponse=null;
//        try{
//            DeleteWorkspaceResponse response=workspaceService.deleteWorkspaceById(workspaceId);
//            finalResponse=APIResponseFactory.createSuccessResponse(response, "workspace deleted successfully");
//        }catch (Exception e){
//            GlobelExceptionThrowable.throwException(e);
//        }
//        return new ResponseEntity<>(finalResponse, HttpStatus.OK);
//    }
//
//}
//
