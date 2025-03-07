package com.fissionx.lumi.model.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class QuestionDto {
        private String questionId;
        private String typeId;
        private String question;
        private boolean required;
        private int minLength;
        private int maxLength;
        private List<Option> options;
        private Long createdAt;
        private Long updatedAt;

        @Data
        @JsonIgnoreProperties(ignoreUnknown = true)
        @AllArgsConstructor
        @NoArgsConstructor
        public static class Option{
            private Integer optionId;
            private String value;
        }
}
