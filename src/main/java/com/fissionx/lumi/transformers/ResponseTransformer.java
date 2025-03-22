package com.fissionx.lumi.transformers;

import com.fissionx.lumi.entity.Response;

public interface ResponseTransformer<A> {
    Response transformToResponse(A source);
    A transformToResponseDto(Response source);

}
