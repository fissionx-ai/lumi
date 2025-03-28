package com.fissionx.lumi.service.impl;

import com.fissionx.lumi.entity.Field;
import com.fissionx.lumi.entity.FieldOptions;
import com.fissionx.lumi.repository.FieldRepository;
import com.fissionx.lumi.exceptions.DBUpsertException;
import com.fissionx.lumi.exceptions.NotFoundException;
import com.fissionx.lumi.model.rest.OptionsDto;
import com.fissionx.lumi.model.rest.QuestionDto;
import com.fissionx.lumi.service.OptionsService;
import com.fissionx.lumi.service.QuestionsService;
import com.fissionx.lumi.transformer.QuestionsEntityTransformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class QuestionServiceImpl implements QuestionsService {
    private static final Logger logger = LoggerFactory.getLogger(QuestionServiceImpl.class);

    private final FieldRepository fieldRepository;
    private final OptionsService optionsService;
    private final QuestionsEntityTransformer questionsEntityTransformer;

    public QuestionServiceImpl(FieldRepository fieldRepository, OptionsService optionsService, QuestionsEntityTransformer questionsEntityTransformer) {
        this.fieldRepository = fieldRepository;
        this.optionsService = optionsService;
        this.questionsEntityTransformer = questionsEntityTransformer;
    }


    @Override
    public List<QuestionDto> addOrUpdateQuestions(List<QuestionDto> createReq, String formId) {
        List<QuestionDto> responseList;
        try {
             responseList=createReq.stream().map(question-> {
                question.setFormId(formId);
                Field field=questionsEntityTransformer.transformToFields(question);
                Field fieldFromDb=fieldRepository.save(field);
                List<OptionsDto> optionsDtos= optionsService.addOrUpdateOptions(question.getOptions(),fieldFromDb.getFieldId().toString());
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
    public QuestionDto getQuestionId(String questionId) {
        return null;
    }

    @Override
    public List<QuestionDto> getQuestionByFormId(String formId) {
        try{
            List<Field> questions=fieldRepository.findByFormId(formId);
            if(questions.isEmpty()){
                logger.error("There is no questions found for formId: "+formId);
                throw new NotFoundException("There is no questions found for questionId: "+formId);
            }

            return questions.stream().map(questionEnt-> {
                QuestionDto questionDto=questionsEntityTransformer.transformToFieldsDto(questionEnt);
                questionDto.setOptions(optionsService.getOptionsByQuestionId(questionEnt.getFieldId().toString()));
                return questionDto;
            }).toList();
        }catch (Exception exception){
            throw new DBUpsertException(exception.getMessage());
        }
    }

    @Override
    public Boolean deleteByFormId(String formId) {
        try {
            List<QuestionDto> questionDtoList=getQuestionByFormId(formId);
            questionDtoList.stream().forEach(question-> {
               boolean result= optionsService.deleteOptions(question.getQuestionId());
                if(result){
                    fieldRepository.deleteById(UUID.fromString(question.getQuestionId()));
                }
            });
            return true;
        }catch (Exception exception){
            throw new DBUpsertException(exception.getMessage());
        }
    }
}
