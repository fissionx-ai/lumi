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
        if(source.getWorkspaceId()!=null){
            workspace.setWorkspaceId(UUID.fromString(source.getWorkspaceId()));
            workspace.setCreatedAt(source.getCreatedAt());
        }else{
            workspace.setUpdatedAt(System.currentTimeMillis());
            workspace.setCreatedAt(System.currentTimeMillis());
        }
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

        return workspaceDto;
    }
}
