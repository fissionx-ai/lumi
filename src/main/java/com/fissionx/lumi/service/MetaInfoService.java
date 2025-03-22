package com.fissionx.lumi.service;

import com.fissionx.lumi.entity.DataTypes;
import com.fissionx.lumi.entity.SettingsMeta;

import java.util.List;

public interface MetaInfoService {
    List<DataTypes> getDataTypes();
    List<DataTypes> addDataTypes(List<DataTypes> dataTypesList);
    List<SettingsMeta> getSettingsMetaInfo();
    List<SettingsMeta> addSettingsInfo(List<SettingsMeta> settingsMeta);
}
