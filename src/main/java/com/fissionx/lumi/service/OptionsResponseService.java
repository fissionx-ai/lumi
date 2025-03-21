package com.fissionx.lumi.service;

import com.fissionx.lumi.model.rest.OptionsResponseDto;
import com.fissionx.lumi.model.rest.QuestionResponseDto;

import java.util.List;

public interface OptionsResponseService {
    List<OptionsResponseDto> getOptionsResponseByQuestionId(String questionId);
    List<OptionsResponseDto> addOrUpdateOptionsResponse(List<OptionsResponseDto> optionsResponseDtoList, String responseId);
    Boolean deleteOptionsResponseByQuestionId(String questionId);


}
