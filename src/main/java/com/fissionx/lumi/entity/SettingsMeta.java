package com.fissionx.lumi.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "settings_meta_info")
@Data
public class SettingsMeta {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private UUID id;
    private String tenantId;
    private Boolean isActive;
    private Boolean isPremium;
    private String mapName;
    private String createdBy;
    private String dataType;
    private Long createdAt;
    private Long updatedAt;
}
