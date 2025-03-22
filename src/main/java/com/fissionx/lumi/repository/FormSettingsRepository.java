package com.fissionx.lumi.repository;

import com.fissionx.lumi.entity.FormSettings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface FormSettingsRepository extends JpaRepository<FormSettings, UUID> {
    @Query(value = "SELECT * FROM form_settings WHERE form_id = :formId", nativeQuery = true)
    List<FormSettings> findByFormId(String formId);

    @Query(value = "DELETE FROM form_settings WHERE form_id = ':formId'", nativeQuery = true)
    void deleteByFormId(String formId);
}
