package com.fissionx.lumi.repository;

import com.fissionx.lumi.entity.FieldType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FieldTypeRepository extends JpaRepository<FieldType, UUID> {

}
