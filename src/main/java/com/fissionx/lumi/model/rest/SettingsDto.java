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
    private String formId;
    private String visibility;
    private boolean allowMultipleSubmissions;
    private ResponseDeadline responseDeadline;
    private boolean shuffleQuestions;
    private String thankYouMessage;
    private Boolean isPublic;
    private Long maxResponseThreshold;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ResponseDeadline {
        private Long startTime;
        private Long endTime;
    }
}