package com.fissionx.lumi.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "data_types")
@Data
public class DataTypes {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private UUID id;
    private String name;
    private String description;
    private Boolean isActive;
    private Long minLength;
    private Long maxLimit;
    private Boolean isPremium;
    private String createdBy;
    private List<String> group;
    private Integer rank;
    private String tenantId;
    private Long createdAt;
    private Long updatedAt;
}
