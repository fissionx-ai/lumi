package com.fissionx.lumi.service.impl;

import com.fissionx.lumi.entity.Workspace;
import com.fissionx.lumi.repository.WorkspaceRepository;
import com.fissionx.lumi.exceptions.DBUpsertException;
import com.fissionx.lumi.exceptions.NotFoundException;
import com.fissionx.lumi.model.rest.WorkspaceDto;
import com.fissionx.lumi.model.rest.response.DeleteWorkspaceResponse;
import com.fissionx.lumi.service.WorkspaceService;
import com.fissionx.lumi.transformer.WorkspaceEntityTransformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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
    public WorkspaceDto createOrUpdateWorkspace(WorkspaceDto createRequest) {
        try {
            Workspace workspace=workspaceEntityTransformer.transformToWorkspace(createRequest);
            Workspace workspaceInDb=workspaceRepository.save(workspace);
            return workspaceEntityTransformer.transformToWorkspace(workspaceInDb);
        }catch (Exception exception){
            throw new DBUpsertException(exception.getMessage());
        }
    }

    @Override
    public WorkspaceDto getWorkspaceById(String workspaceId) {
        try {
            if(workspaceRepository.existsById(UUID.fromString(workspaceId))){
                Workspace workspace=workspaceRepository.findById(UUID.fromString(workspaceId)).get();
                return workspaceEntityTransformer.transformToWorkspace(workspace);
            }
        }catch (Exception exception){
            throw new DBUpsertException(exception.getMessage());
        }
        return null;
    }

    @Override
    public List<WorkspaceDto> getWorkspaceByUserId(String userId) {
        try {
            List<Workspace> workspaces=workspaceRepository.findByUserId(userId);
            if(workspaces.isEmpty()){
                logger.error("There is no workspace found for user id: "+userId);
                throw new NotFoundException("There is no workspace found for user id: "+userId);
            }
            return workspaces.stream().map(workspaceEntityTransformer::transformToWorkspace).toList();
        }catch (Exception exception){
            throw new DBUpsertException(exception.getMessage());
        }
    }

    @Override
    public DeleteWorkspaceResponse deleteWorkspaceById(String workspaceId) {
        try {
            workspaceRepository.deleteById(UUID.fromString(workspaceId));
            DeleteWorkspaceResponse deleteWorkspaceResponse=new DeleteWorkspaceResponse();
            deleteWorkspaceResponse.setWorkspaceId(workspaceId);
            deleteWorkspaceResponse.setIsDeleted(true);
            return deleteWorkspaceResponse;
        }catch (Exception exception){
            throw new DBUpsertException(exception.getMessage());
        }
    }

    @Override
    public WorkspaceDto addFormToWorkspace(String formId) {
        return null;
    }
}
