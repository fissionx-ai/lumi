package com.fissionx.lumi.model.rest.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeleteFormResponse extends FormsControllerBaseResponse{
    private String formId;
    private String userId;
}
