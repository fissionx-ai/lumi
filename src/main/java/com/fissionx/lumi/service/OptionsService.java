package com.fissionx.lumi.service;

import com.fissionx.lumi.model.rest.Option;

import java.util.List;

public interface OptionsService {
    Option addOption(Option createReq,String questionId);
    List<Option> addOptions(List<Option> addOptions, String questionId);
    Option updateOptions(Option updateReq);
    Option getOptionsId(String questionId);
    List<Option> getOptionsByFormId(String formId);
}
