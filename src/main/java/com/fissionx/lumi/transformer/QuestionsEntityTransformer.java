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
        field.setFormId(source.getFormId());
//        field.setIsRequired(source.isRequired());
        field.setCreatedAt(System.currentTimeMillis());
        field.setUpdatedAt(System.currentTimeMillis());

       return field;
    }

    @Override
    public QuestionDto transformToFieldsDto(Field source) {
        QuestionDto questionDto=new QuestionDto();
        questionDto.setQuestion(source.getFieldDetails());
        questionDto.setTypeId(source.getFieldTypeId());
        questionDto.setQuestionId(source.getFieldId());
        questionDto.setFormId(source.getFormId());
//        questionDto.setIsRequired(source.isRequired());
        questionDto.setCreatedAt(System.currentTimeMillis());
        questionDto.setUpdatedAt(System.currentTimeMillis());

        return questionDto;
    }
}
