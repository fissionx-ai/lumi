package com.fissionx.lumi.repository;

import com.fissionx.lumi.entity.FormStyle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface FormStyleRepository extends JpaRepository<FormStyle, UUID> {
    @Query(value = "SELECT * FROM form_style WHERE form_id = :formId", nativeQuery = true)
    List<FormStyle> findByFormId(String formId);

}
