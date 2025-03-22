package com.fissionx.lumi.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "field_options")
@Data
public class FieldOptions {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private UUID optionId;
    private String fieldId;
    private String optionText;
    private String optionValue;
    private Long createdAt;
    private Long updatedAt;
}
