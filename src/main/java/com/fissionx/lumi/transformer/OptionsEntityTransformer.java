package com.fissionx.lumi.transformer;

import com.fissionx.form.store.entity.FieldOptions;
import com.fissionx.form.store.transformers.OptionsTransformer;
import com.fissionx.lumi.model.rest.OptionsDto;
import org.springframework.stereotype.Component;

@Component
public class OptionsEntityTransformer implements OptionsTransformer<OptionsDto> {

    @Override
    public FieldOptions transformToOptions(OptionsDto source) {
        FieldOptions fieldOptions=new FieldOptions();
        fieldOptions.setFieldId(source.getQuestionId());
        fieldOptions.setOptionValue(source.getValue());
        fieldOptions.setCreatedAt(System.currentTimeMillis());
        fieldOptions.setUpdatedAt(System.currentTimeMillis());
        return fieldOptions;
    }

    @Override
    public OptionsDto transformToOptionsDto(FieldOptions source) {
        OptionsDto options=new OptionsDto();
        options.setQuestionId(source.getFieldId());
        options.setOptionId(source.getOptionId());
        options.setValue(source.getOptionValue());
        options.setCreatedAt(System.currentTimeMillis());
        options.setUpdatedAt(System.currentTimeMillis());
        return options;
    }
}
