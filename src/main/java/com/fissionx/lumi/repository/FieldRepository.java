package com.fissionx.lumi.repository;

import com.fissionx.lumi.entity.Field;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


@Repository
public interface FieldRepository extends JpaRepository<Field, UUID> {
    @Query(value = "SELECT * FROM field WHERE form_id = :formId", nativeQuery = true)
    List<Field> findByFormId(String formId);

    @Query(value = "DELETE FROM field WHERE form_id = ':formId'", nativeQuery = true)
    void deleteByFormId(String formId);
}
