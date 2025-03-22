package com.fissionx.lumi.transformer;
import com.fissionx.lumi.entity.*;
import com.fissionx.lumi.transformers.FormTransformer;
import com.fissionx.lumi.model.rest.FormDto;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class FormsEntityTransformer implements FormTransformer<FormDto> {

    @Override
    public Form transformToForm(FormDto source) {
        Form form=new Form();
        form.setDescription(source.getDescription());
        form.setTitle(source.getTitle());
        form.setIsPublished(source.isPublished());
        form.setState(source.getState());
        form.setUserId(source.getUserId());
        form.setIsFavourites(source.getIsFavourites());
        form.setWorkspaceId(source.getWorkspaceId());
        if(source.getFormId()!=null){
            form.setFormId(UUID.fromString(source.getFormId()));
            form.setCreatedAt(source.getCreatedAt());
        }else{
            form.setUpdatedAt(System.currentTimeMillis());
            form.setCreatedAt(System.currentTimeMillis());
        }
        return form;
    }

    @Override
    public FormDto transformToFormDto(Form source) {
        FormDto formDto=new FormDto();
        formDto.setDescription(source.getDescription());
        formDto.setTitle(source.getTitle());
        formDto.setPublished(source.getIsPublished());
        formDto.setState(source.getState());
        formDto.setUserId(source.getUserId());
        formDto.setCreatedAt(source.getCreatedAt());
        formDto.setUpdatedAt(System.currentTimeMillis());
        formDto.setFormId(source.getFormId().toString());
        formDto.setWorkspaceId(source.getWorkspaceId());
        formDto.setIsFavourites(source.getIsFavourites());

        return formDto;
    }
}
