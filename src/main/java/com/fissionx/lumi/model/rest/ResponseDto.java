package com.fissionx.lumi.model.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseDto {
    private String formId;
    private String responseId;
    private String userId;
    private String submittedAt;
    private List<QuestionResponse> responses;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class QuestionResponse {
        private String formId;
        private String questionId;
        private List<Answer> answer;
        private String responseId;

        @Data
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Answer {
            private String responseId;
            private String questionId;
            private String optionId;
            private String value;
            private Long numeric;
            private Double decimal;
        }
    }
}

