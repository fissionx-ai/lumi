package com.fissionx.lumi.transformers;

import com.fissionx.lumi.entity.Field;

public interface FieldsTransformer<A> {
    Field transformToFields(A source);
    A transformToFieldsDto(Field source);
}
