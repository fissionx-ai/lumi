package com.fissionx.lumi.service.impl;

import com.fissionx.form.store.entity.FormStyle;
import com.fissionx.form.store.repository.FormStyleRepository;
import com.fissionx.lumi.exceptions.DBUpsertException;
import com.fissionx.lumi.model.rest.StyleDto;
import com.fissionx.lumi.transformer.StyleEntityTransformer;
import org.springframework.stereotype.Service;

@Service
public class StyleServiceImpl implements com.fissionx.lumi.service.StyleService {
    private final FormStyleRepository formStyleRepository;
    private final StyleEntityTransformer styleEntityTransformer;

    public StyleServiceImpl(FormStyleRepository formStyleRepository, StyleEntityTransformer styleEntityTransformer) {
        this.formStyleRepository = formStyleRepository;
        this.styleEntityTransformer = styleEntityTransformer;
    }

    @Override
    public StyleDto addStyle(StyleDto createReq, String formId) {
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
    public StyleDto updateStyle(StyleDto updateReq, String formId) {
        return null;
    }

    @Override
    public StyleDto getStyleByFormId(String formId) {
        return null;
    }

    @Override
    public StyleDto getStyleById(String styleId) {
        return null;
    }
}
