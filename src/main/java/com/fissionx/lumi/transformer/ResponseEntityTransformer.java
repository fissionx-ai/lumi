package com.fissionx.lumi.transformer;

import com.fissionx.form.store.entity.Response;
import com.fissionx.form.store.transformers.ResponseTransformer;
import com.fissionx.lumi.model.rest.ResponseDto;
import org.springframework.stereotype.Component;

@Component
public class ResponseEntityTransformer implements ResponseTransformer<ResponseDto> {

    @Override
    public Response transformToResponse(ResponseDto source) {
        Response response=new Response();
        response.setFormId(source.getFormId());
        response.setUserId(source.getUserId());
//        response.setSubmittedAt(System.currentTimeMillis());
//        response.setUpdatedAt(System.currentTimeMillis());
        return response;
    }

    @Override
    public ResponseDto transformToResponseDto(Response source) {
        ResponseDto responseDto=new ResponseDto();
        responseDto.setFormId(source.getFormId());
        responseDto.setUserId(source.getUserId());
        responseDto.setResponseId(source.getResponseId());
//        responseDto.setSubmittedAt(source.);
//        responseDto.setUpdatedAt(System.currentTimeMillis());

        return responseDto;
    }
}
