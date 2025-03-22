package com.fissionx.lumi.transformers;

import com.fissionx.lumi.entity.Form;

public interface FormTransformer<A> {
    Form transformToForm(A source);
    A transformToFormDto(Form source);
}
