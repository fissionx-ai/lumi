package com.fissionx.lumi.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "workspace")
@Data
public class Workspace {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private UUID workspaceId;
    private String userId;
    private String title;
    private String description;
    private List<String> formIds;
    private Long createdAt;
    private Long updatedAt;
}
