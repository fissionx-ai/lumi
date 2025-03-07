package com.fissionx.lumi.service.impl;

import com.fissionx.lumi.model.rest.QuestionDto;
import com.fissionx.lumi.service.QuestionsService;

import java.util.List;

public class QuestionServiceImpl implements QuestionsService {
    @Override
    public QuestionDto addQuestions(QuestionDto createReq) {
        return null;
    }

    @Override
    public QuestionDto updateQuestion(QuestionDto updateReq) {
        return null;
    }

    @Override
    public QuestionDto getQuestionId(String questionId) {
        return null;
    }

    @Override
    public List<QuestionDto> getQuestionByFormId(String formId) {
        return List.of();
    }
}
