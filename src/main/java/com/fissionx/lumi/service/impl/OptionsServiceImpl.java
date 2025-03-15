package com.fissionx.lumi.service.impl;

import com.fissionx.form.store.entity.FieldOptions;
import com.fissionx.form.store.repository.FieldOptionRepository;
import com.fissionx.lumi.exceptions.DBUpsertException;
import com.fissionx.lumi.exceptions.NotFoundException;
import com.fissionx.lumi.model.rest.OptionsDto;
import com.fissionx.lumi.service.OptionsService;
import com.fissionx.lumi.transformer.OptionsEntityTransformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OptionsServiceImpl implements OptionsService {
    private static final Logger logger = LoggerFactory.getLogger(OptionsServiceImpl.class);

    private final FieldOptionRepository fieldOptionRepository;
    private final OptionsEntityTransformer optionsEntityTransformer;

    public OptionsServiceImpl(FieldOptionRepository fieldOptionRepository, OptionsEntityTransformer optionsEntityTransformer) {
        this.fieldOptionRepository = fieldOptionRepository;
        this.optionsEntityTransformer = optionsEntityTransformer;
    }

    @Override
    public OptionsDto addOption(OptionsDto createReq, String questionId) {
        OptionsDto response=new OptionsDto();
        try {
            FieldOptions fieldOptions=optionsEntityTransformer.transformToOptions(createReq);
            FieldOptions insertedOption=fieldOptionRepository.save(fieldOptions);
            response=optionsEntityTransformer.transformToOptionsDto(insertedOption);
        }catch (Exception exception){
            throw new DBUpsertException(exception.getMessage());
        }

        return response;
    }

    @Override
    public List<OptionsDto> addOrUpdateOptions(List<OptionsDto> addOptionsDtos, String questionId) {
        List<OptionsDto> responseList=new ArrayList<>();
        try {
            List<FieldOptions> optionDtoList= addOptionsDtos.stream().map(createOptions->{
                        createOptions.setQuestionId(questionId);
                return optionsEntityTransformer.transformToOptions(createOptions);
                    })
                    .toList();
            List<FieldOptions> insertedOption=fieldOptionRepository.saveAll(optionDtoList);
            responseList=insertedOption.stream().map(optionsEntityTransformer::transformToOptionsDto).toList();
        }catch (Exception exception){
            throw new DBUpsertException(exception.getMessage());
        }

        return responseList;

    }

    @Override
    public List<OptionsDto> getOptionsByQuestionId(String questionId) {
        try{
            List<FieldOptions> options=fieldOptionRepository.findByFieldId(questionId);
            if(options.isEmpty()){
                logger.error("There is no options found for questionId: "+questionId);
                throw new NotFoundException("There is no options found for questionId: "+questionId);
            }
            return options.stream().map( optionsEntityTransformer::transformToOptionsDto).toList();
        }catch (Exception exception){
            throw new DBUpsertException(exception.getMessage());
        }
    }

    @Override
    public Boolean deleteOptions(String questionId) {
        try {
            fieldOptionRepository.deleteByFieldId(questionId);
            return true;

        }catch (Exception exception){
            throw new DBUpsertException(exception.getMessage());
        }
    }

}
