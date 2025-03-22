package com.fissionx.lumi.service.impl;

import com.fissionx.lumi.entity.FieldOptions;
import com.fissionx.lumi.entity.FieldResponse;
import com.fissionx.lumi.repository.FieldResponseRepository;
import com.fissionx.lumi.exceptions.NotFoundException;
import com.fissionx.lumi.model.rest.OptionsResponseDto;
import com.fissionx.lumi.model.rest.QuestionResponseDto;
import com.fissionx.lumi.service.OptionsResponseService;
import com.fissionx.lumi.transformer.FieldResponseEntityTransformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OptionsResponseServiceImpl implements OptionsResponseService {
    private static final Logger logger = LoggerFactory.getLogger(OptionsResponseServiceImpl.class);
    private final FieldResponseRepository fieldResponseRepository;
    private final FieldResponseEntityTransformer  responseEntityTransformer;

    public OptionsResponseServiceImpl(FieldResponseRepository fieldResponseRepository, FieldResponseEntityTransformer responseEntityTransformer) {
        this.fieldResponseRepository = fieldResponseRepository;
        this.responseEntityTransformer = responseEntityTransformer;
    }

    @Override
    public List<OptionsResponseDto> getOptionsResponseByQuestionId(String questionId) {
        List<FieldResponse> fieldResponse=fieldResponseRepository.findByFieldId(questionId);
        if(fieldResponse.isEmpty()) throw new NotFoundException("No options available for questionId: "+ questionId);
        return fieldResponse.stream().map(responseEntityTransformer::transformToFieldResponseDto).toList();
    }

    @Override
    public List<OptionsResponseDto> addOrUpdateOptionsResponse(List<OptionsResponseDto> optionsResponseDtoList, String responseId) {
        List<FieldResponse> fieldResponses= optionsResponseDtoList.stream().map(options->{
            options.setResponseId(responseId);
            return responseEntityTransformer.transformToFieldResponse(options);
        }).toList();
        List<FieldResponse> insertedOption=fieldResponseRepository.saveAll(fieldResponses);
        return insertedOption.stream().map(responseEntityTransformer::transformToFieldResponseDto).toList();
    }

    @Override
    public Boolean deleteOptionsResponseByQuestionId(String questionId) {
        List<FieldResponse> fieldResponse=fieldResponseRepository.findByFieldId(questionId);
        if(fieldResponse.isEmpty()) throw new NotFoundException("No options available for questionId: "+ questionId);
        fieldResponseRepository.deleteByFieldId(questionId);
        return true;
    }
}
