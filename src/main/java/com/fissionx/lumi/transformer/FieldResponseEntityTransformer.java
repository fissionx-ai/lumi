package com.fissionx.lumi.transformer;

import com.fissionx.form.store.entity.FieldResponse;
import com.fissionx.form.store.entity.Form;
import com.fissionx.form.store.transformers.FieldResponseTransformer;
import com.fissionx.form.store.transformers.FormTransformer;
import com.fissionx.lumi.model.rest.FormDto;
import com.fissionx.lumi.model.rest.ResponseDto;

public class FieldResponseEntityTransformer implements FieldResponseTransformer<ResponseDto.QuestionResponse> {

    @Override
    public FieldResponse transformToFieldResponse(ResponseDto.QuestionResponse source) {
        return null;
    }

    @Override
    public ResponseDto.QuestionResponse transformToFieldResponseDto(FieldResponse source) {
        return null;
    }
}
