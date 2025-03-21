package com.fissionx.lumi.model.rest.response;

import com.fissionx.form.store.entity.SettingsMeta;
import lombok.Data;

import java.util.List;

@Data
public class SettingsInfoResponse {
    private List<SettingsMeta> settingsMetaList;
}
