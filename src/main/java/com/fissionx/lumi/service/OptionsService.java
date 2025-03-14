package com.fissionx.lumi.service;

import com.fissionx.lumi.model.rest.OptionsDto;

import java.util.List;

public interface OptionsService {
    OptionsDto addOption(OptionsDto createReq, String questionId);
    List<OptionsDto> addOptions(List<OptionsDto> addOptionsDtos, String questionId);
    OptionsDto updateOptions(OptionsDto updateReq);
    List<OptionsDto> getOptionsByQuestionId(String questionId);
}
