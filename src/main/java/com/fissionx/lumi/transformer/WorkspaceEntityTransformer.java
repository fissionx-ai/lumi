package com.fissionx.lumi.transformer;

import com.fissionx.lumi.entity.Workspace;
import com.fissionx.lumi.transformers.WorkspaceTransformer;
import com.fissionx.lumi.model.rest.WorkspaceDto;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class WorkspaceEntityTransformer implements WorkspaceTransformer<WorkspaceDto> {

    @Override
    public Workspace transformToWorkspace(WorkspaceDto source) {
        Workspace workspace=new Workspace();
        workspace.setDescription(source.getDescription());
        workspace.setTitle(source.getWorkspaceName());
        workspace.setUserId(source.getUserId());
        workspace.setAccess(source.getPermission());
        workspace.setDescription(source.getDescription());
        if(source.getWorkspaceId()!=null){
            workspace.setWorkspaceId(UUID.fromString(source.getWorkspaceId()));
            workspace.setCreatedAt(source.getCreatedAt());
        }else{
            workspace.setCreatedAt(System.currentTimeMillis());
        }
        workspace.setUpdatedAt(System.currentTimeMillis());
        return workspace;
    }

    @Override
    public WorkspaceDto transformToWorkspace(Workspace source) {
        WorkspaceDto workspaceDto=new WorkspaceDto();

        workspaceDto.setWorkspaceId(source.getWorkspaceId().toString());
        workspaceDto.setWorkspaceName(source.getTitle());
        workspaceDto.setDescription(source.getDescription());
        workspaceDto.setUserId(source.getUserId());
        workspaceDto.setCreatedAt(source.getCreatedAt());
        workspaceDto.setUpdatedAt(source.getUpdatedAt());
        workspaceDto.setFormIds(source.getFormIds());
        workspaceDto.setPermission(source.getAccess());

        return workspaceDto;
    }
}
