package com.fissionx.lumi.transformer;

import com.fissionx.lumi.entity.FormSettings;
import com.fissionx.lumi.transformers.SettingsTransformer;
import com.fissionx.lumi.model.rest.SettingsDto;
import org.springframework.stereotype.Component;

import java.util.UUID;

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
        formSettings.setMaxResponseThreshold(source.getMaxResponseThreshold());
        formSettings.setShuffleQuestions(source.getShuffleQuestions());
        if(source.getSettingsId()!=null){
            formSettings.setSettingId(UUID.fromString(source.getSettingsId()));
            formSettings.setCreatedAt(source.getCreatedAt());
        }else{
            formSettings.setCreatedAt(System.currentTimeMillis());
        }
        formSettings.setUpdatedAt(System.currentTimeMillis());

        return formSettings;
    }

    @Override
    public SettingsDto transformToSettingsDto(FormSettings source) {
        SettingsDto settingsDto=new SettingsDto();
        settingsDto.setSettingsId(source.getSettingId().toString());
        settingsDto.setFormId(source.getFormId());
        settingsDto.setIsPublic(source.getAllowPublic());
        SettingsDto.ResponseDeadline responseDeadline=new SettingsDto.ResponseDeadline(source.getActivationStartTime(),source.getExpiryTime());
        settingsDto.setResponseDeadline(responseDeadline);
        settingsDto.setAllowMultipleSubmissions(source.getAllowMultipleResponse());
        settingsDto.setShuffleQuestions(source.getShuffleQuestions());
        settingsDto.setMaxResponseThreshold(source.getMaxResponseThreshold());
        settingsDto.setThankYouMessage(source.getThankYouMessage());
        return settingsDto;
    }
}
