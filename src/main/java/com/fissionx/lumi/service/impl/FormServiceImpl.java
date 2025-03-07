package com.fissionx.lumi.service.impl;

import com.fissionx.lumi.model.rest.FormDto;
import com.fissionx.lumi.service.FormsService;

import java.util.List;

public class FormServiceImpl implements FormsService {
    @Override
    public FormDto createForm(FormDto createReq) {
        return null;
    }

    @Override
    public FormDto updateForm(FormDto updateReq) {
        return null;
    }

    @Override
    public FormDto getFormById(String formId) {
        return null;
    }

    @Override
    public List<FormDto> getFormByUserId(String userId) {
        return List.of();
    }

    @Override
    public List<FormDto> getFormByWorkspaceId(String workspaceId) {
        return List.of();
    }

    @Override
    public List<FormDto> getRecentFormsByUserId(String userId) {
        return List.of();
    }

    @Override
    public List<FormDto> getFaviouresByUserId(String userId) {
        return List.of();
    }
}
