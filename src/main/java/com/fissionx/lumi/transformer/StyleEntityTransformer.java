package com.fissionx.lumi.transformer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fissionx.lumi.entity.FormStyle;
import com.fissionx.lumi.transformers.StyleTransformer;
import com.fissionx.lumi.model.rest.StyleDto;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
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
            if(source.getStyleId()!=null){
                formStyle.setStyleId(UUID.fromString(source.getStyleId()));
            }
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
            styleDto.setStyleId(source.getStyleId().toString());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return styleDto;
    }
}
