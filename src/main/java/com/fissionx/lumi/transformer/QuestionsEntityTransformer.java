package com.fissionx.lumi.transformer;

import com.fissionx.form.store.entity.Field;
import com.fissionx.form.store.entity.Form;
import com.fissionx.form.store.transformers.FieldsTransformer;
import com.fissionx.form.store.transformers.FormTransformer;
import com.fissionx.lumi.model.rest.FormDto;
import com.fissionx.lumi.model.rest.QuestionDto;

public class QuestionsEntityTransformer implements FieldsTransformer<QuestionDto>{

    @Override
    public Field transformToFields(QuestionDto source) {
        Field field=new Field();
        field.setFieldDetails(source.getQuestion());
        field.setFieldTypeId(source.getTypeId());
       return null;
    }

    @Override
    public QuestionDto transformToFieldsDto(Field source) {
        return null;
    }
}
