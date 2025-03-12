package com.fissionx.lumi.service;

import com.fissionx.lumi.model.rest.StyleDto;

public interface StyleService {
    StyleDto addStyle(StyleDto createReq,String formId);
    StyleDto updateStyle(StyleDto updateReq,String formId);
    StyleDto getStyleByFormId(String formId);
    StyleDto getStyleById(String styleId);
}
