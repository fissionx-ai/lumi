package com.fissionx.lumi.model.rest.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SettingsRequest {
    private String visibility;
    private Boolean allowMultipleSubmissions;
    private SettingsRequest.ResponseDeadline responseDeadline;
    private Boolean shuffleQuestions;
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
