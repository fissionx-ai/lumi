package com.fissionx.lumi.model.rest.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MetaDataTypesRequest {
    private String name;
    private String description;
    private Boolean isActive;
    private Long minLength;
    private Long maxLimit;
    private Boolean isPremium;
    private String createdBy;
    private List<String> groups;
    private Integer rank;
    private String tenantId;
}
