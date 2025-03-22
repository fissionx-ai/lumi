package com.fissionx.lumi.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "form")
@Data
public class Form {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private UUID formId;
    private String userId;
    private String workspaceId;
    private String title;
    private String description;
    private String state; //draft, published
    private Boolean isPublished;
    private Boolean isPublic;
    private Boolean isFavourites;
    private Long createdAt;
    private Long updatedAt;
}
