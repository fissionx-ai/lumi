package com.fissionx.lumi.repository;

import com.fissionx.lumi.entity.Form;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface FormRepository extends JpaRepository<Form, UUID> {
    @Query(value = "SELECT * FROM form WHERE user_id = :userId", nativeQuery = true)
    List<Form> findByUserId(String userId);

    @Query(value = "SELECT * FROM form WHERE workspace_id = :workspaceId", nativeQuery = true)
    List<Form> findByWorkspaceId(String workspaceId);


}
