package com.fissionx.lumi.service;

import com.fissionx.lumi.model.rest.FormDto;
import com.fissionx.lumi.model.rest.QuestionDto;
import com.fissionx.lumi.model.rest.SettingsDto;

import java.util.List;

public interface QuestionsService {
    QuestionDto addQuestions(QuestionDto createReq);
    QuestionDto updateQuestion(QuestionDto updateReq);
    QuestionDto getQuestionId(String questionId);
    List<QuestionDto> getQuestionByFormId(String formId);
}
