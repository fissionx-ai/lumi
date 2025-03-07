package com.fissionx.lumi.transformer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fissionx.form.store.entity.Form;
import com.fissionx.form.store.entity.FormStyle;
import com.fissionx.form.store.transformers.FormTransformer;
import com.fissionx.form.store.transformers.StyleTransformer;
import com.fissionx.lumi.model.rest.FormDto;
import com.fissionx.lumi.model.rest.StyleDto;

public class StyleEntityTransformer implements StyleTransformer<StyleDto> {

    private final ObjectMapper mapper=new ObjectMapper();

    @Override
    public FormStyle transformToStyle(StyleDto source) {
        FormStyle formStyle=new FormStyle();
        try {
            formStyle.setButtonStyle(mapper.writeValueAsString(source.getButtonStyle()));
            formStyle.setFormId(source.getFormId());
            formStyle.setFont(mapper.writeValueAsString(source.getFont()));
            formStyle.setTheme(source.getTheme());
            formStyle.setBackgroundColor(source.getBackgroundColor());
            formStyle.setPrimaryColor(source.getPrimaryColor());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return formStyle;
    }

    @Override
    public StyleDto transformToStyle(FormStyle source) {

        StyleDto styleDto=new StyleDto();
        try {
            styleDto.setButtonStyle(mapper.readValue(source.getButtonStyle(), StyleDto.ButtonStyle.class));
            styleDto.setFormId(source.getFormId());
            styleDto.setFont(mapper.readValue(source.getFont(), StyleDto.Font.class));
            styleDto.setTheme(source.getTheme());
            styleDto.setBackgroundColor(source.getBackgroundColor());
            styleDto.setPrimaryColor(source.getPrimaryColor());
            styleDto.setStyleId(source.getStyleId());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return styleDto;
    }
}
