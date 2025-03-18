package com.fissionx.lumi.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fissionx.form.store.entity.Response;
import com.fissionx.form.store.repository.ResponseRepository;
import com.fissionx.lumi.model.rest.*;
import com.fissionx.lumi.model.rest.response.FormWithSubmissionData;
import com.fissionx.lumi.service.FormsService;
import com.fissionx.lumi.service.OptionsResponseService;
import com.fissionx.lumi.service.ResponseService;
import com.fissionx.lumi.transformer.ResponseEntityTransformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResponseServiceImpl implements ResponseService {
    private static final Logger logger = LoggerFactory.getLogger(ResponseServiceImpl.class);

    private final FormsService formsService;
    private final ResponseRepository responseRepository;
    private final OptionsResponseService optionsResponseService;
    private final ResponseEntityTransformer responseEntityTransformer;
    private final ObjectMapper mapper=new ObjectMapper();

    public ResponseServiceImpl(FormsService formsService, ResponseRepository responseRepository, OptionsResponseService optionsResponseService, ResponseEntityTransformer responseEntityTransformer) {
        this.formsService = formsService;
        this.responseRepository = responseRepository;
        this.optionsResponseService = optionsResponseService;
        this.responseEntityTransformer = responseEntityTransformer;
    }

    @Override
    public FormWithSubmissionData getForm(String formId, String userId) {
        FormDto formDto=formsService.getFormById(formId);
        FormWithSubmissionData formWithSubmissionData=mapper.convertValue(formDto,FormWithSubmissionData.class );
        if(isResponseExistByUserId(userId,formId)){
            ResponseDto responseDto=getResponseByFormAndUserId(formId,userId);
            formWithSubmissionData.setSubmissionStatus(responseDto.getSubmissionStatus());
            formWithSubmissionData.setResponseId(responseDto.getResponseId());
            formWithSubmissionData.setSubmittedAt(responseDto.getSubmittedAt());
        }
        List<QuestionResponseDto> questionResponseDtos=formDto.getQuestions().stream().map(question->{
            QuestionResponseDto questionResponseDto=mapper.convertValue(question,QuestionResponseDto.class );
            List<OptionsResponseDto> optionsResponseDtoList=question.getOptions().stream().map(optionsDto -> {
                return mapper.convertValue(optionsDto,OptionsResponseDto.class );
            }).toList();
            questionResponseDto.setOptions(optionsResponseDtoList);
            return questionResponseDto;
        }).toList();

        formWithSubmissionData.setQuestionWithAnswers(questionResponseDtos);
        return formWithSubmissionData;
    }

    @Override
    public ResponseDto getResponseByFormAndUserId(String formId, String userId) {
        Response response= responseRepository.findByFormAndUserId(formId,userId);
        return responseEntityTransformer.transformToResponseDto(response);
    }

    @Override
    public FormWithSubmissionData formSubmission(FormWithSubmissionData formWithSubmissionData) {
        return null;
    }

    @Override
    public Boolean deleteResponse(String responseId, String formId) {
        return null;
    }

    @Override
    public Boolean isResponseExistByUserId(String userId, String formId) {
        Response response=responseRepository.findByFormAndUserId(formId,userId);
        if(response!=null){
            return true;
        }
        return false;
    }
}
