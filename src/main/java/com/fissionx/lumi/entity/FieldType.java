package com.fissionx.lumi.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "field_type")
@Data
public class FieldType {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private UUID fieldTypeId;
    private String fieldType;
    private String createdAt;
    private String updatedAt;
    private String createdBy;
}
