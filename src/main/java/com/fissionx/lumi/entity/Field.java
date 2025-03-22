package com.fissionx.lumi.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "field")
@Data
public class Field {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private UUID fieldId;
    private String formId;
    private String fieldDetails; // question
    private String fieldTypeId; //text, etc
    private Boolean isRequired;
    private Long createdAt;
    private Long updatedAt;
}
