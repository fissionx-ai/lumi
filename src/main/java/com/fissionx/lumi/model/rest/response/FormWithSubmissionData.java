package com.fissionx.lumi.model.rest.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fissionx.lumi.model.rest.QuestionResponseDto;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class FormWithSubmissionData {
    private String formId;
    private String userId;
    private long timestamp;
    private String createdBy;
    private String state;
    private String title;
    private String description;
    private List<QuestionResponseDto> questionWithAnswers;
    private String responseId;
    private Long submittedAt;
    private String submissionStatus;
    private Long createdAt;
    private Long updatedAt;
}
