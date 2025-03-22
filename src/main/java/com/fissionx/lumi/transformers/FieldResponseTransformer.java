package com.fissionx.lumi.transformers;

import com.fissionx.lumi.entity.FieldResponse;

public interface FieldResponseTransformer<A> {
    FieldResponse transformToFieldResponse(A source);
    A transformToFieldResponseDto(FieldResponse source);
}
