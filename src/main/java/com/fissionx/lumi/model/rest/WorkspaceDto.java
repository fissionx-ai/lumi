package com.fissionx.lumi.model.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkspaceDto {
    private String workspaceId;
    private String permission;
    private String title;
    @NotNull(message = "workspace name is mandatory. Please provide name..")
    private String workspaceName;
    private String description;
    private String userId;
    private StyleDto style;
    private List<String> formIds;
    private Long createdAt;
    private Long updatedAt;

}

