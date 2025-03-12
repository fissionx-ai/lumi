package com.fissionx.lumi.service;

import com.fissionx.lumi.model.rest.FormDto;
import com.fissionx.lumi.model.rest.QuestionDto;
import com.fissionx.lumi.model.rest.SettingsDto;

import java.util.List;

public interface QuestionsService {
    List<QuestionDto> addQuestions(List<QuestionDto> createReq, String formId);
    QuestionDto updateQuestion(QuestionDto updateReq);
    QuestionDto getQuestionId(String questionId);
    List<QuestionDto> getQuestionByFormId(String formId);
}
