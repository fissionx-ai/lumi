package com.fissionx.lumi.service;

import com.fissionx.lumi.model.rest.WorkspaceDto;
import com.fissionx.lumi.model.rest.response.DeleteWorkspaceResponse;

import java.util.List;

public interface WorkspaceService {
    WorkspaceDto createOrUpdateWorkspace(WorkspaceDto createRequest);
    WorkspaceDto getWorkspaceById(String workspaceId);
    List<WorkspaceDto> getWorkspaceByUserId(String userId);
    DeleteWorkspaceResponse deleteWorkspaceById(String workspaceId);
    WorkspaceDto addFormToWorkspace(String formId);

}
