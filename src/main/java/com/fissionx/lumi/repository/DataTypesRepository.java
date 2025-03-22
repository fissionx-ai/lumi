package com.fissionx.lumi.repository;

import com.fissionx.lumi.entity.DataTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DataTypesRepository extends JpaRepository<DataTypes, UUID> {
}
