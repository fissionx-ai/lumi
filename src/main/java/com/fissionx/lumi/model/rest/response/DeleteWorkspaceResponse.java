package com.fissionx.lumi.model.rest.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
public class DeleteWorkspaceResponse{
    private String workspaceId;
    private String userId;
    private Boolean isDeleted;
}
