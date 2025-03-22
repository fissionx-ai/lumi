package com.fissionx.lumi.transformers;

import com.fissionx.lumi.entity.FieldOptions;

public interface OptionsTransformer<A> {
    FieldOptions transformToOptions(A source);
    A transformToOptionsDto(FieldOptions source);

}
