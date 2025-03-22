package com.fissionx.lumi.repository;

import com.fissionx.lumi.entity.FieldOptions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface FieldOptionRepository extends JpaRepository<FieldOptions, UUID> {

    @Query(value = "SELECT * FROM field_options WHERE field_id = :fieldId", nativeQuery = true)
    List<FieldOptions> findByFieldId(String fieldId);

    @Query(value = "DELETE FROM field_options WHERE field_id = ':fieldId'", nativeQuery = true)
    void deleteByFieldId(String fieldId);
}
