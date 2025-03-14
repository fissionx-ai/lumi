package com.fissionx.lumi.model.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class QuestionDto {
        private String formId;
        private String questionId;
        private String typeId;
        @NotNull(message = "question is mandatory. please provide question")
        @NotEmpty
        private String question; //enter your question
        private boolean required;
        private Integer minLength;
        private Long maxLength;
        private List<OptionsDto> options;
        private Long createdAt;
        private Long updatedAt;
}
