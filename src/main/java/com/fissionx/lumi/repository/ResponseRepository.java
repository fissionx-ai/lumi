package com.fissionx.lumi.repository;

import com.fissionx.lumi.entity.Response;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ResponseRepository extends JpaRepository<Response, UUID> {
    @Query(value = "SELECT * FROM response WHERE form_id = :formId AND user_id = :userId", nativeQuery = true)
    Response findByFormAndUserId(String formId, String userId);

    @Query(value = "SELECT * FROM response WHERE form_id = :formId", nativeQuery = true)
    List<Response> findByFormId(String formId);

    @Query(value = "DELETE FROM form_style WHERE form_id = :formId AND user_id = :userId", nativeQuery = true)
    void deleteByFormIdAndUserId(String formId, String userId);
}
