package com.fissionx.lumi.model.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseDto {
    private String responseId;
    private String userId;
    private String submittedAt;
    private List<QuestionResponse> responses;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class QuestionResponse {
        private String questionId;
        private List<Answer> answer;

        @Data
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Answer {
            private String optionId;
            private String value;
        }
    }
}

