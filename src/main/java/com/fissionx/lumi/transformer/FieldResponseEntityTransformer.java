package com.fissionx.lumi.transformer;

import com.fissionx.form.store.entity.FieldResponse;
import com.fissionx.form.store.transformers.FieldResponseTransformer;
import com.fissionx.lumi.model.rest.ResponseDto;
import org.springframework.stereotype.Component;

@Component
public class FieldResponseEntityTransformer implements FieldResponseTransformer<ResponseDto.QuestionResponse.Answer> {

    @Override
    public FieldResponse transformToFieldResponse(ResponseDto.QuestionResponse.Answer source) {
        FieldResponse fieldResponse=new FieldResponse();
        fieldResponse.setResponseId(source.getResponseId());
        fieldResponse.setFieldId(source.getQuestionId());
        fieldResponse.setResponseText(source.getValue());
        fieldResponse.setFieldOptionId(source.getOptionId());
        fieldResponse.setCreatedAt(System.currentTimeMillis());
        fieldResponse.setUpdatedAt(System.currentTimeMillis());
        fieldResponse.setResponseDecimal(source.getDecimal());
        fieldResponse.setResponseNumeric(source.getNumeric());
        return fieldResponse;
    }

    @Override
    public ResponseDto.QuestionResponse.Answer transformToFieldResponseDto(FieldResponse source) {
        ResponseDto.QuestionResponse.Answer answer=new ResponseDto.QuestionResponse.Answer();
        answer.setResponseId(source.getResponseId());
        answer.setQuestionId(source.getFieldId());
        answer.setValue(source.getResponseText());
        answer.setOptionId(source.getFieldOptionId());
        answer.setDecimal(source.getResponseDecimal());
        answer.setNumeric(source.getResponseNumeric());

        return answer;
    }
}
