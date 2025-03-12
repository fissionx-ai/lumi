package com.fissionx.lumi.transformer;

import com.fissionx.form.store.entity.FormSettings;
import com.fissionx.form.store.transformers.SettingsTransformer;
import com.fissionx.lumi.model.rest.SettingsDto;
import org.springframework.stereotype.Component;

@Component
public class SettingsEntityTransformer implements SettingsTransformer<SettingsDto> {

    @Override
    public FormSettings transformToSettings(SettingsDto source) {
        FormSettings formSettings=new FormSettings();
        formSettings.setFormId(source.getFormId());
        formSettings.setAllowPublic(source.getIsPublic());
        if(source.getResponseDeadline()!=null){
            formSettings.setActivationStartTime(source.getResponseDeadline().getStartTime());
            formSettings.setExpiryTime(source.getResponseDeadline().getEndTime());
        }
        formSettings.setIsFavourites(source.getIsFavourites());
        formSettings.setMaxResponseThreshold(source.getMaxResponseThreshold());
        formSettings.setShuffleQuestions(source.isShuffleQuestions());
        formSettings.setCreatedAt(System.currentTimeMillis());
        formSettings.setUpdatedAt(System.currentTimeMillis());
        return formSettings;
    }

    @Override
    public SettingsDto transformToSettingsDto(FormSettings source) {
        SettingsDto settingsDto=new SettingsDto();
        settingsDto.setFormId(source.getFormId());
        settingsDto.setIsPublic(source.getAllowPublic());
        settingsDto.setIsFavourites(source.getIsFavourites());
        SettingsDto.ResponseDeadline responseDeadline=new SettingsDto.ResponseDeadline(source.getActivationStartTime(),source.getExpiryTime());
        settingsDto.setResponseDeadline(responseDeadline);
        settingsDto.setAllowMultipleSubmissions(true);
        settingsDto.setShuffleQuestions(source.isShuffleQuestions());
        settingsDto.setMaxResponseThreshold(source.getMaxResponseThreshold());
        settingsDto.setThankYouMessage("source.get");
        return settingsDto;
    }
}
