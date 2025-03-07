package com.fissionx.lumi.transformer;

import com.fissionx.form.store.entity.Form;
import com.fissionx.form.store.entity.Response;
import com.fissionx.form.store.transformers.FormTransformer;
import com.fissionx.form.store.transformers.ResponseTransformer;
import com.fissionx.lumi.model.rest.FormDto;
import com.fissionx.lumi.model.rest.ResponseDto;

public class ResponseEntityTransformer implements ResponseTransformer<ResponseDto> {

    @Override
    public Response transformToResponse(ResponseDto source) {
        return null;
    }

    @Override
    public ResponseDto transformToResponseDto(Response source) {
        return null;
    }
}
