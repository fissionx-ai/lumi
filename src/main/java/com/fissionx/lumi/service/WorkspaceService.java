package com.fissionx.lumi.service;

import com.fissionx.lumi.model.rest.WorkspaceDto;
import com.fissionx.lumi.model.rest.response.DeleteWorkspaceResponse;

import java.util.List;

public interface WorkspaceService {
    WorkspaceDto createWorkspace(WorkspaceDto createRequest);
    WorkspaceDto updateWorkSpace(WorkspaceDto updateRequest);
    WorkspaceDto getWorkspaceById(String workspaceId);
    List<WorkspaceDto> getWorkspaceByUserId(String userId);
    DeleteWorkspaceResponse deleteWorkspaceById(String workspaceId);
}
