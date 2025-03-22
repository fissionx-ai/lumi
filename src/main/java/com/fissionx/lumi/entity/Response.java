package com.fissionx.lumi.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "response")
@Data
public class Response {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private UUID responseId;
    private String formId;
    private String userId;
    private Long  submittedAt;
    private String submissionStatus;
    private Long updatedAt;
}
