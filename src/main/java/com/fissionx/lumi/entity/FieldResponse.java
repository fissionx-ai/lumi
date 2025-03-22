package com.fissionx.lumi.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "field_response")
@Data
public class FieldResponse {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private UUID fieldResponseId;
    private String responseId;
    private String fieldId;
    private String fieldOptionId;
    private String responseValue;
    private Boolean isSelected;
    private Long createdAt;
    private Long updatedAt;
}
