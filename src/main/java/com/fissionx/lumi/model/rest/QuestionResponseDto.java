package com.fissionx.lumi.model.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class QuestionResponseDto {
        private String formId;
        private String questionId;
        private String typeId;
        private String question; //enter your question
        private boolean required;
        private Integer minLength;
        private Long maxLength;
        private List<OptionsResponseDto> options;
        private Long createdAt;
        private Long updatedAt;
}
