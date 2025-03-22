package com.fissionx.lumi.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "form_style")
@Data
public class FormStyle {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private UUID styleId;
    private String formId;
    private String theme;
    private String primaryColor;
    private String backgroundColor;
    private String font;
    private String buttonStyle;
}
