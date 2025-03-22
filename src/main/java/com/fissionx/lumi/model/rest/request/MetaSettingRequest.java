package com.fissionx.lumi.model.rest.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MetaSettingRequest {
    private Boolean isActive;
    private Boolean isPremium;
    private String mapName;
    private String createdBy;
    private String dataType;
}
