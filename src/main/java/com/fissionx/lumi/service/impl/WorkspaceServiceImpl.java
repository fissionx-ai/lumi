package com.fissionx.lumi.service.impl;

import com.fissionx.form.store.entity.Workspace;
import com.fissionx.form.store.repository.WorkspaceRepository;
import com.fissionx.lumi.exceptions.DBUpsertException;
import com.fissionx.lumi.model.rest.WorkspaceDto;
import com.fissionx.lumi.model.rest.response.DeleteWorkspaceResponse;
import com.fissionx.lumi.service.WorkspaceService;
import com.fissionx.lumi.transformer.WorkspaceEntityTransformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkspaceServiceImpl implements WorkspaceService {
    private static final Logger logger = LoggerFactory.getLogger(WorkspaceServiceImpl.class);
    private final WorkspaceEntityTransformer workspaceEntityTransformer;
    private final WorkspaceRepository workspaceRepository;

    public WorkspaceServiceImpl(WorkspaceEntityTransformer workspaceEntityTransformer, WorkspaceRepository workspaceRepository) {
        this.workspaceEntityTransformer = workspaceEntityTransformer;
        this.workspaceRepository = workspaceRepository;
    }

    @Override
    public WorkspaceDto createWorkspace(WorkspaceDto createRequest) {
        try {
            Workspace workspace=workspaceEntityTransformer.transformToWorkspace(createRequest);
            Workspace workspaceInDb=workspaceRepository.save(workspace);
            return workspaceEntityTransformer.transformToWorkspace(workspaceInDb);
        }catch (Exception exception){
            throw new DBUpsertException(exception.getMessage());
        }
    }

    @Override
    public WorkspaceDto updateWorkSpace(WorkspaceDto updateRequest) {
        return null;
    }

    @Override
    public WorkspaceDto getWorkspaceById(String workspaceId) {
        try {
            if(workspaceRepository.existsById(workspaceId)){
                Workspace workspace=workspaceRepository.findById(workspaceId).get();
                return workspaceEntityTransformer.transformToWorkspace(workspace);
            }
        }catch (Exception exception){
            throw new DBUpsertException(exception.getMessage());
        }
        return null;
    }

    @Override
    public List<WorkspaceDto> getWorkspaceByUserId(String userId) {
        return List.of();
    }

    @Override
    public DeleteWorkspaceResponse deleteWorkspaceById(String workspaceId) {
        try {
            workspaceRepository.deleteById(workspaceId);
            DeleteWorkspaceResponse deleteWorkspaceResponse=new DeleteWorkspaceResponse();
            deleteWorkspaceResponse.setWorkspaceId(workspaceId);
            return deleteWorkspaceResponse;
        }catch (Exception exception){
            throw new DBUpsertException(exception.getMessage());
        }
    }
}
