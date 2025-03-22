package com.fissionx.lumi.model.rest.response;

import com.fissionx.lumi.entity.DataTypes;
import lombok.Data;

import java.util.List;

@Data
public class DataTypesResponse {
    private List<DataTypes> dataTypes;
}
