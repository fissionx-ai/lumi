package com.fissionx.lumi.model.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class OptionsResponseDto extends OptionsDto {
    private String questionResponseId;
    private String responseId;
    private String responseValue; // for input types
    private Boolean isSelected; // for mcq's
}
