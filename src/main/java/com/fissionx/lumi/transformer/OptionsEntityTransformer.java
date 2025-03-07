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
        FieldOptions fieldOptions=new FieldOptions();
        fieldOptions.setFieldId(source.getQuestionId());
        fieldOptions.setOptionValue(source.getValue());
        fieldOptions.setCreatedAt(System.currentTimeMillis());
        fieldOptions.setUpdatedAt(System.currentTimeMillis());
        return fieldOptions;
    }

    @Override
    public QuestionDto.Option transformToOptionsDto(FieldOptions source) {
        QuestionDto.Option options=new QuestionDto.Option();
        options.setQuestionId(source.getFieldId());
        options.setOptionId(source.getOptionId());
        options.setValue(source.getOptionValue());
        options.setCreatedAt(System.currentTimeMillis());
        options.setUpdatedAt(System.currentTimeMillis());
        return options;
    }
}
