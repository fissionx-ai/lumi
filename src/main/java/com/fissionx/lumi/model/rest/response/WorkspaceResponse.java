package com.fissionx.lumi.model.rest.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fissionx.lumi.model.rest.FormDto;
import com.fissionx.lumi.model.rest.WorkspaceDto;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkspaceResponse {
    private List<WorkspaceDto> workspaces;
}
