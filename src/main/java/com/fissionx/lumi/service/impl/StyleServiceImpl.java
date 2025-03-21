package com.fissionx.lumi.service.impl;

import com.fissionx.form.store.entity.FormSettings;
import com.fissionx.form.store.entity.FormStyle;
import com.fissionx.form.store.repository.FormStyleRepository;
import com.fissionx.lumi.exceptions.DBUpsertException;
import com.fissionx.lumi.exceptions.NotFoundException;
import com.fissionx.lumi.model.rest.StyleDto;
import com.fissionx.lumi.transformer.StyleEntityTransformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StyleServiceImpl implements com.fissionx.lumi.service.StyleService {
    private static final Logger logger = LoggerFactory.getLogger(StyleServiceImpl.class);

    private final FormStyleRepository formStyleRepository;
    private final StyleEntityTransformer styleEntityTransformer;

    public StyleServiceImpl(FormStyleRepository formStyleRepository, StyleEntityTransformer styleEntityTransformer) {
        this.formStyleRepository = formStyleRepository;
        this.styleEntityTransformer = styleEntityTransformer;
    }

    @Override
    public StyleDto addOrUpdateStyle(StyleDto createReq, String formId) {
        try {
            createReq.setFormId(formId);
            FormStyle formsSetting = styleEntityTransformer.transformToStyle(createReq);
            FormStyle settingFromDB = formStyleRepository.save(formsSetting);
            return styleEntityTransformer.transformToStyle(settingFromDB);
        }catch (Exception exception){
                throw new DBUpsertException(exception.getMessage());
        }
    }

    @Override
    public StyleDto getStyleByFormId(String formId) {
        try{
            List<FormStyle> formStyles=formStyleRepository.findByFormId(formId);
            if(formStyles.isEmpty()){
                logger.error("There is no settings found for formId: "+formId);
                return new StyleDto();
                //throw new NotFoundException("There is no settings found for workspaceId: "+formId);
            }
            return formStyles.stream().map( styleEntityTransformer::transformToStyle).toList().getFirst();
        }catch (Exception exception){
            throw new DBUpsertException(exception.getMessage());
        }
    }

    @Override
    public StyleDto getStyleById(String styleId) {
        return null;
    }

    @Override
    public Boolean deleteByFormId(String formId) {
        try {
        formStyleRepository.deleteByFormId(formId);
        return true;
    }catch (Exception exception){
        throw new DBUpsertException(exception.getMessage());
    }
    }
}
