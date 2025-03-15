package com.fissionx.lumi.service;

import com.fissionx.lumi.model.rest.StyleDto;

public interface StyleService {
    StyleDto addOrUpdateStyle(StyleDto createReq,String formId);
    StyleDto getStyleByFormId(String formId);
    StyleDto getStyleById(String styleId);
    Boolean deleteByFormId(String formId);

}
