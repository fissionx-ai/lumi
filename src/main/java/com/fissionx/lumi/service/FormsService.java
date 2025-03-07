package com.fissionx.lumi.service;

import com.fissionx.lumi.model.rest.FormDto;

import java.util.List;

public interface FormsService {
    FormDto createForm(FormDto createReq);
    FormDto updateForm(FormDto updateReq);
    FormDto getFormById(String formId);
    List<FormDto> getFormByUserId(String userId);
    List<FormDto> getFormByWorkspaceId(String workspaceId);
    List<FormDto> getRecentFormsByUserId(String userId);
    List<FormDto> getFaviouresByUserId(String userId);
}
