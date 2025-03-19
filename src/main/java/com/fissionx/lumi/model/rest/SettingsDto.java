package com.fissionx.lumi.model.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
public class SettingsDto {
    private String settingsId;
    private String formId;
    private String visibility;
    private Boolean allowMultipleSubmissions;
    private ResponseDeadline responseDeadline;
    private Boolean shuffleQuestions;
    private String thankYouMessage;
    private Boolean isPublic;
    private Long maxResponseThreshold;
    private Long createdAt;
    private Long updatedAt;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ResponseDeadline {
        private Long startTime;
        private Long endTime;
    }
}