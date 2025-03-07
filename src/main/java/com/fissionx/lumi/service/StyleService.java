package com.fissionx.lumi.service;

import com.fissionx.lumi.model.rest.StyleDto;

public interface StyleService {
    StyleDto addStyle(StyleDto createReq);
    StyleDto updateStyle(StyleDto updateReq);
    StyleDto getStyleByFormId(String formId);
    StyleDto getStyleById(String styleId);
}
