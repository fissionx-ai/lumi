package com.fissionx.lumi.service.impl;

import com.fissionx.form.store.entity.Form;
import com.fissionx.form.store.entity.FormSettings;
import com.fissionx.form.store.repository.FormSettingsRepository;
import com.fissionx.lumi.exceptions.DBUpsertException;
import com.fissionx.lumi.exceptions.NotFoundException;
import com.fissionx.lumi.model.rest.SettingsDto;
import com.fissionx.lumi.transformer.SettingsEntityTransformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SettingsServiceImpl implements com.fissionx.lumi.service.SettingsService {
    private static final Logger logger = LoggerFactory.getLogger(SettingsServiceImpl.class);

    private final FormSettingsRepository formSettingsRepository;
    private final SettingsEntityTransformer settingsEntityTransformer;

    public SettingsServiceImpl(FormSettingsRepository formSettingsRepository, SettingsEntityTransformer settingsEntityTransformer) {
        this.formSettingsRepository = formSettingsRepository;
        this.settingsEntityTransformer = settingsEntityTransformer;
    }

    @Override
    public SettingsDto addOrUpdateSetting(SettingsDto createReq,String formId) {
        createReq.setFormId(formId);
        FormSettings formsSetting=settingsEntityTransformer.transformToSettings(createReq);
        FormSettings settingFromDB=formSettingsRepository.save(formsSetting);
        return settingsEntityTransformer.transformToSettingsDto(settingFromDB);
    }

    @Override
    public SettingsDto getSettingByFormId(String formId) {
        try{
            List<FormSettings> formSettings=formSettingsRepository.findByFormId(formId);
            if(formSettings.isEmpty()){
                logger.error("There is no settings found for formId: "+formId);
                throw new NotFoundException("There is no settings found for workspaceId: "+formId);
            }
            return formSettings.stream().map( settingsEntityTransformer::transformToSettingsDto).toList().getFirst();
        }catch (Exception exception){
            throw new DBUpsertException(exception.getMessage());
        }
    }

    @Override
    public SettingsDto getSettingById(String settingId) {
        return null;
    }

    @Override
    public Boolean deleteByFormId(String formId) {
        try {
            formSettingsRepository.deleteByFormId(formId);
        }catch (Exception exception){
            throw new DBUpsertException(exception.getMessage());
        }
        return true;
    }
}
