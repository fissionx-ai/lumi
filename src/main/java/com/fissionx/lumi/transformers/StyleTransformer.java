package com.fissionx.lumi.transformers;

import com.fissionx.lumi.entity.FormStyle;

public interface StyleTransformer<A> {
    FormStyle transformToStyle(A source);
    A transformToStyle(FormStyle source);

}
