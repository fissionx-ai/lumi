package com.fissionx.lumi.repository;

import com.fissionx.lumi.entity.FieldResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface FieldResponseRepository extends JpaRepository<FieldResponse, UUID> {
    @Query(value = "SELECT * FROM field_response WHERE field_id = :fieldId", nativeQuery = true)
    List<FieldResponse> findByFieldId(String fieldId);

    @Query(value = "DELETE FROM field_response WHERE field_id = :fieldId", nativeQuery = true)
    void deleteByFieldId(String fieldId);
}
