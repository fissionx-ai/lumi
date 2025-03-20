package com.fissionx.lumi.service;

import com.fissionx.lumi.model.rest.FormDto;
import com.fissionx.lumi.model.rest.response.DeleteFormResponse;
import com.fissionx.lumi.model.rest.response.FormsResponse;

import java.util.List;

public interface FormsService {
    FormDto createOrUpdateForm(FormDto createReq);
    FormDto getFormById(String formId);
    List<FormDto> getFormByUserId(String userId);
    List<FormDto> getFormByWorkspaceId(String workspaceId);
    List<FormDto> getRecentFormsByUserId(String userId);
    List<FormDto> getFaviouresByUserId(String userId);
    Boolean deleteFormById(String userId);
}
