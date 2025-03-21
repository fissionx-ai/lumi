package com.fissionx.lumi.model.rest.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class FormCreateRequest {
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
    private List<QuestionRequest> questions;
    private String workspaceId;
    private Boolean isFavourites;
    private SettingsRequest settings;
    private StyleRequest style;
    private Long createdAt;
    private Long updatedAt;
}
