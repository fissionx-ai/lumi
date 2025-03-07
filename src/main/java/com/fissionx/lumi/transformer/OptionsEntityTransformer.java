package com.fissionx.lumi.transformer;

import com.fissionx.form.store.entity.FieldOptions;
import com.fissionx.form.store.entity.Form;
import com.fissionx.form.store.transformers.FormTransformer;
import com.fissionx.form.store.transformers.OptionsTransformer;
import com.fissionx.lumi.model.rest.FormDto;
import com.fissionx.lumi.model.rest.QuestionDto;

public class OptionsEntityTransformer implements OptionsTransformer<QuestionDto.Option> {

    @Override
    public FieldOptions transformToOptions(QuestionDto.Option source) {
        return null;
    }

    @Override
    public QuestionDto.Option transformToOptionsDto(FieldOptions source) {
        return null;
    }
}
