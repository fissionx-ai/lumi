package com.fissionx.lumi.transformer;

import com.fissionx.lumi.entity.Field;
import com.fissionx.lumi.transformers.FieldsTransformer;
import com.fissionx.lumi.model.rest.QuestionDto;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class QuestionsEntityTransformer implements FieldsTransformer<QuestionDto>{

    @Override
    public Field transformToFields(QuestionDto source) {
        Field field=new Field();
        field.setFieldDetails(source.getQuestion());
        field.setFieldTypeId(source.getTypeId());
        field.setFormId(source.getFormId());
        field.setIsRequired(source.isRequired());
        field.setCreatedAt(System.currentTimeMillis());
        field.setUpdatedAt(System.currentTimeMillis());
        if(source.getQuestionId()!=null){
            field.setFieldId(UUID.fromString(source.getQuestionId()));
            field.setCreatedAt(source.getCreatedAt());
        }else{
            field.setUpdatedAt(System.currentTimeMillis());
            field.setCreatedAt(System.currentTimeMillis());
        }
       return field;
    }

    @Override
    public QuestionDto transformToFieldsDto(Field source) {
        QuestionDto questionDto=new QuestionDto();
        questionDto.setQuestion(source.getFieldDetails());
        questionDto.setTypeId(source.getFieldTypeId());
        questionDto.setQuestionId(source.getFieldId().toString());
        questionDto.setFormId(source.getFormId());
        questionDto.setRequired(source.getIsRequired());
        return questionDto;
    }
}
