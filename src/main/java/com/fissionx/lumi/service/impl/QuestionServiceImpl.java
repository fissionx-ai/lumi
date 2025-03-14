package com.fissionx.lumi.service.impl;

import com.fissionx.form.store.entity.Field;
import com.fissionx.form.store.repository.FieldRepository;
import com.fissionx.lumi.exceptions.DBUpsertException;
import com.fissionx.lumi.model.rest.OptionsDto;
import com.fissionx.lumi.model.rest.QuestionDto;
import com.fissionx.lumi.service.OptionsService;
import com.fissionx.lumi.service.QuestionsService;
import com.fissionx.lumi.transformer.QuestionsEntityTransformer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionsService {
    private final FieldRepository fieldRepository;
    private final OptionsService optionsService;
    private final QuestionsEntityTransformer questionsEntityTransformer;

    public QuestionServiceImpl(FieldRepository fieldRepository, OptionsService optionsService, QuestionsEntityTransformer questionsEntityTransformer) {
        this.fieldRepository = fieldRepository;
        this.optionsService = optionsService;
        this.questionsEntityTransformer = questionsEntityTransformer;
    }


    @Override
    public List<QuestionDto> addQuestions(List<QuestionDto> createReq, String formId) {
        List<QuestionDto> responseList;
        try {
             responseList=createReq.stream().map(question-> {
                question.setFormId(formId);
                Field field=questionsEntityTransformer.transformToFields(question);
                Field fieldFromDb=fieldRepository.save(field);
                List<OptionsDto> optionsDtos= optionsService.addOptions(question.getOptions(),fieldFromDb.getFieldId());
                QuestionDto questionDto=questionsEntityTransformer.transformToFieldsDto(fieldFromDb);
                questionDto.setOptions(optionsDtos);
                return questionDto;
             }).toList();
        }catch (Exception exception){
            throw new DBUpsertException(exception.getMessage());
        }
        return responseList;
    }

    @Override
    public QuestionDto updateQuestion(QuestionDto updateReq) {
        return null;
    }

    @Override
    public QuestionDto getQuestionId(String questionId) {
        return null;
    }

    @Override
    public List<QuestionDto> getQuestionByFormId(String formId) {
        return List.of();
    }
}
