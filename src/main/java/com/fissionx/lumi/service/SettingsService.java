package com.fissionx.lumi.service;

import com.fissionx.lumi.model.rest.SettingsDto;
import com.fissionx.lumi.model.rest.StyleDto;

public interface SettingsService {
    SettingsDto addOrUpdateSetting(SettingsDto createReq, String formId);
    SettingsDto getSettingByFormId(String formId);
    SettingsDto getSettingById(String settingId);
    Boolean deleteByFormId(String formId);

}
