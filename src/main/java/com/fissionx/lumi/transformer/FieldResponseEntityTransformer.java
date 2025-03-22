package com.fissionx.lumi.transformer;

import com.fissionx.lumi.entity.FieldResponse;
import com.fissionx.lumi.transformers.FieldResponseTransformer;
import com.fissionx.lumi.model.rest.OptionsResponseDto;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class FieldResponseEntityTransformer implements FieldResponseTransformer<OptionsResponseDto> {

    @Override
    public FieldResponse transformToFieldResponse(OptionsResponseDto source) {
        FieldResponse fieldResponse=new FieldResponse();
        fieldResponse.setResponseId(source.getResponseId());
        fieldResponse.setFieldId(source.getQuestionId());
        fieldResponse.setResponseValue(source.getResponseValue());
        fieldResponse.setIsSelected(source.getIsSelected());
        if(source.getQuestionResponseId()!=null){
            fieldResponse.setFieldResponseId(UUID.fromString(source.getQuestionResponseId()));
            fieldResponse.setCreatedAt(source.getCreatedAt());
        }
        fieldResponse.setFieldOptionId(source.getOptionId());
        fieldResponse.setCreatedAt(System.currentTimeMillis());
        fieldResponse.setUpdatedAt(System.currentTimeMillis());
        return fieldResponse;
    }

    @Override
    public OptionsResponseDto transformToFieldResponseDto(FieldResponse source) {
        OptionsResponseDto answer=new OptionsResponseDto();
        answer.setResponseId(source.getResponseId());
        answer.setQuestionId(source.getFieldId());
        answer.setResponseValue(source.getResponseValue());
        answer.setOptionId(source.getFieldOptionId());
        answer.setIsSelected(source.getIsSelected());
        answer.setQuestionResponseId(source.getFieldResponseId().toString());
        return answer;
    }
}
