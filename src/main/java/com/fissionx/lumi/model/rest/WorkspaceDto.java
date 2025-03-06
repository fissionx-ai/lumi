package com.fissionx.lumi.model.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkspaceDto {
    private String workspaceId;
    private String permission;
    private String workspaceName;
    private String description;
    private String userId;
    private StyleDto style;

}

