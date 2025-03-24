package com.fissionx.lumi.transformer;

import com.fissionx.lumi.entity.Response;
import com.fissionx.lumi.transformers.ResponseTransformer;
import com.fissionx.lumi.model.rest.ResponseDto;
import com.fissionx.lumi.model.rest.response.FormWithSubmissionData;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ResponseEntityTransformer implements ResponseTransformer<ResponseDto> {

    @Override
    public Response transformToResponse(ResponseDto source) {
        Response response=new Response();
        response.setFormId(source.getFormId());
        response.setUserId(source.getUserId());
        response.setSubmissionStatus(source.getSubmissionStatus());
        if(source.getResponseId()!=null){
            response.setResponseId(UUID.fromString(source.getResponseId()));
            response.setSubmittedAt(source.getSubmittedAt());
        }else {
            response.setSubmittedAt(System.currentTimeMillis());
        }
        response.setUpdatedAt(System.currentTimeMillis());
        return response;
    }

    @Override
    public ResponseDto transformToResponseDto(Response source) {
        ResponseDto responseDto=new ResponseDto();
        responseDto.setFormId(source.getFormId());
        responseDto.setUserId(source.getUserId());
        responseDto.setResponseId(source.getResponseId().toString());
        responseDto.setSubmittedAt(source.getSubmittedAt());
        responseDto.setSubmissionStatus(source.getSubmissionStatus());

        return responseDto;
    }
}
