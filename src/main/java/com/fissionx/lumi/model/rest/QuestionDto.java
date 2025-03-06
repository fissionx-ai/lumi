package com.fissionx.lumi.model.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class QuestionDto {
        private String type;
        private String question;
        private boolean required;
        private int minLength;
        private int maxLength;
        private List<Option> options;

        @Data
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Option{
            private Integer optionId;
            private String value;
        }
}
