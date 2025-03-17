package com.fissionx.lumi.service;

import com.fissionx.lumi.model.rest.ResponseDto;
import com.fissionx.lumi.model.rest.response.FormWithSubmissionData;

public interface ResponseService {
    FormWithSubmissionData getFormToFill(String formId, String userId);
    ResponseDto getResponseByFormAndUserId(String formId, String userId);
    FormWithSubmissionData formSubmission(FormWithSubmissionData formWithSubmissionData);
    Boolean deleteResponse(String responseId, String formId);
    Boolean isResponseExistByUserId(String userId, String formId);

}
