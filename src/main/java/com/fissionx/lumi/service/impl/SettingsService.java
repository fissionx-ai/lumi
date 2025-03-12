package com.fissionx.lumi.service.impl;

import com.fissionx.form.store.entity.FormSettings;
import com.fissionx.form.store.repository.FormSettingsRepository;
import com.fissionx.lumi.model.rest.SettingsDto;
import com.fissionx.lumi.service.FormsService;
import com.fissionx.lumi.transformer.SettingsEntityTransformer;
import org.springframework.stereotype.Service;

@Service
public class SettingsService implements com.fissionx.lumi.service.SettingsService {
    private final FormSettingsRepository formSettingsRepository;
    private final SettingsEntityTransformer settingsEntityTransformer;

    public SettingsService(FormSettingsRepository formSettingsRepository, SettingsEntityTransformer settingsEntityTransformer) {
        this.formSettingsRepository = formSettingsRepository;
        this.settingsEntityTransformer = settingsEntityTransformer;
    }

    @Override
    public SettingsDto addSetting(SettingsDto createReq,String formId) {
        createReq.setFormId(formId);
        FormSettings formsSetting=settingsEntityTransformer.transformToSettings(createReq);
        FormSettings settingFromDB=formSettingsRepository.save(formsSetting);
        return settingsEntityTransformer.transformToSettingsDto(settingFromDB);
    }

    @Override
    public SettingsDto updateSetting(SettingsDto updateReq,String formId) {
        return null;
    }

    @Override
    public SettingsDto getSettingByFormId(String formId) {
        return null;
    }

    @Override
    public SettingsDto getSettingById(String settingId) {
        return null;
    }
}
