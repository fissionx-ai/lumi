package com.fissionx.lumi.model.rest.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkspaceCreateRequest {
    private String permission;
    private String title;
    @NotNull(message = "workspace name is mandatory. Please provide name..")
    private String workspaceName;
    private String description;
    private String userId;
    private StyleRequest style;
    private List<String> formIds;
}
