package com.fissionx.lumi.transformer;

import com.fissionx.form.store.entity.FieldOptions;
import com.fissionx.form.store.transformers.OptionsTransformer;
import com.fissionx.lumi.model.rest.Option;
import com.fissionx.lumi.model.rest.QuestionDto;
import org.springframework.stereotype.Component;

@Component
public class OptionsEntityTransformer implements OptionsTransformer<Option> {

    @Override
    public FieldOptions transformToOptions(Option source) {
        FieldOptions fieldOptions=new FieldOptions();
        fieldOptions.setFieldId(source.getQuestionId());
        fieldOptions.setOptionValue(source.getValue());
        fieldOptions.setCreatedAt(System.currentTimeMillis());
        fieldOptions.setUpdatedAt(System.currentTimeMillis());
        return fieldOptions;
    }

    @Override
    public Option transformToOptionsDto(FieldOptions source) {
        Option options=new Option();
        options.setQuestionId(source.getFieldId());
        options.setOptionId(source.getOptionId());
        options.setValue(source.getOptionValue());
        options.setCreatedAt(System.currentTimeMillis());
        options.setUpdatedAt(System.currentTimeMillis());
        return options;
    }
}
