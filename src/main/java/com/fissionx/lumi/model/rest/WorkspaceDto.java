package com.fissionx.lumi.model.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkspaceDto {
    private String workspaceId;
    private String permission;
    private String title;
    private String workspaceName;
    private String description;
    private String userId;
    private StyleDto style;
    private List<String> formIds;
    private Long createdAt;
    private Long updatedAt;

}

