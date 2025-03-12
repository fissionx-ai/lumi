package com.fissionx.lumi.model.rest.response;

import com.fissionx.lumi.model.rest.FormDto;
import lombok.Data;

import java.util.List;

@Data
public class FormsResponse {
    private List<FormDto> forms;
}
