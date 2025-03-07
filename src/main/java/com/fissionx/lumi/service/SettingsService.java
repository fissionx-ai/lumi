package com.fissionx.lumi.service;

import com.fissionx.lumi.model.rest.SettingsDto;
import com.fissionx.lumi.model.rest.StyleDto;

public interface SettingsService {
    SettingsDto addSetting(SettingsDto createReq);
    SettingsDto updateSetting(SettingsDto updateReq);
    SettingsDto getSettingByFormId(String formId);
    SettingsDto getSettingById(String settingId);
}
