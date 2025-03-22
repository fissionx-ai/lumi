package com.fissionx.lumi.service.impl;

import com.fissionx.lumi.entity.DataTypes;
import com.fissionx.lumi.entity.SettingsMeta;
import com.fissionx.lumi.repository.DataTypesRepository;
import com.fissionx.lumi.repository.SettingsMetaInfoRepository;
import com.fissionx.lumi.exceptions.DBUpsertException;
import com.fissionx.lumi.service.MetaInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MetaInfoServiceImpl implements MetaInfoService {
    private static final Logger logger = LoggerFactory.getLogger(FormServiceImpl.class);

    private final DataTypesRepository dataTypesRepository;
    private final SettingsMetaInfoRepository settingsMetaInfoRepository;

    public MetaInfoServiceImpl(DataTypesRepository dataTypesRepository, SettingsMetaInfoRepository settingsMetaInfoRepository) {
        this.dataTypesRepository = dataTypesRepository;
        this.settingsMetaInfoRepository = settingsMetaInfoRepository;
    }

    @Override
    public List<DataTypes> getDataTypes() {
        try{
            return dataTypesRepository.findAll();
        } catch (Exception exception){
        throw new DBUpsertException(exception.getMessage());
        }
    }

    @Override
    public List<DataTypes> addDataTypes(List<DataTypes> dataTypesList) {
        try{
            return dataTypesRepository.saveAll(dataTypesList);
        } catch (Exception exception){
            throw new DBUpsertException(exception.getMessage());
        }
    }

    @Override
    public List<SettingsMeta> getSettingsMetaInfo() {
        try{
            return settingsMetaInfoRepository.findAll();
        } catch (Exception exception){
            throw new DBUpsertException(exception.getMessage());
        }
    }

    @Override
    public List<SettingsMeta> addSettingsInfo(List<SettingsMeta> settingsMeta) {
        try{
            return settingsMetaInfoRepository.saveAll(settingsMeta);
        } catch (Exception exception){
            throw new DBUpsertException(exception.getMessage());
        }
    }
}
