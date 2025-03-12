package com.fissionx.lumi.model.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class FormDto {
    private String formId;
    @NotNull(message = "UserId mandatory. please provide userId")
    @NotEmpty
    private String userId;
    private long timestamp;
    private String createdBy;
    private String state;
    private boolean isPublished;
    @NotNull(message = "forms title is mandatory. please provide title")
    @NotEmpty
    private String title;
    private String description;
    private List<QuestionDto> questions;
    private SettingsDto settings;
    private StyleDto style;
    private Long createdAt;
    private Long updatedAt;
}
