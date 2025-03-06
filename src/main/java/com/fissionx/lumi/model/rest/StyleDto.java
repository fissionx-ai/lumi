package com.fissionx.lumi.model.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class StyleDto {
    private String theme;
    private String primaryColor;
    private String backgroundColor;
    private Font font;
    private ButtonStyle buttonStyle;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Font {
        private String fontFamily;
        private String fontSize;
        private String fontColor;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ButtonStyle {
        private String fontColor;
        private String backgroundColor;
        private String borderRadius;
        private String padding;
    }
}
