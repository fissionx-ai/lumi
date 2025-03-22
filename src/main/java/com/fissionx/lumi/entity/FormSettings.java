package com.fissionx.lumi.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "form_settings")
@Data
public class FormSettings {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private UUID settingId;
    private String formId;
    private Boolean allowPublic;
    private Long maxResponseThreshold;
    private Long activationStartTime;
    private Long expiryTime;
    private Boolean shuffleQuestions;
    private Boolean allowMultipleResponse;
    private String thankYouMessage;
    private Long createdAt;
    private Long updatedAt;
}
