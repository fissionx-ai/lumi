package com.fissionx.lumi.service.impl;

import com.fissionx.form.store.entity.Form;
import com.fissionx.lumi.exceptions.DBUpsertException;
import com.fissionx.lumi.model.rest.FormDto;
import com.fissionx.lumi.model.rest.QuestionDto;
import com.fissionx.lumi.service.FormsService;
import com.fissionx.lumi.service.QuestionsService;
import com.fissionx.lumi.service.SettingsService;
import com.fissionx.lumi.service.StyleService;
import com.fissionx.lumi.transformer.FormsEntityTransformer;
import com.fissionx.form.store.repository.FormRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormServiceImpl implements FormsService {

    private final FormsEntityTransformer formsEntityTransformer;
    private final QuestionsService questionService;
    private final SettingsService settingsService;
    private final StyleService styleService;
    private final FormRepository formRepository;


    public FormServiceImpl(FormsEntityTransformer formsEntityTransformer, QuestionsService questionService, SettingsService settingsService, StyleService styleService, FormRepository formRepository) {
        this.formsEntityTransformer = formsEntityTransformer;
        this.questionService = questionService;
        this.settingsService = settingsService;
        this.styleService = styleService;
        this.formRepository = formRepository;
    }


    @Override
    public FormDto createForm(FormDto createReq) {
        FormDto response;
        try {
            Form formInputEntity=formsEntityTransformer.transformToForm(createReq);
            Form formDbData=formRepository.save(formInputEntity);
            List<QuestionDto> questionDtoList=questionService.addQuestions(createReq.getQuestions(),formDbData.getFormId());
            response=formsEntityTransformer.transformToFormDto(formDbData);
            response.setQuestions(questionDtoList);
            response.setSettings(settingsService.addSetting(createReq.getSettings(),formDbData.getFormId()));
            response.setStyle(styleService.addStyle(createReq.getStyle(),formDbData.getFormId()));
        }catch (Exception exception){
            throw new DBUpsertException(exception.getMessage());
        }
        return response;
    }

    @Override
    public FormDto updateForm(FormDto updateReq) {
        return null;
    }

    @Override
    public FormDto getFormById(String formId) {
        return null;
    }

    @Override
    public List<FormDto> getFormByUserId(String userId) {
        return List.of();
    }

    @Override
    public List<FormDto> getFormByWorkspaceId(String workspaceId) {
        return List.of();
    }

    @Override
    public List<FormDto> getRecentFormsByUserId(String userId) {
        return List.of();
    }

    @Override
    public List<FormDto> getFaviouresByUserId(String userId) {
        return List.of();
    }
}
