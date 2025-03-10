package com.fissionx.lumi.model.rest.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeleteWorkspaceResponse extends FormsControllerBaseResponse{
    private String workspaceName;
    private String workspaceId;
}
