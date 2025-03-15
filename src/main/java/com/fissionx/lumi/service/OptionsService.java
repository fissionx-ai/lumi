package com.fissionx.lumi.service;

import com.fissionx.lumi.model.rest.OptionsDto;

import java.util.List;

public interface OptionsService {
    OptionsDto addOption(OptionsDto createReq, String questionId);
    List<OptionsDto> addOrUpdateOptions(List<OptionsDto> addOptionsDtos, String questionId);
    List<OptionsDto> getOptionsByQuestionId(String questionId);
    Boolean deleteOptions(String questionId);
}
