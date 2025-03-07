package com.fissionx.lumi.transformer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fissionx.form.store.entity.Workspace;
import com.fissionx.form.store.transformers.WorkspaceTransformer;
import com.fissionx.lumi.model.rest.WorkspaceDto;

public class WorkspaceEntityTransformer implements WorkspaceTransformer<WorkspaceDto> {

    @Override
    public Workspace transformToWorkspace(WorkspaceDto source) {
        Workspace workspace=new Workspace();
        workspace.setDescription(source.getDescription());
        workspace.setTitle(source.getWorkspaceName());
        workspace.setUserId(source.getUserId());
        workspace.setCreatedAt(System.currentTimeMillis());
        workspace.setUpdatedAt(System.currentTimeMillis());
        return workspace;
    }

    @Override
    public WorkspaceDto transformToWorkspace(Workspace source) {
        WorkspaceDto workspaceDto=new WorkspaceDto();

        workspaceDto.setWorkspaceId(source.getWorkspaceId());
        workspaceDto.setWorkspaceName(source.getTitle());
        workspaceDto.setDescription(source.getDescription());
        workspaceDto.setUserId(source.getUserId());
        workspaceDto.setCreatedAt(source.getCreatedAt());
        workspaceDto.setUpdatedAt(source.getUpdatedAt());
        workspaceDto.setFormIds(source.getFormIds());

        return workspaceDto;
    }
}
