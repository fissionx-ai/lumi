package com.fissionx.lumi.model.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SettingsDto {
    private String visibility;
    private boolean allowMultipleSubmissions;
    private ResponseDeadline responseDeadline;
    private boolean shuffleQuestions;
    private String thankYouMessage;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ResponseDeadline {
        private String startTime;
        private String endTime;
    }
}