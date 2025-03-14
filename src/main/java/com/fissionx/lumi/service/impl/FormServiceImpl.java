package com.fissionx.lumi.service.impl;

import com.fissionx.form.store.entity.Field;
import com.fissionx.form.store.entity.Form;
import com.fissionx.lumi.exceptions.DBUpsertException;
import com.fissionx.lumi.exceptions.NotFoundException;
import com.fissionx.lumi.model.rest.FormDto;
import com.fissionx.lumi.model.rest.QuestionDto;
import com.fissionx.lumi.service.FormsService;
import com.fissionx.lumi.service.QuestionsService;
import com.fissionx.lumi.service.SettingsService;
import com.fissionx.lumi.service.StyleService;
import com.fissionx.lumi.transformer.FormsEntityTransformer;
import com.fissionx.form.store.repository.FormRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FormServiceImpl implements FormsService {
    private static final Logger logger = LoggerFactory.getLogger(FormServiceImpl.class);

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
        try {
            Form form=formRepository.findById(formId).orElse(null);
            if(form==null){
                logger.error("There is no form found for formId: "+formId);
                throw new NotFoundException("There is no form found for formId: "+formId);
            }
            FormDto formDto=formsEntityTransformer.transformToFormDto(form);
            formDto.setStyle(styleService.getStyleByFormId(formId));
            formDto.setSettings(settingsService.getSettingByFormId(formId));
            formDto.setQuestions(questionService.getQuestionByFormId(formId));
            return formDto;
        }catch (Exception exception){
            throw new DBUpsertException(exception.getMessage());
        }
    }

    @Override
    public List<FormDto> getFormByUserId(String userId) {
        try{
            List<Form> forms=formRepository.findByUserId(userId);
            if(forms.isEmpty()){
                logger.error("There is no forms found for userId: "+userId);
                throw new NotFoundException("There is no questions found for questionId: "+userId);
            }
            return forms.stream().map( formsEntityTransformer::transformToFormDto).toList();
        }catch (Exception exception){
            throw new DBUpsertException(exception.getMessage());
        }
    }

    @Override
    public List<FormDto> getFormByWorkspaceId(String workspaceId) {
        try{
            List<Form> forms=formRepository.findByWorkspaceId(workspaceId);
            if(forms.isEmpty()){
                logger.error("There is no workspaceId found for workspaceId: "+workspaceId);
                throw new NotFoundException("There is no workspaceId found for workspaceId: "+workspaceId);
            }
            return forms.stream().map( formsEntityTransformer::transformToFormDto).toList();
        }catch (Exception exception){
            throw new DBUpsertException(exception.getMessage());
        }
    }

    @Override
    public List<FormDto> getRecentFormsByUserId(String userId) {
        try{
            List<FormDto> forms=getFormByUserId(userId);
            return forms.stream()
                    .sorted(Comparator.comparing(FormDto::getUpdatedAt).reversed())
                    .collect(Collectors.toList());
        }catch (Exception exception){
            throw new DBUpsertException(exception.getMessage());
        }
    }

    @Override
    public List<FormDto> getFaviouresByUserId(String userId) {
        try{
            List<FormDto> forms=getFormByUserId(userId);
            return forms.stream().filter(FormDto::getIsFavourites).collect(Collectors.toList());
        }catch (Exception exception){
            throw new DBUpsertException(exception.getMessage());
        }
    }
}
