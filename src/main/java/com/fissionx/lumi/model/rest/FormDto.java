package com.fissionx.lumi.model.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class FormDto {
    private String userId;
    private long timestamp;
    private String createdBy;
    private String state;
    private boolean isPublished;
    private String title;
    private String description;
    private List<QuestionDto> questions;
    private SettingsDto settings;
    private StyleDto style;
}
