package com.fissionx.lumi.repository;

import com.fissionx.lumi.entity.Workspace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface WorkspaceRepository extends JpaRepository<Workspace, UUID> {
    @Query(value = "SELECT * FROM workspace WHERE user_id = :userId", nativeQuery = true)
    List<Workspace> findByUserId(String userId);
}
