package com.fissionx.lumi.service.impl;

import com.fissionx.form.store.entity.FieldOptions;
import com.fissionx.form.store.repository.FieldOptionRepository;
import com.fissionx.lumi.exceptions.DBUpsertException;
import com.fissionx.lumi.model.rest.OptionsDto;
import com.fissionx.lumi.service.OptionsService;
import com.fissionx.lumi.transformer.OptionsEntityTransformer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OptionsServiceImpl implements OptionsService {

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
    public List<OptionsDto> addOptions(List<OptionsDto> addOptionsDtos, String questionId) {
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
    public OptionsDto updateOptions(OptionsDto updateReq) {
        return null;
    }

    @Override
    public OptionsDto getOptionsId(String questionId) {
        return null;
    }

    @Override
    public List<OptionsDto> getOptionsByFormId(String formId) {
        return List.of();
    }
}
