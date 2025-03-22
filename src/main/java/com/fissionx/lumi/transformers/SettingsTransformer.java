package com.fissionx.lumi.transformers;

import com.fissionx.lumi.entity.FormSettings;

public interface SettingsTransformer<A> {
    FormSettings transformToSettings(A source);
    A transformToSettingsDto(FormSettings source);

}
