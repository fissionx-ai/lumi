package com.fissionx.lumi.service.impl;

import com.fissionx.lumi.model.rest.WorkspaceDto;
import com.fissionx.lumi.model.rest.response.DeleteWorkspaceResponse;
import com.fissionx.lumi.service.WorkspaceService;

import java.util.List;

public class WorkspaceServiceImpl implements WorkspaceService {
    @Override
    public WorkspaceDto createWorkspace(WorkspaceDto createRequest) {
        return null;
    }

    @Override
    public WorkspaceDto updateWorkSpace(WorkspaceDto updateRequest) {
        return null;
    }

    @Override
    public WorkspaceDto getWorkspaceById(String workspaceId) {
        return null;
    }

    @Override
    public List<WorkspaceDto> getWorkspaceByUserId(String userId) {
        return List.of();
    }

    @Override
    public DeleteWorkspaceResponse deleteWorkspaceById(String workspaceId) {
        return null;
    }
}
